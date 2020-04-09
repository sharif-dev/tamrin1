package com.example.weather.pages;

import android.app.Activity;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.api.Weather;
import com.example.weather.ui.WeatherAdapter;

import java.util.ArrayList;

public class SecondPage {
    private Activity secPageActivity;

    public SecondPage(Activity activity) { this.secPageActivity = activity; }

    public Activity getSecPageActivity() {
        return secPageActivity;
    }
}
