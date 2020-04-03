package com.example.weather.api;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Location {

    private static ArrayList<Location> locations = new ArrayList<>();

    private String name;
    private String latitude;
    private String longitude;

    public static void processLocationsRes(String response, Handler handler) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonArray features = (JsonArray) jsonObject.get("features");



        for (JsonElement je :
                features) {

            JsonElement coordinatesObj = je.getAsJsonObject().get("center");
            JsonArray coordinates = coordinatesObj.getAsJsonArray();

            JsonElement placeNameObj = je.getAsJsonObject().get("place_name");

            Location location = new Location();

            location.name = placeNameObj.toString();
            location.latitude = coordinates.get(0).toString();
            location.longitude = coordinates.get(1).toString();

            locations.add(location);

        }

        Message message = new Message();
        message.what = 0;
        message.obj = locations;

        handler.sendMessage(message);

    }
}
