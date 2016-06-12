package com.lthdl.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by THANHHUNGPHAT on 11/06/2016.
 */
public class IMyBooks {
    @SerializedName("id")
    public String id;
    @SerializedName("description")
    public String description;
    @SerializedName("oderby")
    public String oderby;
    @SerializedName("rate")
    public String rate;
    @SerializedName("isbanner")
    public String isbanner;
    @SerializedName("role")
    public String role;
    @SerializedName("user_buy")
    public String user_buy;
    @SerializedName("price")
    public String price;
    @SerializedName("view")
    public String view;
    @SerializedName("name")
    public String name;
    @SerializedName("cat_id")
    public String cat_id;
    @SerializedName("chap_id")
    public String chap_id;
    @SerializedName("author")
    public String author;
    @SerializedName("conver")
    public String conver;
    @SerializedName("is_buy")
    public String is_buy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOderby() {
        return oderby;
    }

    public void setOderby(String oderby) {
        this.oderby = oderby;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getIsbanner() {
        return isbanner;
    }

    public void setIsbanner(String isbanner) {
        this.isbanner = isbanner;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser_buy() {
        return user_buy;
    }

    public void setUser_buy(String user_buy) {
        this.user_buy = user_buy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getChap_id() {
        return chap_id;
    }

    public void setChap_id(String chap_id) {
        this.chap_id = chap_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getConver() {
        return conver;
    }

    public void setConver(String conver) {
        this.conver = conver;
    }

    public String getIs_buy() {
        return is_buy;
    }

    public void setIs_buy(String is_buy) {
        this.is_buy = is_buy;
    }
}
