package com.example.weather.api;

import android.app.Activity;
import android.os.Handler;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.weather.activities.FirstActivity;
import com.example.weather.activities.WeatherParcelable;


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
                ArrayList<WeatherParcelable> weathers = (ArrayList<WeatherParcelable>) msg.obj;
                updateSecondPage(weathers);
            }

            return true;
        });
    }

    public void updateFirstPage(ArrayList<Location> locations) {
        handler.post(() -> {
            FirstActivity.firstPage.getLoadFragment().endLoadingFragment();
            FirstActivity.firstPage.updateList(locations);
        });
    }

    public void updateSecondPage(ArrayList<WeatherParcelable> weathers) {
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


    public void getLocation(String cityName) {
        String url = FirstActivity.mapbox_url + cityName + ".json?access" +
                "_token=" + FirstActivity.mapbox_token;


        sendRequest(result -> Location.processLocationsRes(result, handler), url);
    }

    public void getWeather(String latitude, String longitude) {
        String url = FirstActivity.darksky_url + FirstActivity.darksky_secret_key + "/" +
                latitude + "," + longitude;

        sendRequest(result -> WeatherParcelable.processWeatherRes(result, handler), url);
    }

    public void sendRequest(final VolleyCallback callback, String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, response -> callback.onSuccess(response), Throwable::printStackTrace);

        requestQueue.add(stringRequest);
    }


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
