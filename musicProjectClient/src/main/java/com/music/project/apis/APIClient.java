package com.music.project.apis;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.Strictness;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

	private static Retrofit retrofit = null;
	private static String username = "acc1";
	private static String password = "123";

	public static Retrofit getClient() {
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy")
				.setStrictness(Strictness.LENIENT)
				.create();
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
				.build();
		retrofit = new Retrofit.Builder().baseUrl("http://localhost:8085/api/")
				.addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
		return retrofit;
	}

	

}