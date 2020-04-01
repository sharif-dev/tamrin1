package com.example.weather;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class APIThread extends Thread {

    private Handler handler;
    private RequestQueue requestQueue;


    public APIThread(Handler h, Context context) {
        this.handler = h;
        requestQueue = Volley.newRequestQueue(context);


    }

    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                getAPI("text");
            }
        });
    }

    public void getAPI(String url) {
        url = "https://api.mapbox.com/geocoding/v5/mapbox.places/Esfahan.json?access" +
                "_token=pk.eyJ1IjoiYmFoYXJraGQiLCJhIjoiY2s3c3p5NHh5MGtvdzNrbnFvNXF6Z2I5MSJ9." +
                "J0j1SE9LHQV1NzNGQ2zX0A\n";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
                JsonArray features = (JsonArray) jsonObject.get("features");

                for (JsonElement je:
                     features) {
                    JsonElement jsonElement = je.getAsJsonObject().get("center");
                    Log.i("---------------", jsonElement.toString());
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                System.out.println("_______error happend");
                Log.i("*****************", "error happened!");
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
}
