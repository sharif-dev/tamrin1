package com.example.weather.api;

import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Weather implements Parcelable {

    private static ArrayList<Weather> days_weather = new ArrayList<>();

    private String time;
    private String summary;
    private String icon;
    private String temperatureMin;
    private String temperatureMax;

    private Weather() {

    }


    private Weather(Parcel in) {
        time = in.readString();
        summary = in.readString();
        icon = in.readString();
        temperatureMin = in.readString();
        temperatureMax = in.readString();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
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
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonElement dailyData = jsonObject.get("daily");
        JsonObject datasObject = dailyData.getAsJsonObject();
        JsonArray datas = datasObject.getAsJsonArray("data");

        ArrayList<Weather> weathers = new ArrayList<>();

        for (JsonElement dayWeather :
                datas) {

            Weather weather = new Weather();

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
        return "Minimum Temperature : " + temperatureMin + "℃";
    }


    public String getTemperatureMax() {
        return "Maximum Temperature : " + temperatureMax + "℃";
    }

}
