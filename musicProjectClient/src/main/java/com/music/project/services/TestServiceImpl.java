package com.music.project.services;


import com.music.project.apis.APIClient;
import com.music.project.apis.TestApi;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        try {
            TestApi testApi = APIClient.getClient().create(TestApi.class);
            Response<String> response = testApi.test().execute();
            if (response.isSuccessful()) {
                return response.body(); // Trả về "ok" nếu API call thành công
            } else {
                // Xử lý lỗi khi API call không thành công (ví dụ: log lỗi)
                System.err.println("API Error: " + response.code());
                return null;
            }
        } catch (IOException e) {
            // Xử lý exception (ví dụ: log exception)
            e.printStackTrace();
            return null;
        }
    }
}
