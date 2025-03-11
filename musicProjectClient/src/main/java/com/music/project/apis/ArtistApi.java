package com.music.project.apis;

import java.util.List;

import com.music.project.models.ArtistModel;
import com.music.project.models.ResponseObject;
import com.music.project.models.SongResultDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArtistApi {
    @GET("artist-guess-access/test")
    Call<String> test();
    
    @GET("api/artist")
    Call<ResponseObject> getAll();
    
    @GET("artist-guess-access/findAllArtistInfo")
    Call<List<ArtistModel>> getAllArtistInfo();
    
    @GET("artist-guess-access/findByArtistId/{id}")
    Call<ArtistModel> getArtistById(@Path("id") int id);
    
    @GET("songs/getAllSongByArtist/{id}")
    Call<List<SongResultDTO>> getSongsByArtist(@Path("id") int artistId);

    
    @GET("api/artist/{artistId}")
    Call<ResponseObject> getById(@Path("artistId") int artistId);
}