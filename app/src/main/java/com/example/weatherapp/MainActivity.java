package com.example.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.weatherapp.pojo.Main;
import com.example.weatherapp.pojo.Model;
import com.example.weatherapp.pojo.Weather;
import com.example.weatherapp.view.model.WeatherViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("init", "Hello world");

        //creating an viewmodel instance
        WeatherViewModel model = ViewModelProviders.of(this).get(WeatherViewModel.class);

        //setting the observer
        model.getWeather().observe(this, new Observer<Model>() {


            @Override
            public void onChanged(@Nullable Model model) {

                //later this data will be used to update UI
                Log.d("responser", "City: " + model.getName());
                Log.d("responser", "Current temperature in F: " + model.getMain().getTemp().toString());

            }
        });

    }
}
