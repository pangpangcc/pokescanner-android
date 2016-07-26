package com.pokescannerapp.android.pokemon.presenters;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.pokescannerapp.android.core.models.LocationInput;
import com.pokescannerapp.android.pokemon.models.WildPokemon;
import com.pokescannerapp.android.pokemon.services.PokemonService;
import com.pokescannerapp.android.pokemon.views.NearbyPokemonView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NearbyPokemonPresenter extends MvpBasePresenter<NearbyPokemonView> {

    private static final String TAG = "NearbyPokemonPresenter";

    PokemonService mPokemonService;

    public NearbyPokemonPresenter(PokemonService pokemonService) {
        mPokemonService = pokemonService;
    }

    public void loadPokemon(LocationInput locationInput) {
        mPokemonService.getWildPokemon(locationInput)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<WildPokemon>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if(isViewAttached()) {
                            getView().showError("Network request failed.");
                        }
                    }

                    @Override
                    public void onNext(List<WildPokemon> wildPokemons) {
                        Log.d(TAG, "onNext() called with: " + "wildPokemons = [" + wildPokemons + "]");
                        if (isViewAttached()) {
                            getView().showPokemon(wildPokemons);
                        }
                    }
                });
    }
}
