package com.example.weather.api;

import android.app.Activity;
import android.os.Handler;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.weather.R;
import com.example.weather.activities.FirstActivity;


import java.util.ArrayList;

public class APIThread extends Thread {

    private Handler handler;
    private RequestQueue requestQueue;
    private String dataType;
    private String latitude;
    private String longitude;

    public APIThread(Activity activity, String dataType) {
        requestQueue = Volley.newRequestQueue(activity);

        this.dataType = dataType;

        this.handler = new Handler(msg -> {

            if (msg.what == 0) { // update first page ui
                ArrayList<Location> locations = (ArrayList<Location>) msg.obj;
                updateFirstPage(locations);
            } else if (msg.what == 1) { // update second page ui
                ArrayList<Weather> weathers = (ArrayList<Weather>) msg.obj;
                updateSecondPage(weathers);
            }

            return true;
        });
    }

    private void updateFirstPage(ArrayList<Location> locations) {
        handler.post(() -> {
            FirstActivity.firstPage.getLoadFragment().endLoadingFragment();
            FirstActivity.firstPage.updateList(locations);
        });
    }

    private void updateSecondPage(ArrayList<Weather> weathers) {
        handler.post(() -> {
            FirstActivity.firstPage.getLoadFragment().endLoadingFragment();
            FirstActivity.enterSecondPage(weathers, FirstActivity.firstPage.getActivity());
        });
    }

    public void run() {
        switch (dataType) {
            case "location":

                String locationName = FirstActivity.firstPage.getEditTextLocation();

                FirstActivity.firstPage.getLoadFragment().startLoadingFragment();

                getLocation(locationName);
                break;
            case "weather":
                FirstActivity.firstPage.getLoadFragment().startLoadingFragment();
                getWeather(latitude, longitude);
                break;
        }
    }


    private void getLocation(String cityName) {
        String url = FirstActivity.mapbox_url + cityName + ".json?access" +
                "_token=" + FirstActivity.mapbox_token;


        sendRequest(result -> Location.processLocationsRes(result, handler), url);
    }

    private void getWeather(String latitude, String longitude) {
        String url = FirstActivity.darksky_url + FirstActivity.darksky_secret_key + "/" +
                latitude + "," + longitude;

        sendRequest(result -> {
            FirstActivity.saveThread.setContent(result);
            FirstActivity.saveThread.run();
            Weather.processWeatherRes(result, handler);
        }, url);
    }

    private void sendRequest(final VolleyCallback callback, String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, callback::onSuccess, volleyError -> {
            volleyError.printStackTrace();
            showErrorToast();

        });

        requestQueue.add(stringRequest);
    }

    private void showErrorToast() {
        handler.post(() -> {
            Toast.makeText(FirstActivity.firstPage.getActivity(),
                    R.string.error_toast_message, Toast.LENGTH_SHORT).show();
            FirstActivity.firstPage.getLoadFragment().endLoadingFragment();
        });

    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
