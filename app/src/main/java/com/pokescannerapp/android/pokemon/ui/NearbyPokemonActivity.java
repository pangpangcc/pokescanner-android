package com.pokescannerapp.android.pokemon.ui;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.pokescannerapp.android.MainApplication;
import com.pokescannerapp.android.R;
import com.pokescannerapp.android.core.models.LocationInput;
import com.pokescannerapp.android.pokemon.adapters.NearbyPokemonAdapter;
import com.pokescannerapp.android.pokemon.models.PokedexEntry;
import com.pokescannerapp.android.pokemon.models.WildPokemon;
import com.pokescannerapp.android.pokemon.presenters.NearbyPokemonPresenter;
import com.pokescannerapp.android.pokemon.services.PokemonService;
import com.pokescannerapp.android.pokemon.views.NearbyPokemonView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.solodovnikov.rxlocationmanager.LocationTime;
import ru.solodovnikov.rxlocationmanager.RxLocationManager;
import rx.Subscriber;

public class NearbyPokemonActivity extends MvpActivity<NearbyPokemonView, NearbyPokemonPresenter> implements NearbyPokemonView {

    final int MY_PERMISSION_LOCATION = 1001;

    @Inject
    PokemonService mPokemonService;

    @BindView(R.id.rv_nearbypokemon)
    RecyclerView rvNearbyPokemon;

    ArrayList<String> mStringList = new ArrayList<>();
    NearbyPokemonAdapter mNearbyPokemonAdapter;

    Activity mActivity;
    RxLocationManager mRxLocationManager;
    NearbyPokemonPresenter mNearbyPokemonPresenter;
    List<PokedexEntry> mPokedexEntries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ((MainApplication) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);

        mActivity = this;

        mStringList.add("Bulbasaur");
        mStringList.add("IvySaur");

        setContentView(R.layout.activity_nearby_pokemon);
        ButterKnife.bind(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvNearbyPokemon.setLayoutManager(mLayoutManager);

        mRxLocationManager  = new RxLocationManager(this);
        readPokedex();
        locationPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    Log.d("test", "boo");
                }
            }
        }
    }

    @NonNull
    @Override
    public NearbyPokemonPresenter createPresenter() {
        return new NearbyPokemonPresenter(mPokemonService);
    }

    @Override
    public void showPokemon(List<WildPokemon> wildPokemons) {
        mNearbyPokemonAdapter = new NearbyPokemonAdapter(wildPokemons, mPokedexEntries);
        rvNearbyPokemon.setAdapter(mNearbyPokemonAdapter);
    }

    private void locationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSION_LOCATION);
        } else {
            getLocation();
        }
    }

    private void getLocation() {
        mNearbyPokemonPresenter = getPresenter();
        LocationInput locationInput = new LocationInput();
        locationInput.setLatitude(19.103078635);
        locationInput.setLongitude(72.886006189001);
        mNearbyPokemonPresenter.loadPokemon(locationInput);
        mRxLocationManager.requestLocation(LocationManager.GPS_PROVIDER, new LocationTime(45, TimeUnit.SECONDS)).subscribe(new Subscriber<Location>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Location location) {
                LocationInput locationInput = new LocationInput();
                locationInput.setLatitude(location.getLatitude());
                locationInput.setLongitude(location.getLongitude());
                mNearbyPokemonPresenter.loadPokemon(locationInput);
            }
        });
    }

    private void readPokedex() {
        try {
            InputStream is = getAssets().open("pokedex.json");
            Reader reader = new InputStreamReader(is);
            Gson gson = new Gson();
            mPokedexEntries = gson.fromJson(reader, new TypeToken<List<PokedexEntry>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
