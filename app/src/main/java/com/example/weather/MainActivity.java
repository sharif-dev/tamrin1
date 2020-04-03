package com.example.weather;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.weather.api.APIThread;
import com.example.weather.ui.FirstPage;

public class MainActivity extends AppCompatActivity {

    public final static String darksky_url = "https://api.darksky.net/forecast/";
    public final static String darksky_secret_key = "1559cc2c241264167fdf4658dca412ca";
    public final static String mapbox_url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    public final static String mapbox_token = "pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzN" +
            "rbnFvNXF6Z2I5MSJ9.J0j1SE9LHQV1NzNGQ2zX0A";
    public static FirstPage firstPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        firstPage = new FirstPage(this);




//        Handler handler = new Handler();
//        APIThread apiThread = new APIThread(this, "location");
//
//        apiThread.start();


    }

    public void onSearchButtonClick(View view) {
        firstPage.onSearchButtonClick();
    }

}
