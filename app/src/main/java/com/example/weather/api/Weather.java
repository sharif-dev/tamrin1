package com.example.weather.api;

import android.util.Log;

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
    private String sunriseTime;
    private String sunsetTime;
    private String moonPhase;
    private String precipIntensity;
    private String precipIntensityMax;
    private String precipIntensityMaxTime;
    private String precipProbability;
//    private String precipType;
    private String temperatureHigh;
    private String temperatureHighTime;
    private String temperatureLow;
    private String temperatureLowTime;
    private String apparentTemperatureHigh;
    private String apparentTemperatureHighTime;
    private String apparentTemperatureLow;
    private String apparentTemperatureLowTime;
    private String dewPoint;
    private String humidity;
    private String pressure;
    private String windSpeed;
    private String windGust;
    private String windGustTime;
    private String windBearing;
    private String cloudCover;
    private String uvIndex;
    private String uvIndexTime;
    private String visibility;
    private String ozone;
    private String temperatureMin;
    private String temperatureMinTime;
    private String temperatureMax;
    private String temperatureMaxTime;
    private String apparentTemperatureMin;
    private String apparentTemperatureMinTime;
    private String apparentTemperatureMax;
    private String apparentTemperatureMaxTime;

    public static void processWeatherRes(String response) {
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
//            System.out.println("***************"+ dayWeather);
            weather.time = dayWeather.getAsJsonObject().get("time").toString();
            weather.summary = dayWeather.getAsJsonObject().get("summary").toString();
            weather.icon = dayWeather.getAsJsonObject().get("icon").toString();
            weather.sunriseTime = dayWeather.getAsJsonObject().get("sunriseTime").toString();
            weather.sunsetTime = dayWeather.getAsJsonObject().get("sunsetTime").toString();
            weather.moonPhase = dayWeather.getAsJsonObject().get("moonPhase").toString();
            weather.precipIntensity = dayWeather.getAsJsonObject().get("precipIntensity").toString();
            weather.precipIntensityMax = dayWeather.getAsJsonObject().get("precipIntensityMax").toString();
            weather.precipIntensityMaxTime = dayWeather.getAsJsonObject().get("precipIntensityMaxTime").toString();
            weather.precipProbability = dayWeather.getAsJsonObject().get("precipProbability").toString();
//            weather.precipType = dayWeather.getAsJsonObject().get("precipType").toString();
            weather.temperatureHigh = dayWeather.getAsJsonObject().get("temperatureHigh").toString();
            weather.temperatureHighTime = dayWeather.getAsJsonObject().get("temperatureHighTime").toString();
            weather.temperatureLow = dayWeather.getAsJsonObject().get("temperatureLow").toString();
            weather.temperatureLowTime = dayWeather.getAsJsonObject().get("temperatureLowTime").toString();
            weather.apparentTemperatureHigh = dayWeather.getAsJsonObject().get("apparentTemperatureHigh").toString();
            weather.apparentTemperatureHighTime = dayWeather.getAsJsonObject().get("apparentTemperatureHighTime").toString();
            weather.apparentTemperatureLow = dayWeather.getAsJsonObject().get("apparentTemperatureLow").toString();
            weather.apparentTemperatureLowTime = dayWeather.getAsJsonObject().get("apparentTemperatureLowTime").toString();
            weather.dewPoint = dayWeather.getAsJsonObject().get("dewPoint").toString();
            weather.humidity = dayWeather.getAsJsonObject().get("humidity").toString();
            weather.pressure = dayWeather.getAsJsonObject().get("pressure").toString();
            weather.windSpeed = dayWeather.getAsJsonObject().get("windSpeed").toString();
            weather.windGust = dayWeather.getAsJsonObject().get("windGust").toString();
            weather.windGustTime = dayWeather.getAsJsonObject().get("windGustTime").toString();
            weather.windBearing = dayWeather.getAsJsonObject().get("windBearing").toString();
            weather.cloudCover = dayWeather.getAsJsonObject().get("cloudCover").toString();
            weather.uvIndex = dayWeather.getAsJsonObject().get("uvIndex").toString();
            weather.uvIndexTime = dayWeather.getAsJsonObject().get("uvIndexTime").toString();
            weather.visibility = dayWeather.getAsJsonObject().get("visibility").toString();
            weather.ozone = dayWeather.getAsJsonObject().get("ozone").toString();
            weather.temperatureMin = dayWeather.getAsJsonObject().get("temperatureMin").toString();
            weather.temperatureMinTime = dayWeather.getAsJsonObject().get("temperatureMinTime").toString();
            weather.temperatureMax = dayWeather.getAsJsonObject().get("temperatureMax").toString();
            weather.temperatureMaxTime = dayWeather.getAsJsonObject().get("temperatureMaxTime").toString();
            weather.apparentTemperatureMin = dayWeather.getAsJsonObject().get("apparentTemperatureMin").toString();
            weather.apparentTemperatureMinTime = dayWeather.getAsJsonObject().get("apparentTemperatureMinTime").toString();
            weather.apparentTemperatureMax = dayWeather.getAsJsonObject().get("apparentTemperatureMax").toString();
            weather.apparentTemperatureMaxTime = dayWeather.getAsJsonObject().get("apparentTemperatureMaxTime").toString();

        }

        days_weather = weathers;


        System.out.println("_______&&&&&&&&&"+ days_weather.get(7).time + "7");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(6).time + "6");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(5).time + "5");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(4).time + "4");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(3).time + "3");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(2).time + "2");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(1).time + "1");
        System.out.println("_______&&&&&&&&&"+ days_weather.get(0).time + "0");




    }


}
