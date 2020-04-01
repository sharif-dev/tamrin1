package com.example.weather.api;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.weather.MainActivity;
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
                getWeather("51.67917", "32.65139");
//                getCities("Esfahan");

            }
        });
    }


    public void getCities(String cityName) {
        String url = MainActivity.mapbox_url + cityName + ".json?access" +
                "_token=" + MainActivity.mapbox_token;



        sendRequest(new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                processCitiesRes(result);
            }
        }, url);
    }

    public void processCitiesRes(String response) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonArray features = (JsonArray) jsonObject.get("features");

        Log.i("^%^%%^%^%^^%^%^^^^^^^", features.toString());

        for (JsonElement je :
                features) {
            JsonElement jsonElement = je.getAsJsonObject().get("center");



            Type listType = new TypeToken<List<String>>() {
            }.getType();

            List<String> yourList = new Gson().fromJson(jsonElement, listType);

//            Log.i("---------------", yourList.toArray()[0].toString());
        }
    }

    public void processWeatherRes(String response) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonElement dailyData = jsonObject.get("daily");
        JsonObject datasObject = dailyData.getAsJsonObject();
        JsonArray datas = datasObject.getAsJsonArray("data");

        for (JsonElement dayWeather:
             datas) {
            Log.i("^%^%%^%^%^^%^%^^^^^^^", dayWeather.toString());

        }


//        Type listType = new TypeToken<List<String>>() {
//        }.getType();
//
//        List<String> yourList = new Gson().fromJson(datas, listType);

//        Log.i("^%^%%^%^%^^%^%^^^^^^^", datas.toString());
//        Log.i("^%^%%^%^%^^%^%^^^^^^^", yourList.get(1));
    }


    public void getWeather(String latitude, String longitude) {
        String url = MainActivity.darksky_url + MainActivity.darksky_secret_key + "/" +
                latitude + "," + longitude;
        String test = "";

        sendRequest(new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                processWeatherRes(result);
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
