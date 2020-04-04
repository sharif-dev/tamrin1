package com.example.weather.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.api.Location;
import com.example.weather.api.Weather;

import java.util.ArrayList;

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
        temp.setText("min temp : "+weather.getTemperatureMin() + "\n max : " + weather.getTemperatureMax());

        return convertView;
    }

    @Nullable
    @Override
    public Weather getItem(int position) { //Todo : implement this method
        return super.getItem(position);
    }
}
