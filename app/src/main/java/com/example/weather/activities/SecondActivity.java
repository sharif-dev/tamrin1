package com.example.weather.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.ui.WeatherAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<WeatherParcelable> weathers = new ArrayList<>();

    private String latitude;
    private String longitude;

    private WeatherAdapter weatherAdapter;

    private ListView weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        weatherAdapter = new WeatherAdapter(this , weathers);
        weatherList = findViewById(R.id.weather_listView);
        weatherList.setAdapter(weatherAdapter);

        getWeathersData();
    }

    public void updateWeather(ArrayList<WeatherParcelable> myWeathers){
        weathers.clear();
        weathers.addAll(myWeathers);
        weatherAdapter.notifyDataSetChanged();
    }

    public void getWeathersData() {
        Intent intent = getIntent();
        ArrayList<WeatherParcelable> myWeathers = intent.getParcelableArrayListExtra("weathers_array");
        updateWeather(myWeathers);

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


}
