package com.example.weatherapp.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.api.service.RetrofitApiService;
import com.example.weatherapp.pojo.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {

    private static WeatherRepository instance;
    MutableLiveData<Model> data = new MutableLiveData<>();

    //create cunstructor using Singleton pattern
    public static WeatherRepository getInstance(){
        if(instance==null){
            instance = new WeatherRepository();
        }
        return instance;
    }

    public MutableLiveData<Model> getWeatherData(){
        loadWeatherData();
        return data;
    }

    //This method is using Retrofit to get the JSON data from URL
    private void loadWeatherData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApiService api = retrofit.create(RetrofitApiService.class);
        Call<Model> call = api.getWeatherData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
//finally we are setting the list to our MutableLiveData
                Log.d("responser", "response success");
                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("responser", t.getMessage());
            }
        });

    }
}
