package com.pokescannerapp.android.pokemon.views;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.pokescannerapp.android.pokemon.models.WildPokemon;

import java.util.List;

public interface NearbyPokemonView extends MvpView {

    void showPokemon(List<WildPokemon> wildPokemons);
    void showError(String errorMessage);

}
