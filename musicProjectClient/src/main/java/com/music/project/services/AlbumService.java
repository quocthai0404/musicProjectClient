package com.music.project.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.music.project.apis.APIClient;
import com.music.project.apis.AlbumApi;
import com.music.project.models.Album;
import com.music.project.models.ResponseObject;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class AlbumService {

    private final AlbumApi albumApi;
    private final Gson gson;

    public AlbumService() {
        albumApi = APIClient.getClient().create(AlbumApi.class);
        gson = new Gson();
    }

    public List<Album> getAllAlbums() {
        try {
            Call<ResponseObject> call = albumApi.getAll();
            Response<ResponseObject> response = call.execute();
            
            if (response.isSuccessful() && response.body() != null) {
                ResponseObject responseObj = response.body();
                // Convert result JSON to List<Album>
                String jsonResult = gson.toJson(responseObj.getResult());
                return gson.fromJson(jsonResult, new TypeToken<List<Album>>(){}.getType());
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Album getAlbumById(int albumId) {
        try {
            Call<ResponseObject> call = albumApi.getById(albumId);
            Response<ResponseObject> response = call.execute();
            
            if (response.isSuccessful() && response.body() != null) {
                ResponseObject responseObj = response.body();
                // Convert result JSON to Album
                String jsonResult = gson.toJson(responseObj.getResult());
                return gson.fromJson(jsonResult, Album.class);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}