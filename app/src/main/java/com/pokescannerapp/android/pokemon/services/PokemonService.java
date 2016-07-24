package com.pokescannerapp.android.pokemon.services;

import com.pokescannerapp.android.core.models.Location;
import com.pokescannerapp.android.pokemon.models.Pokemon;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import rx.Observable;

public interface PokemonService {

    @GET("pokemon/wild")
    Observable<List<Pokemon>> getWildPokemon(@Body Location location);

}
