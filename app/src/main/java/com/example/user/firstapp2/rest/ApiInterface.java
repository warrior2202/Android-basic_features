package com.example.user.firstapp2.rest;

import com.example.user.firstapp2.Retrofitwithgirdandrect.BWceleb;
import com.example.user.firstapp2.Retrofitwithgirdandrect.BWcelebmore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("bollywood_wallpaper/get_celeb_list.php")
    Call<List<BWceleb>> getceleb(@Query( "gender" )String gender, @Query( "page" )String page);

    @GET("bollywood_wallpaper/get_celeb_picture.php")
    Call<List<BWcelebmore>>getcelebmore(@Query( "celeb_id" )String id);
}
