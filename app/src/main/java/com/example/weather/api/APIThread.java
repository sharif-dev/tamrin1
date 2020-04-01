package com.example.weather.api;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;


import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class APIThread extends Thread {

    private Handler handler;
    private RequestQueue requestQueue;
    private String dataType;
    private String cityRes;
    private String weatherRes;
    private static String res;


    public APIThread(Handler h, Context context, String dataType) {
        this.handler = h;
        requestQueue = Volley.newRequestQueue(context);
        this.dataType = dataType;


    }

    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                getCities("esfahan");

            }
        });
    }


    public void getCities(String cityName) {
        String url = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + cityName + ".json?access" +
                "_token=pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzNrbnFvNXF6Z2I5MSJ9." +
                "J0j1SE9LHQV1NzNGQ2zX0A\n";
        Log.i("_____________", url);

        sendRequest(new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
               Log.i("_____________", result);
            }
        }, url);
    }

    public void sendRequest(final VolleyCallback callback, String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.i("^^^^^^^^^^^^", response);
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


//    public void getCities(String cityName) {
//        String url = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + cityName + ".json?access" +
//                "_token=pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzNrbnFvNXF6Z2I5MSJ9." +
//                "J0j1SE9LHQV1NzNGQ2zX0A\n";
//
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(String response) {
//
//                Gson gson = new Gson();
//                JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
//                JsonArray features = (JsonArray) jsonObject.get("features");
//
//                for (JsonElement je :
//                        features) {
//                    JsonElement jsonElement = je.getAsJsonObject().get("center");
//
//                    Type listType = new TypeToken<List<String>>() {
//                    }.getType();
//
//                    List<String> yourList = new Gson().fromJson(jsonElement, listType);
//
//                    Log.i("---------------", yourList.toArray()[0].toString());
//                }
//
//
//            }
//        }, error -> {
////                System.out.println("_______error happend");
//            Log.i("*****************", "error happened!");
//        });
//
//        requestQueue.add(stringRequest);
//    }


//    public void getCities2(String city_name) throws InterruptedException {
//        String url = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + city_name + ".json?access" +
//                "_token=pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzNrbnFvNXF6Z2I5MSJ9." +
//                "J0j1SE9LHQV1NzNGQ2zX0A\n";
//
//        System.out.println("__________url:"+ url);
//
//        sendRequest(url);
//
//        sleep(5000);
//        String res = getRes();
//        System.out.println("***********************"+ res);
//
////        Log.i("resposnse::::::::", res);
//
//    }
//
//    public void getWeather(List coordination) {
//        String first_coordination = (String) coordination.get(0);
//        String second_coordination = (String) coordination.get(1);
//
//        String url = "https://api.darksky.net/forecast/1559cc2c241264167fdf4658dca412ca/"
//                + first_coordination + ',' + second_coordination;
//
//        sendRequest(url);
//        Log.i("resposnse::::::::", getRes());
//
//
//
//    }
//
//    public void sendRequest(String url) {
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                setRes(response);
//                System.out.println("setting res:"+ getRes());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(stringRequest);
//
//
//
//    }
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


    public static String getRes() {
        return res;
    }

    public static void setRes(String res) {
        APIThread.res = res;
    }
}
