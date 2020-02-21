package com.example.weatherapp.view.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.model.WeatherModel;
import com.example.weatherapp.repo.WeatherRepository;


public class WeatherViewModel extends ViewModel {

    private MutableLiveData<WeatherModel> weatherModel;
    private WeatherRepository mRepo;

    private void init(){
//        if(weatherModel!=null){
//            return;
//        }
//create repository instance
        mRepo = WeatherRepository.getInstance();
//now we will load it asynchronously from the server in this method via WeatherRepository
        weatherModel = mRepo.getWeatherData();
    }

    public LiveData<WeatherModel> getWeather() {
//if the data is null
        if (weatherModel == null) {
            weatherModel = new MutableLiveData<>();
            init();
        }
//finally we will return the data
        return weatherModel;
    }

}
