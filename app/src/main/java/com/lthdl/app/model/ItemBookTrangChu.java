package com.lthdl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THANHHUNGPHAT on 12/06/2016.
 */
public class ItemBookTrangChu {

    @SerializedName("items")
    @Expose
    private List<ItemBook> myBookses = new ArrayList<ItemBook>();
    public List<ItemBook> getMyBookses() {
        return myBookses;
    }

    public void setMyBookses(List<ItemBook> myBookses) {
        this.myBookses = myBookses;
    }

}
