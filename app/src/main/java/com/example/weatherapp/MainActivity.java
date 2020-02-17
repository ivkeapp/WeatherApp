package com.example.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.weatherapp.pojo.Main;
import com.example.weatherapp.pojo.Model;
import com.example.weatherapp.view.model.WeatherViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("responser", "Hello world");
        WeatherViewModel model = ViewModelProviders.of(this).get(WeatherViewModel.class);

        model.getWeather().observe(this, new Observer<Model>() {


            @Override
            public void onChanged(@Nullable Model model) {

                Log.d("responser", model.getMain().getTemp().toString());

            }
        });

    }
}
