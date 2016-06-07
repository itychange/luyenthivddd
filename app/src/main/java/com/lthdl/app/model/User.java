package com.lthdl.app.model;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "User")
public class User {

    @Column(name = "email")
    public String email;

    @Column(name = "idFace")
    public String idFace;

    @Column(name = "fbToken")
    public String fbToken;

    @Column(name = "name")
    public String name;

    @Column(name = "soDu")
    public int soDu;

    @Column(name = "thumbnail")
    public String thumbnail;

    @Column(name = "tienThuong")
    public float tienThuong;


    public User(final String email, final String fbToken, final String idFace, final String name, final int soDu, final String thumbnail, final float tienThuong) {
        this.email = email;
        this.fbToken = fbToken;
        this.idFace = idFace;
        this.name = name;
        this.soDu = soDu;
        this.thumbnail = thumbnail;
        this.tienThuong = tienThuong;
    }

    public User() {
    }

    public User(final String email, final String fbToken, final String idFace, final String name) {
        this.email = email;
        this.fbToken = fbToken;
        this.idFace = idFace;
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(final String fbToken) {
        this.fbToken = fbToken;
    }

    public String getIdFace() {
        return idFace;
    }

    public void setIdFace(final String idFace) {
        this.idFace = idFace;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getSoDu() {
        return soDu;
    }

    public void setSoDu(final int soDu) {
        this.soDu = soDu;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(final String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public float getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(final float tienThuong) {
        this.tienThuong = tienThuong;
    }
}