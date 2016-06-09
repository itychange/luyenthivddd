package com.lthdl.app.model;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;
public class User {

    @SerializedName("email")
    public String email;

    @SerializedName("social_id")
    public String social_id;

    @SerializedName("social_token")
    public String social_token;

    @SerializedName("name")
    public String name;

    @SerializedName("soDu")
    public int soDu=0;

    @SerializedName("thumbnail")
    public String thumbnail;

    @SerializedName("tienThuong")
    public float tienThuong=0;

    @SerializedName("birthday")
    public String birthday;

    @SerializedName("role")
    public int role=5;

    @SerializedName("location")
    public String location;

    @SerializedName("gender")
    public String gender;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocial_id() {
        return social_id;
    }

    public void setSocial_id(String social_id) {
        this.social_id = social_id;
    }

    public String getSocial_token() {
        return social_token;
    }

    public void setSocial_token(String social_token) {
        this.social_token = social_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoDu() {
        return soDu;
    }

    public void setSoDu(int soDu) {
        this.soDu = soDu;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public float getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(float tienThuong) {
        this.tienThuong = tienThuong;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public User() {
    }

    public User(String email, String social_id, String social_token, String name, int soDu, String thumbnail, float tienThuong, String birthday, int role, String location, String gender) {
        this.email = email;
        this.social_id = social_id;
        this.social_token = social_token;
        this.name = name;
        this.soDu = soDu;
        this.thumbnail = thumbnail;
        this.tienThuong = tienThuong;
        this.birthday = birthday;
        this.role = role;
        this.location = location;
        this.gender = gender;
    }
}