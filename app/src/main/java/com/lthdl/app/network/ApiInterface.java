package com.lthdl.app.network;

import com.lthdl.app.model.BooksTrangChu;
import com.lthdl.app.model.ItemBook;
import com.lthdl.app.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Not Me on 6/8/2016.
 */

public interface  ApiInterface {

//    @POST("users")
//    Call<User> login(User user);
    @POST("users")
    Call<User> login(@Body User user);
    @GET("users/{id}")
    Call<User> getMenungang(@Path("id") String id);

    @GET("books?user_id=id")
    Call<ItemBook> getMybooks(@Query("id") String id);

    @GET("menus/{id}?user_id=userid")
    Call<BooksTrangChu> getBookTrangChu(@Path("id") String menu_id,@Query("userid") String user_id);
}
