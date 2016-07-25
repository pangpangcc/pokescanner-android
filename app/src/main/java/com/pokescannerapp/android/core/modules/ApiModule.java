package com.pokescannerapp.android.core.modules;

import com.pokescannerapp.android.pokemon.services.PokemonService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public PokemonService pokemonServiceProvider(Retrofit retrofit) {
        return retrofit.create(PokemonService.class);
    }

}
