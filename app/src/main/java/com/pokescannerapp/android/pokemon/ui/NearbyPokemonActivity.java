package com.pokescannerapp.android.pokemon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pokescannerapp.android.MainApplication;
import com.pokescannerapp.android.R;
import com.pokescannerapp.android.pokemon.adapters.NearbyPokemonAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class NearbyPokemonActivity extends AppCompatActivity {

    @Inject
    Retrofit mRetrofit;

    @BindView(R.id.rv_nearbypokemon)
    RecyclerView rvNearbyPokemon;

    ArrayList<String> mStringList = new ArrayList<>();
    NearbyPokemonAdapter mNearbyPokemonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication()).getAppComponent().inject(this);

        mStringList.add("Bulbasaur");
        mStringList.add("IvySaur");

        setContentView(R.layout.activity_nearby_pokemon);
        ButterKnife.bind(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvNearbyPokemon.setLayoutManager(mLayoutManager);
        mNearbyPokemonAdapter = new NearbyPokemonAdapter(mStringList);
        rvNearbyPokemon.setAdapter(mNearbyPokemonAdapter);
    }
}
