package com.music.project.apis;

import java.util.List;

import com.music.project.models.ArtistModel;
import com.music.project.models.PlaylistModel;
import com.music.project.models.PlaylistResult;
import com.music.project.models.ResponseObject;
import com.music.project.models.SongResultDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaylistApi {
    
    
    @GET("playlist")
    Call<List<PlaylistModel>> getAll();
    
    @GET("playlist/detail/{id}")
    Call<PlaylistResult> getAllSongByPlaylistId(@Path("id") int id);
}