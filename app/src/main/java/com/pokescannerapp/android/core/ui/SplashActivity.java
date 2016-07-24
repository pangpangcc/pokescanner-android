package com.pokescannerapp.android.core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pokescannerapp.android.R;
import com.pokescannerapp.android.pokemon.ui.NearbyPokemonActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent i = new Intent(this, NearbyPokemonActivity.class);
        startActivity(i);
        finish();

    }
}
