package com.lthdl.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by THANHHUNGPHAT on 09/06/2016.
 */
public class MenuNgang {
    @SerializedName("oderby")
    public String oderby;
    @SerializedName("cat_ids")

    public String cat_ids;
    @SerializedName("menu_type")

    public String menu_type;
    @SerializedName("name")

    public String name;
    @SerializedName("id")

    public String id;

    public String getOderby() {
        return oderby;
    }

    public void setOderby(String oderby) {
        this.oderby = oderby;
    }

    public String getCat_ids() {
        return cat_ids;
    }

    public void setCat_ids(String cat_ids) {
        this.cat_ids = cat_ids;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
