package com.example.weather.api;

import android.content.Context;
import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.weather.MainActivity;

public class APIThread extends Thread {

    private Handler handler;
    private RequestQueue requestQueue;
    private String dataType;

    private String citiesRes;
    private String weatherRes;


    public APIThread(Handler h, Context context, String dataType) {
        this.handler = h;
        requestQueue = Volley.newRequestQueue(context);
        this.dataType = dataType;


    }

    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run() {
//                getWeather("51.67917", "32.65139");
                getLocation("Esfahan");

            }
        });
    }


    public void getLocation(String cityName) {
        String url = MainActivity.mapbox_url + cityName + ".json?access" +
                "_token=" + MainActivity.mapbox_token;


        sendRequest(new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Location.processLocationsRes(result);
            }
        }, url);
    }

    public void getWeather(String latitude, String longitude) {
        String url = MainActivity.darksky_url + MainActivity.darksky_secret_key + "/" +
                latitude + "," + longitude;

        sendRequest(new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Weather.processWeatherRes(result);
            }
        }, url);
    }

    public void sendRequest(final VolleyCallback callback, String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

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

}
