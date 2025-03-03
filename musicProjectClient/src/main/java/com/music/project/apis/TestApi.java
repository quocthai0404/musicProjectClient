package com.music.project.apis;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestApi {
    @GET("test/test")
    Call<String> test();

}
