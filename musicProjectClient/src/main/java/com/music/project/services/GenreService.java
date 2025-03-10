package com.music.project.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.music.project.apis.APIClient;
import com.music.project.apis.GenreApi;
import com.music.project.models.GenreModel;
import com.music.project.models.ResponseObject;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class GenreService {

    private final GenreApi genreApi;
    private final Gson gson;

    public GenreService() {
        genreApi = APIClient.getClient().create(GenreApi.class);
        gson = new Gson();
    }

    public List<GenreModel> getAllGenres() {
        try {
            Call<ResponseObject> call = genreApi.getAll();
            Response<ResponseObject> response = call.execute();
            
            if (response.isSuccessful() && response.body() != null) {
                ResponseObject responseObj = response.body();
                // Convert result JSON to List<GenreModel>
                String jsonResult = gson.toJson(responseObj.getResult());
                return gson.fromJson(jsonResult, new TypeToken<List<GenreModel>>(){}.getType());
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public GenreModel getGenreById(int genreId) {
        try {
            Call<ResponseObject> call = genreApi.getById(genreId);
            Response<ResponseObject> response = call.execute();
            
            if (response.isSuccessful() && response.body() != null) {
                ResponseObject responseObj = response.body();
                // Convert result JSON to GenreModel
                String jsonResult = gson.toJson(responseObj.getResult());
                return gson.fromJson(jsonResult, GenreModel.class);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}