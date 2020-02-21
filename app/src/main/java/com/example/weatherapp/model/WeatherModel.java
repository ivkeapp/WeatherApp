package com.example.weatherapp.model;

public class WeatherModel {

    private String city, temp, weather;
    private TimeDate timeDate;

    public WeatherModel(String city, String temp, String weather, TimeDate timeDate) {
        this.city = city;
        double d = Double.valueOf(temp)-273.15;
        int iTemp = (int) d;
        this.temp = String.valueOf(iTemp);
        this.weather = weather;
        this.timeDate = timeDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public TimeDate getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(TimeDate timeDate) {
        this.timeDate = timeDate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
