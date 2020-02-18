package com.example.weatherapp.view.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.api.service.RetrofitApiService;
import com.example.weatherapp.pojo.Model;
import com.example.weatherapp.repo.WeatherRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<Model> weatherData;
    private WeatherRepository mRepo;

    public void init(){
        if(weatherData!=null){
            return;
        }
        mRepo = WeatherRepository.getInstance();
        weatherData = mRepo.getWeatherData();
    }

    public LiveData<Model> getWeather() {
//if the list is null
        if (weatherData == null) {
            weatherData = new MutableLiveData<Model>();
//we will load it asynchronously from server in this method via WeatherRepository
            init();
        }
//finally we will return the data
        return weatherData;
    }

}
