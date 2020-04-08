package com.example.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.ui.FirstPage;
import com.example.weather.ui.SecondPage;

import java.util.ArrayList;
import java.util.Arrays;
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



        WeatherParcelable weather1 = new WeatherParcelable();
        weather1.setTime("123456789");
        weather1.setSummary("summary1");
        weather1.setIcon("clear-day");
        weather1.setTemperatureMin("min temp1");
        weather1.setTemperatureMax("max temp1");

        WeatherParcelable weather2 = new WeatherParcelable();
        weather2.setTime("123456789");
        weather2.setSummary("summary2");
        weather2.setIcon("clear-day");
        weather2.setTemperatureMin("min temp2");
        weather2.setTemperatureMax("max temp2");

        WeatherParcelable weather3 = new WeatherParcelable();
        weather3.setTime("123456789");
        weather3.setSummary("summary3");
        weather3.setIcon("clear-day");
        weather3.setTemperatureMin("min temp3");
        weather3.setTemperatureMax("max temp3");

        WeatherParcelable weather4 = new WeatherParcelable();
        weather4.setTime("123456789");
        weather4.setSummary("summary4");
        weather4.setIcon("clear-day");
        weather4.setTemperatureMin("min temp4");
        weather4.setTemperatureMax("max temp4");

        WeatherParcelable weather5 = new WeatherParcelable();
        weather5.setTime("123456789");
        weather5.setSummary("summary5");
        weather5.setIcon("clear-day");
        weather5.setTemperatureMin("min temp5");
        weather5.setTemperatureMax("max temp5");

        WeatherParcelable weather6 = new WeatherParcelable();
        weather6.setTime("123456789");
        weather6.setSummary("summary6");
        weather6.setIcon("clear-day");
        weather6.setTemperatureMin("min temp6");
        weather6.setTemperatureMax("max temp6");

        WeatherParcelable weather7 = new WeatherParcelable();
        weather7.setTime("123456789");
        weather7.setSummary("summary7");
        weather7.setIcon("clear-day");
        weather7.setTemperatureMin("min temp7");
        weather7.setTemperatureMax("max temp7");

        WeatherParcelable weather8 = new WeatherParcelable();
        weather8.setTime("123456789");
        weather8.setSummary("summary8");
        weather8.setIcon("clear-day");
        weather8.setTemperatureMin("min temp8");
        weather8.setTemperatureMax("max temp8");

        Intent myIntent = new Intent(this, SecondActivity.class);

//
//        myIntent.putExtra("weather1", weather1);
//        myIntent.putExtra("weather2", weather2);
//        myIntent.putExtra("weather3", weather3);
//        myIntent.putExtra("weather4", weather4);
//        myIntent.putExtra("weather5", weather5);
//        myIntent.putExtra("weather6", weather6);
//        myIntent.putExtra("weather7", weather7);
//        myIntent.putExtra("weather8", weather8);
//
        ArrayList<WeatherParcelable> myWeathers = new ArrayList<>();
        myWeathers.addAll(Arrays.asList(weather1, weather2, weather3,
                weather4, weather5, weather6, weather7, weather8));

        myIntent.putParcelableArrayListExtra("array", myWeathers);

//        myIntent.putExtra("array", myWeathers);

//
        startActivity(myIntent);
    }

}

