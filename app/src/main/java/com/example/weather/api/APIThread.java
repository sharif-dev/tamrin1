package com.example.weather.api;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.weather.MainActivity;
import com.example.weather.ui.FirstPage;

import java.util.ArrayList;

public class APIThread extends Thread {

    private Handler handler;
    private RequestQueue requestQueue;
    private String dataType;

    private String citiesRes;
    private String weatherRes;


    public APIThread(Handler h, Context context, String dataType) {
        requestQueue = Volley.newRequestQueue(context);
        this.dataType = dataType;

        this.handler = new Handler(new Handler.Callback() {
             @Override
             public boolean handleMessage(Message msg) {
                 if (msg.what == 0) { // update first page ui

                     ArrayList<Location> locations = (ArrayList<Location>) msg.obj;

                     FirstPage.updateList(locations);


                 }else if (msg.what == 1) { // update second page ui
                     //update second page list
                     System.out.println("!@!@!@!@!@!@!@ updte second page");
                 }

                 return true;
             }
         });


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
                Location.processLocationsRes(result, handler);
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
