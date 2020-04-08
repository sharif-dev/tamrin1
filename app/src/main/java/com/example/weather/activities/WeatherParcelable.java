package com.example.weather.activities;

import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class WeatherParcelable implements Parcelable {

    private static ArrayList<WeatherParcelable> days_weather = new ArrayList<>();

    private String time;
    private String summary;
    private String icon;
    private String temperatureMin;
    private String temperatureMax;

    public WeatherParcelable() {

    }


    protected WeatherParcelable(Parcel in) {
        time = in.readString();
        summary = in.readString();
        icon = in.readString();
        temperatureMin = in.readString();
        temperatureMax = in.readString();
    }

    public static final Creator<WeatherParcelable> CREATOR = new Creator<WeatherParcelable>() {
        @Override
        public WeatherParcelable createFromParcel(Parcel in) {
            return new WeatherParcelable(in);
        }

        @Override
        public WeatherParcelable[] newArray(int size) {
            return new WeatherParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(summary);
        dest.writeString(icon);
        dest.writeString(temperatureMin);
        dest.writeString(temperatureMax);
    }

    public static void processWeatherRes(String response, Handler handler) {
        System.out.println("##########response:"+response);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonElement dailyData = jsonObject.get("daily");
        JsonObject datasObject = dailyData.getAsJsonObject();
        JsonArray datas = datasObject.getAsJsonArray("data");

        ArrayList<WeatherParcelable> weathers = new ArrayList<>();

//        WeatherParcelable weather = new WeatherParcelable();

        for (JsonElement dayWeather :
                datas) {

            WeatherParcelable weather = new WeatherParcelable();

//            WeatherParcelable weather = new WeatherParcelable();
//            weathers.add(weather);
            weather.time = dayWeather.getAsJsonObject().get("time").toString();
            weather.summary = dayWeather.getAsJsonObject().get("summary").toString();
            weather.icon = dayWeather.getAsJsonObject().get("icon").toString();
            weather.temperatureMin = dayWeather.getAsJsonObject().get("temperatureMin").toString();
            weather.temperatureMax = dayWeather.getAsJsonObject().get("temperatureMax").toString();
            weathers.add(weather);


        }

        days_weather.clear();
        days_weather.addAll(weathers);

        Message message = new Message();
        message.what = 1;
        message.obj = days_weather;

        handler.sendMessage(message);

    }

    public static ArrayList<WeatherParcelable> getDays_weather() {
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

    public static void setDays_weather(ArrayList<WeatherParcelable> days_weather) {
        WeatherParcelable.days_weather = days_weather;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }
}
