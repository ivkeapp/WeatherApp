package com.example.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.model.WeatherModel;
import com.example.weatherapp.pojo.Model;
import com.example.weatherapp.view.model.WeatherViewModel;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    TextView tvTemperature, tvTime, tvCity, tvDate;
    ImageView imgWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("init", "Hello world");

        //creating an viewmodel instance
        WeatherViewModel model = ViewModelProviders.of(this).get(WeatherViewModel.class);
        tvTemperature = findViewById(R.id.tv_temperature);
        tvTime = findViewById(R.id.tv_time);
        tvCity = findViewById(R.id.tv_city);
        tvDate = findViewById(R.id.tv_date);
        imgWeather = findViewById(R.id.image);
        model.getWeather().observe(this, new Observer<WeatherModel>() {


            @Override
            public void onChanged(@Nullable WeatherModel model) {

                tvTemperature.setText(model.getTemp() + (char) 0x00B0);
                tvTime.setText(model.getTimeDate().getTime());
                tvCity.setText(model.getCity().toUpperCase());
                tvDate.setText(model.getTimeDate().getDate());

                switch (model.getWeather().toLowerCase()){
                    case "scattered clouds": imgWeather.setImageDrawable(getResources().getDrawable(R.drawable.very_cloudy3x8));
                        break;
                    case "broken clouds": imgWeather.setImageDrawable(getResources().getDrawable(R.drawable.very_cloudy3x8));
                        break;
                    case "few clouds": imgWeather.setImageDrawable(getResources().getDrawable(R.drawable.cloudy_13x8));
                        break;
                    case "light rain": imgWeather.setImageDrawable(getResources().getDrawable(R.drawable.rain3x8));
                        break;
                }
            }
        });

    }

}
