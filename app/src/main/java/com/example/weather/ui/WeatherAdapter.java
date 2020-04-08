package com.example.weather.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.activities.WeatherParcelable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class WeatherAdapter extends ArrayAdapter<WeatherParcelable> {
    public WeatherAdapter(Context context, ArrayList<WeatherParcelable> weathers) {

        super(context, 0, weathers);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        WeatherParcelable weather = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.second_listview, parent, false);
        }

        TextView minTemp = convertView.findViewById(R.id.weather_min_temp);
        TextView maxTemp = convertView.findViewById(R.id.weather_max_temp);
        TextView weatherTime = convertView.findViewById(R.id.weather_time);
        TextView summery = convertView.findViewById(R.id.weather_summery);
        TextView description = convertView.findViewById(R.id.weather_icon);
        ImageView status  = convertView.findViewById(R.id.status);

        long time   = Integer.valueOf(weather.getTime());
        long milis = time *1000;
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE,MMMM d,yyyy h:mm,a" , Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = sdf.format(date);

        weatherTime.setText(formattedDate);
        minTemp.setText(weather.getTemperatureMin());
        maxTemp.setText(weather.getTemperatureMax());
        summery.setText(weather.getSummary());
        description.setText(weather.getIcon());

        status = setImage(weather.getIcon() , status);
        return convertView;
    }


    private ImageView setImage(String icon, ImageView view){
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
    public WeatherParcelable getItem(int position) { //Todo : implement this method
        return super.getItem(position);
    }
}
