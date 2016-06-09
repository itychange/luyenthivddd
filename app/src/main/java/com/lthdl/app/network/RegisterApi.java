package com.lthdl.app.network;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by Not Me on 6/8/2016.
 */

public interface RegisterApi {
    @POST("/RetrofitExample/insert.php")
    public void insertUser(
            @Field("username") String email,
            @Field("social_id") String username,
            @Field("roles") String password,
            @Field("password") String name,
            @Field("id") String id,
            Callback<Response> callback);

}
