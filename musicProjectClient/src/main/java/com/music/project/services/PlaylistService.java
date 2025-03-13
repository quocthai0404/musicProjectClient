package com.music.project.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.music.project.apis.APIClient;
import com.music.project.apis.ArtistApi;
import com.music.project.apis.PlaylistApi;
import com.music.project.models.ArtistModel;
import com.music.project.models.PlaylistModel;
import com.music.project.models.PlaylistResult;
import com.music.project.models.ResponseObject;
import com.music.project.models.SongResultDTO;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class PlaylistService {

    private final PlaylistApi playlistApi;
    private final Gson gson;

    public PlaylistService() {
    	playlistApi = APIClient.getClient().create(PlaylistApi.class);
        gson = new Gson();
    }
    
    

    public List<PlaylistModel> getAllPlaylist() {
        try {
            Call<List<PlaylistModel>> call = playlistApi.getAll();
            Response<List<PlaylistModel>> response = call.execute();
            
            if (response.isSuccessful() && response.body() != null) {
            	return response.body();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public PlaylistResult getAllSongByPlaylistId(int id) {
        try {
            Call<PlaylistResult> call = playlistApi.getAllSongByPlaylistId(id);
            Response<PlaylistResult> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}