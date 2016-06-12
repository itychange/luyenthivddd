package com.lthdl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THANHHUNGPHAT on 11/06/2016.
 */
public class ItemBook {
    @SerializedName("items")
    @Expose
    private List<IMyBooks> myBookses = new ArrayList<IMyBooks>();

    public List<IMyBooks> getMyBookses() {
        return myBookses;
    }

    public void setMyBookses(List<IMyBooks> myBookses) {
        this.myBookses = myBookses;
    }
}
