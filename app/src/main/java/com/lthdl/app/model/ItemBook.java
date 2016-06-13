package com.lthdl.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by THANHHUNGPHAT on 11/06/2016.
 */
public class ItemBook {
    @SerializedName("oderby")
    String orderBy;
    @SerializedName("name")
    String name;
    @SerializedName("user_id")
    String user_id;
    @SerializedName("id")
    String id;
    @SerializedName("book_ids")
    Book_id book_ids;

    public Book_id getBook_ids() {
        return book_ids;
    }

    public void setBook_ids(Book_id book_ids) {
        this.book_ids = book_ids;
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
