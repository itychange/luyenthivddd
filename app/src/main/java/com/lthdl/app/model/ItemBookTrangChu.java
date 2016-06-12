package com.lthdl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THANHHUNGPHAT on 12/06/2016.
 */
public class ItemBookTrangChu {
    @SerializedName("oderby")
    String orderBy;
    @SerializedName("name")
    String name;
    @SerializedName("user_id")
    String user_id;
    @SerializedName("id")
    String id;
    @SerializedName("items")
    @Expose
    private List<ItemBook> myBookses = new ArrayList<ItemBook>();
    public List<ItemBook> getMyBookses() {
        return myBookses;
    }

    public void setMyBookses(List<ItemBook> myBookses) {
        this.myBookses = myBookses;
    }
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
