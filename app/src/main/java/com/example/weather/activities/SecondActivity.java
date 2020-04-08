package com.example.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.weather.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();
        WeatherParcelable weather = intent.getParcelableExtra("weather");

        System.out.println("time: " + weather.getTime());
        System.out.println("summary: " + weather.getSummary());
        System.out.println("icon: " + weather.getIcon());
        System.out.println("min temp: " + weather.getTemperatureMin());
        System.out.println("max temp: " + weather.getTemperatureMax());




    }
}
