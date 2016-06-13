package com.lthdl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by THANHHUNGPHAT on 13/06/2016.
 */
public class Book_id {
    @SerializedName("items")
    @Expose
    private ArrayList<IMyBooks> myBookses = new ArrayList<IMyBooks>();

    public ArrayList<IMyBooks> getMyBookses() {
        return myBookses;

    }
}
