package com.lthdl.app.network;

import com.lthdl.app.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Not Me on 6/8/2016.
 */

public interface  ApiInterface {

//    @POST("users")
//    Call<User> login(User user);
    @POST("users")
    Call<User> login(@Body User user);
    @GET("menus")
    Call<User> getMenungang();


}
