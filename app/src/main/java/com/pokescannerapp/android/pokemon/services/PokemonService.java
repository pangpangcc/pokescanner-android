package com.pokescannerapp.android.pokemon.services;

import com.pokescannerapp.android.core.models.LocationInput;
import com.pokescannerapp.android.pokemon.models.WildPokemon;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface PokemonService {

    @POST("pokemon")
    Observable<List<WildPokemon>> getWildPokemon(@Body LocationInput location);

}
