package com.pokescannerapp.android.pokemon.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.pokescannerapp.android.core.models.LocationInput;
import com.pokescannerapp.android.pokemon.models.Pokemon;
import com.pokescannerapp.android.pokemon.services.PokemonService;
import com.pokescannerapp.android.pokemon.views.NearbyPokemonView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NearbyPokemonPresenter extends MvpBasePresenter<NearbyPokemonView> {

    PokemonService mPokemonService;
    LocationInput mLocation;

    public NearbyPokemonPresenter(PokemonService pokemonService) {
        mPokemonService = pokemonService;
    }

    public void loadPokemon() {
        mPokemonService.getWildPokemon(mLocation)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Pokemon>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Pokemon> pokemons) {

                    }
                });
    }
}
