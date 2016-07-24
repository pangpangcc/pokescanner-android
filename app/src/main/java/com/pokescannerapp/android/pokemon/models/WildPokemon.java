package com.pokescannerapp.android.pokemon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WildPokemon {

    @SerializedName("EncounterId")
    @Expose
    private EncounterId encounterId;
    @SerializedName("LastModifiedMs")
    @Expose
    private LastModifiedMs lastModifiedMs;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("SpawnPointId")
    @Expose
    private String spawnPointId;
    @SerializedName("pokemon")
    @Expose
    private Pokemon pokemon;
    @SerializedName("TimeTillHiddenMs")
    @Expose
    private Integer timeTillHiddenMs;

    /**
     *
     * @return
     * The encounterId
     */
    public EncounterId getEncounterId() {
        return encounterId;
    }

    /**
     *
     * @param encounterId
     * The EncounterId
     */
    public void setEncounterId(EncounterId encounterId) {
        this.encounterId = encounterId;
    }

    /**
     *
     * @return
     * The lastModifiedMs
     */
    public LastModifiedMs getLastModifiedMs() {
        return lastModifiedMs;
    }

    /**
     *
     * @param lastModifiedMs
     * The LastModifiedMs
     */
    public void setLastModifiedMs(LastModifiedMs lastModifiedMs) {
        this.lastModifiedMs = lastModifiedMs;
    }

    /**
     *
     * @return
     * The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The Latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The Longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The spawnPointId
     */
    public String getSpawnPointId() {
        return spawnPointId;
    }

    /**
     *
     * @param spawnPointId
     * The SpawnPointId
     */
    public void setSpawnPointId(String spawnPointId) {
        this.spawnPointId = spawnPointId;
    }

    /**
     *
     * @return
     * The pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     *
     * @param pokemon
     * The pokemon
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     *
     * @return
     * The timeTillHiddenMs
     */
    public Integer getTimeTillHiddenMs() {
        return timeTillHiddenMs;
    }

    /**
     *
     * @param timeTillHiddenMs
     * The TimeTillHiddenMs
     */
    public void setTimeTillHiddenMs(Integer timeTillHiddenMs) {
        this.timeTillHiddenMs = timeTillHiddenMs;
    }

}
