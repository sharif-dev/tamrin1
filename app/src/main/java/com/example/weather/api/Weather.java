package com.example.weather.api;

import android.os.Handler;
import android.os.Message;
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

    public String getSunriseTime() {
        return sunriseTime;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public String getPrecipIntensity() {
        return precipIntensity;
    }

    public String getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public String getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public String getPrecipProbability() {
        return precipProbability;
    }

    public String getTemperatureHigh() {
        return temperatureHigh;
    }

    public String getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public String getTemperatureLow() {
        return temperatureLow;
    }

    public String getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public String getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public String getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public String getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public String getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindGust() {
        return windGust;
    }

    public String getWindGustTime() {
        return windGustTime;
    }

    public String getWindBearing() {
        return windBearing;
    }

    public String getCloudCover() {
        return cloudCover;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public String getUvIndexTime() {
        return uvIndexTime;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getOzone() {
        return ozone;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public String getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public String getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public String getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public String getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public String getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public String getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }
}
