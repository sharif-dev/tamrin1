package com.example.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.weather.R;
import com.example.weather.api.Weather;
import com.example.weather.ui.FirstPage;
import com.example.weather.ui.SecondPage;
//import com.example.weather.ui.StringAdapter;


public class FirstActivity extends AppCompatActivity {

    public final static String darksky_url = "https://api.darksky.net/forecast/";
    public final static String darksky_secret_key = "1559cc2c241264167fdf4658dca412ca";
    public final static String mapbox_url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    public final static String mapbox_token = "pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzN" +
            "rbnFvNXF6Z2I5MSJ9.J0j1SE9LHQV1NzNGQ2zX0A";
    public static FirstPage firstPage;
    public static SecondPage secondPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        firstPage = new FirstPage(this);
        secondPage = new SecondPage(this);

//        Handler handler = new Handler();
//        APIThread apiThread = new APIThread(this, "location");
//
//        apiThread.start();


    }



    public void onSearchButtonClick(View view) {
//        firstPage.onSearchButtonClick();

        WeatherParcelable weather = new WeatherParcelable();
        weather.setTime("time");
        weather.setSummary("summary");
        weather.setIcon("icon");
        weather.setTemperatureMin("min temp");
        weather.setTemperatureMax("max temp");

        Intent myIntent = new Intent(getBaseContext(), SecondActivity.class);
        myIntent.putExtra("weather", weather);
//
        startActivity(myIntent);
    }

}

