package com.music.project.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.music.project.apis.APIClient;
import com.music.project.apis.ArtistApi;
import com.music.project.models.ArtistModel;
import com.music.project.models.ResponseObject;
import com.music.project.models.SongResultDTO;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class ArtistService {

    private final ArtistApi artistApi;
    private final Gson gson;

    public ArtistService() {
        artistApi = APIClient.getClient().create(ArtistApi.class);
        gson = new Gson();
    }
    
    public String test() {
        try {
            Call<String> call = artistApi.test();
            Response<String> response = call.execute();
            
            if (response.isSuccessful()) {
                return response.body();
            }
            return "Error: " + response.code();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public List<ArtistModel> getAllArtists() {
        try {
            Call<ResponseObject> call = artistApi.getAll();
            Response<ResponseObject> response = call.execute();
            
            if (response.isSuccessful() && response.body() != null) {
                ResponseObject responseObj = response.body();
                // Convert result JSON to List<ArtistModel>
                String jsonResult = gson.toJson(responseObj.getResult());
                return gson.fromJson(jsonResult, new TypeToken<List<ArtistModel>>(){}.getType());
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<ArtistModel> getAllArtistInfo() {
        try {
            Call<List<ArtistModel>> call = artistApi.getAllArtistInfo();
            Response<List<ArtistModel>> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                return response.body(); // Trả về trực tiếp danh sách ArtistModel
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
//    public ArtistModel getArtistById(int artistId) {
//        try {
//            Call<ResponseObject> call = artistApi.getById(artistId);
//            Response<ResponseObject> response = call.execute();
//            
//            if (response.isSuccessful() && response.body() != null) {
//                ResponseObject responseObj = response.body();
//                // Convert result JSON to ArtistModel
//                String jsonResult = gson.toJson(responseObj.getResult());
//                return gson.fromJson(jsonResult, ArtistModel.class);
//            }
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    
    public ArtistModel getArtistById(int artistId) {
        try {
            Call<ArtistModel> call = artistApi.getArtistById(artistId);
            Response<ArtistModel> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<SongResultDTO> getSongsByArtist(int artistId) {
        try {
            Call<List<SongResultDTO>> call = artistApi.getSongsByArtist(artistId);
            Response<List<SongResultDTO>> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}