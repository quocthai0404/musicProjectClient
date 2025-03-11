package com.music.project.apis;

import com.music.project.models.ResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GenreApi {
    @GET("genre/getAll")
    Call<ResponseObject> getAll();
    
    @GET("genre/{genreId}")
    Call<ResponseObject> getById(@Path("genreId") int genreId);
}