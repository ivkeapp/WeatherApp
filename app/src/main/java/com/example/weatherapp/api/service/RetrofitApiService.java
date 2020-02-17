package com.example.weatherapp.api.service;

import com.example.weatherapp.pojo.Model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {
    String BASE_URL = "https://api.openweathermap.org/";
    @GET("data/2.5/weather?q=belgrade&appid=f2b96f6f33777b4db1b2214c6e17db22")
    Call<Model> getWeatherData();
}
