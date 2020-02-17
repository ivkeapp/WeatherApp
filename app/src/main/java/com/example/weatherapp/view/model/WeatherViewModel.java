package com.example.weatherapp.view.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.api.service.RetrofitApiService;
import com.example.weatherapp.pojo.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<Model> weatherData;

    public LiveData<Model> getWeather() {
//if the list is null
        if (weatherData == null) {
            weatherData = new MutableLiveData<Model>();
//we will load it asynchronously from server in this method
            //Log.d("responser", "response success");
            loadWeatherData();
        }
//finally we will return the list
        return weatherData;
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
                weatherData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("responser", t.getMessage());
            }
        });

    }
}
