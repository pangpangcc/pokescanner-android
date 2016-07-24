package com.pokescannerapp.android.pokemon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("Id")
    @Expose
    private Object id;
    @SerializedName("PokemonId")
    @Expose
    private Integer pokemonId;

    /**
     *
     * @return
     * The id
     */
    public Object getId() {
        return id;
    }

    /**
     *
     * @param id
     * The Id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The pokemonId
     */
    public Integer getPokemonId() {
        return pokemonId;
    }

    /**
     *
     * @param pokemonId
     * The PokemonId
     */
    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

}
