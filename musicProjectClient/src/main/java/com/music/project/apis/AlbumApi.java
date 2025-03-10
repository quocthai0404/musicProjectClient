package com.music.project.apis;

import com.music.project.models.ResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlbumApi {
    @GET("album")
    Call<ResponseObject> getAll();
    
    @GET("album/{albumId}")
    Call<ResponseObject> getById(@Path("albumId") int albumId);
}
