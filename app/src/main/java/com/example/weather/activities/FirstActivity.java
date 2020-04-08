package com.example.weather.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.weather.R;
import com.example.weather.memory.MemoryReading;
import com.example.weather.memory.SaveThread;
import com.example.weather.ui.FirstPage;
import com.example.weather.ui.SecondPage;

import java.util.ArrayList;
//import com.example.weather.ui.StringAdapter;


public class FirstActivity extends AppCompatActivity {

    public final static String darksky_url = "https://api.darksky.net/forecast/";
    public final static String darksky_secret_key = "1559cc2c241264167fdf4658dca412ca";
    public final static String mapbox_url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    public final static String mapbox_token = "pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzN" +
            "rbnFvNXF6Z2I5MSJ9.J0j1SE9LHQV1NzNGQ2zX0A";
    public static FirstPage firstPage;
    public static SecondPage secondPage;

    public static SaveThread saveThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        secondPage = new SecondPage(this);


        boolean isConnected = isConnected();
        System.out.println(isConnected);
        if(isConnected) {
            setContentView(R.layout.first_page);

            saveThread = new SaveThread(getApplicationContext());


            firstPage = new FirstPage(this);
        }

        else {
            MemoryReading memoryReading = new MemoryReading(getApplicationContext());
            System.out.println("made it");
            memoryReading.start();
        }

//        Handler handler = new Handler();
//        APIThread apiThread = new APIThread(this, "location");
//
//        apiThread.start();


    }



    public void onSearchButtonClick(View view) {
        firstPage.onSearchButtonClick();
    }

    public static void enterSecondPage(ArrayList<WeatherParcelable> myWeathers, Activity activity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putParcelableArrayListExtra("weathers_array", myWeathers);
        activity.startActivity(intent);
    }



    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager)getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


}

