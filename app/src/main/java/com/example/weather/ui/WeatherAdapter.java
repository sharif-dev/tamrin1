package com.example.weather.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.api.Location;
import com.example.weather.api.Weather;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class WeatherAdapter extends ArrayAdapter<Weather> {
    public WeatherAdapter(Context context, ArrayList<Weather> weathers) {

        super(context, 0, weathers);
        System.out.println("^^^()()()()())()^");
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        Weather weather = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.second_listview, parent, false);
        }

        TextView  temp = convertView.findViewById(R.id.weather);

        ImageView status  = convertView.findViewById(R.id.status);

        //System.out.println("weather icon : "  + weather.getIcon());
        //System.out.println("WEATHER TIME : " + weather.getTime());
        long time   = Integer.valueOf(weather.getTime());
        long milis = time *1000;
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE,MMMM d,yyyy h:mm,a" , Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = sdf.format(date);
        //System.out.println(formattedDate);

        //System.out.println("WEATHER SUNRISE  :" + weather.getSunriseTime());
        //System.out.println("WEATHER TIME CON : " + time);
        temp.setText("min temp : "+weather.getTemperatureMin() + "\n max : " + weather.getTemperatureMax() + "\n  icon : "+ weather.getIcon() + "\n Time : " + formattedDate);
        //System.out.println("---------------------------------------------");
        //status.setImageResource(R.drawable.wi_tornao);
        status = setImage(weather.getIcon() , status);


        return convertView;
    }


    public ImageView setImage(String icon , ImageView view){
        switch (icon){

            case "\"clear-day\"":
                view.setImageResource(R.drawable.wi_day_sunny);
                break;
            case "\"clear-night\"":
                view.setImageResource(R.drawable.wi_night_clear);
                break;
            case "\"rain\"":
                view.setImageResource(R.drawable.wi_rain);
                break;
            case "\"snow\"":
                view.setImageResource(R.drawable.wi_snow);
                break;
            case "\"sleet\"":
                view.setImageResource(R.drawable.wi_sleet);
                break;
            case "\"wind\"":
                view.setImageResource(R.drawable.wi_windy);
                break;
            case "\"fog\"":
                view.setImageResource(R.drawable.wi_fog);
                break;
            case "\"cloudy\"":
                view.setImageResource(R.drawable.wi_cloudy);
                break;
            case "\"partly-cloudy-day\"":
                view.setImageResource(R.drawable.wi_day_cloudy);
                break;
            case "\"partly-cloudy-night\"":
                view.setImageResource(R.drawable.wi_night_cloudy);
                break;
            case "\"hail\"":
                view.setImageResource(R.drawable.wi_hail);
                break;
            case "\"thunderstorm\"":
                view.setImageResource(R.drawable.wi_thunderstorm);
                break;
            case "\"tornado\"":
                view.setImageResource(R.drawable.wi_tornado);
                break;
            default:
                break;

        }

        return view;
    }

    @Nullable
    @Override
    public Weather getItem(int position) { //Todo : implement this method
        return super.getItem(position);
    }
}
