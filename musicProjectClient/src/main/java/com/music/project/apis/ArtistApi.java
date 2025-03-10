package com.music.project.apis;

import com.music.project.models.ResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArtistApi {
    @GET("api/artist/test")
    Call<String> test();
    
    @GET("api/artist")
    Call<ResponseObject> getAll();
    
    @GET("api/artist/{artistId}")
    Call<ResponseObject> getById(@Path("artistId") int artistId);
}