package com.pokescannerapp.android.pokemon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokedexEntry {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("candy")
    @Expose
    private String candy;
    @SerializedName("egg")
    @Expose
    private String egg;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The num
     */
    public String getNum() {
        return num;
    }

    /**
     *
     * @param num
     * The num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The img
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * @param img
     * The img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The height
     */
    public String getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     * The weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     * The candy
     */
    public String getCandy() {
        return candy;
    }

    /**
     *
     * @param candy
     * The candy
     */
    public void setCandy(String candy) {
        this.candy = candy;
    }

    /**
     *
     * @return
     * The egg
     */
    public String getEgg() {
        return egg;
    }

    /**
     *
     * @param egg
     * The egg
     */
    public void setEgg(String egg) {
        this.egg = egg;
    }
}
