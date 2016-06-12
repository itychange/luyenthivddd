package com.lthdl.app.model;

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


    @SerializedName("thumbnail")
    public String thumbnail;

    @SerializedName("tienThuong")
    public String tienThuong;

    @SerializedName("birthday")
    public String birthday;

    @SerializedName("location")
    public String location;

    @SerializedName("role")
    public String role;


    @SerializedName("gender")
    public String gender;
    @SerializedName("soDu")
    public String soDu;


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


    public String getThumbnail() {
        return thumbnail;
    }

    public String getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(String tienThuong) {
        this.tienThuong = tienThuong;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSoDu() {
        return soDu;
    }

    public void setSoDu(String soDu) {
        this.soDu = soDu;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public User() {
    }

    public User(String social_id, String social_token, String email,String name, String birthday, String gender, String location, String bonus, String role, String balances, String avatar) {
        this.email = email;
        this.social_id = social_id;
        this.social_token = social_token;
        this.name = name;
        this.soDu= balances;
        this.thumbnail = avatar;
        this.tienThuong = bonus;
        this.birthday = birthday;
        this.role = role;
        this.location = location;
        this.gender = gender;
    }
}