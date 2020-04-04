package com.example.weather.ui;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weather.MainActivity;
import com.example.weather.R;
import com.example.weather.api.APIThread;
import com.example.weather.api.Location;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {



    public LocationAdapter(Context context, ArrayList<Location> locations) {

        super(context, 0, locations);
        System.out.println("^^^()()()()())()^");
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Location location = getItem(position);

        System.out.println("^^^^^^^^" + location.getName());



        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.first_listview, parent, false);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("location sekevted :::::::"+location.getName());
                System.out.println("long :" + location.getLongitude());
                System.out.println("Lant : " + location.getLatitude());
                //todo : new page2
                MainActivity.secondPage.setLatitude(location.getLatitude());
                MainActivity.secondPage.setLongitude(location.getLongitude());

                APIThread apiThread = new APIThread(MainActivity.secondPage.getSecPageActivity() , "weather");
                apiThread.start();
            }
        });
        TextView locationName = convertView.findViewById(R.id.location);
        locationName.setText(location.getName());

        return convertView;

    }
    @Nullable
    @Override
    public Location getItem(int position) { //Todo : implement this method
        return super.getItem(position);
    }


}
