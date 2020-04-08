package com.example.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.ui.WeatherAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

//    private Activity secPageActivity;
    private ArrayList<WeatherParcelable> weathers = new ArrayList<>();

    private String latitude;
    private String longitude;

    private WeatherAdapter weatherAdapter;

    private ListView weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        Intent intent = getIntent();
//        WeatherParcelable weather8 = intent.getParcelableExtra("weather8");
//        WeatherParcelable weather7 = intent.getParcelableExtra("weather7");
//        WeatherParcelable weather6 = intent.getParcelableExtra("weather6");
//        WeatherParcelable weather5 = intent.getParcelableExtra("weather5");
//        WeatherParcelable weather4 = intent.getParcelableExtra("weather4");
//        WeatherParcelable weather3 = intent.getParcelableExtra("weather3");
//        WeatherParcelable weather2 = intent.getParcelableExtra("weather2");
//        WeatherParcelable weather1 = intent.getParcelableExtra("weather1");
        ArrayList<WeatherParcelable> myWeathers = intent.getParcelableArrayListExtra("array");

//        System.out.println("______" + weather1.getTime());

//        weathers.addAll(myWeathers);
//
//        for (WeatherParcelable weather :
//                myWeathers) {
//            System.out.println("________ " + weather.getTime());
//        }

//
//
        updateWeather(myWeathers);

        updateUI();




    }

    public void updateWeather(ArrayList<WeatherParcelable> myWeathers){
        weathers.clear();
        weathers.addAll(myWeathers);
    }

    public void updateUI(){
        this.weatherAdapter = new WeatherAdapter(this , weathers);
        this.weatherList = findViewById(R.id.weather_listView);
        weatherList.setAdapter(weatherAdapter);

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
