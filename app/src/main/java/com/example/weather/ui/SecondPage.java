package com.example.weather.ui;

import android.app.Activity;

import com.example.weather.api.Weather;

import java.util.ArrayList;

public class SecondPage {
    private Activity secPageActivity;
    private ArrayList<Weather> weathers = new ArrayList<>();

    private String latitude;
    private String longitude;

    public SecondPage(Activity activity){
        this.secPageActivity = activity;

    }

    public void updaetWeather(ArrayList<Weather> myWheathers){
        weathers.clear();
        weathers.addAll(myWheathers);

    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Activity getSecPageActivity() {
        return secPageActivity;
    }
}
