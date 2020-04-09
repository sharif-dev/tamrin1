package com.example.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.api.Weather;
import com.example.weather.ui.WeatherAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<Weather> weathers = new ArrayList<>();

    private WeatherAdapter weatherAdapter;

    private ListView weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        weatherAdapter = new WeatherAdapter(this, weathers);
        weatherList = findViewById(R.id.weather_listView);
        weatherList.setAdapter(weatherAdapter);

        getWeathersData();
    }

    public void updateWeather(ArrayList<Weather> myWeathers) {
        weathers.clear();
        weathers.addAll(myWeathers);
        weatherAdapter.notifyDataSetChanged();
    }

    public void getWeathersData() {
        Intent intent = getIntent();
        ArrayList<Weather> myWeathers = intent.getParcelableArrayListExtra(String.valueOf(R.string.weathers_array));
        updateWeather(myWeathers);

    }

}
