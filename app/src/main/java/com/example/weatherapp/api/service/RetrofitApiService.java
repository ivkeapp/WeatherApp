package com.example.weatherapp.api.service;

import com.example.weatherapp.pojo.Model;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiService {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    @GET("weather")
    Call<Model> getWeatherData(@Query("q") String q,
                               @Query("appid") String appid);
}
