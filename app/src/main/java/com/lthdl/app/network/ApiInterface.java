package com.lthdl.app.network;

import com.lthdl.app.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by Not Me on 6/8/2016.
 */

public interface  ApiInterface {

//    @POST("users")
//    Call<User> login(User user);
    @POST("users")
    Call<User> login(@Body User user);
    public void insertUser(
            @Field("username") String email,
            @Field("social_id") String username,
            @Field("roles") String password,
            @Field("password") String name,
            @Field("id") String id,
            Callback<Response> callback);
}
