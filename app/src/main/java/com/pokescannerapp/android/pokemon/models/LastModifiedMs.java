package com.pokescannerapp.android.pokemon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastModifiedMs {


    @SerializedName("low")
    @Expose
    private Integer low;
    @SerializedName("high")
    @Expose
    private Integer high;
    @SerializedName("unsigned")
    @Expose
    private Boolean unsigned;

    /**
     *
     * @return
     * The low
     */
    public Integer getLow() {
        return low;
    }

    /**
     *
     * @param low
     * The low
     */
    public void setLow(Integer low) {
        this.low = low;
    }

    /**
     *
     * @return
     * The high
     */
    public Integer getHigh() {
        return high;
    }

    /**
     *
     * @param high
     * The high
     */
    public void setHigh(Integer high) {
        this.high = high;
    }

    /**
     *
     * @return
     * The unsigned
     */
    public Boolean getUnsigned() {
        return unsigned;
    }

    /**
     *
     * @param unsigned
     * The unsigned
     */
    public void setUnsigned(Boolean unsigned) {
        this.unsigned = unsigned;
    }

}
