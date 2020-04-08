package com.example.weather.api;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Weather {

    private static ArrayList<Weather> days_weather;

    private String time;
    private String summary;
    private String icon;
    private String temperatureMin;
    private String temperatureMax;


    public static void processWeatherRes(String response, Handler handler) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonElement dailyData = jsonObject.get("daily");
        JsonObject datasObject = dailyData.getAsJsonObject();
        JsonArray datas = datasObject.getAsJsonArray("data");

        ArrayList<Weather> weathers = new ArrayList<>();

        for (JsonElement dayWeather :
                datas) {

            Weather weather = new Weather();
            weathers.add(weather);
            weather.time = dayWeather.getAsJsonObject().get("time").toString();
            weather.summary = dayWeather.getAsJsonObject().get("summary").toString();
            weather.icon = dayWeather.getAsJsonObject().get("icon").toString();
            weather.temperatureMin = dayWeather.getAsJsonObject().get("temperatureMin").toString();
            weather.temperatureMax = dayWeather.getAsJsonObject().get("temperatureMax").toString();


        }

        days_weather = weathers;

        Message message = new Message();
        message.what = 1;
        message.obj = days_weather;

        handler.sendMessage(message);

    }

    public static ArrayList<Weather> getDays_weather() {
        return days_weather;
    }

    public String getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }


    public String getTemperatureMax() {
        return temperatureMax;
    }

}
