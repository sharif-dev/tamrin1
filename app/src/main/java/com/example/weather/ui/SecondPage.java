package com.example.weather.ui;

import android.app.Activity;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.api.Weather;

import java.util.ArrayList;

public class SecondPage {
    private Activity secPageActivity;
    private ArrayList<Weather> weathers = new ArrayList<>();

    private String latitude;
    private String longitude;

    private WeatherAdapter weatherAdapter;

    private ListView weatherList;

    public SecondPage(Activity activity){
        this.secPageActivity = activity;
       // this.weatherAdapter = new WeatherAdapter(secPageActivity , weathers);
        //this.weatherList = secPageActivity.findViewById(R.id.weather_listView);
        //weatherList.setAdapter(weatherAdapter);

    }

    public void updaetWeather(ArrayList<Weather> myWheathers){
        weathers.clear();
        weathers.addAll(myWheathers);




      //  weatherAdapter.notifyDataSetChanged();

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
