package com.pokescannerapp.android.core.components;

import com.pokescannerapp.android.core.modules.AppModule;
import com.pokescannerapp.android.core.modules.NetModule;
import com.pokescannerapp.android.pokemon.ui.NearbyPokemonActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(NearbyPokemonActivity nearbyPokemonActivity);
}
