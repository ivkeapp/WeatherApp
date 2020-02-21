package com.example.weatherapp.model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDate {

    private String time, date;



    public TimeDate() {
        timerTask();
    }

    public String getTime() {
        return time;
    }

    public void setTime() {
        String timePattern = "HH:mm";
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(timePattern, Locale.US);
        Date timeDate = new Date();
        String sTime = simpleTimeFormat.format(timeDate);
        this.time = sTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        String datePattern = "MMMM dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern, new Locale("US"));
        Date timeDate = new Date();
        String date = simpleDateFormat.format(timeDate);
        this.date = date;
    }

    private void timerTask() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                setDate();
                setTime();
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L * 60L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }

}
