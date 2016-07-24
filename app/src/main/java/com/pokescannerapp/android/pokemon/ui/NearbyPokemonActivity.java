package com.pokescannerapp.android.pokemon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pokescannerapp.android.MainApplication;
import com.pokescannerapp.android.R;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class NearbyPokemonActivity extends AppCompatActivity {

    @Inject
    Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_nearby_pokemon);
    }
}
