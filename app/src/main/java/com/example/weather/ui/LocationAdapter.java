package com.example.weather.ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.weather.activities.FirstActivity;
import com.example.weather.R;
import com.example.weather.activities.SecondActivity;
import com.example.weather.api.APIThread;
import com.example.weather.api.Location;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {



    public LocationAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Location location = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_item, parent, false);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIThread apiThread = new APIThread(FirstActivity.secondPage.getSecPageActivity() , "weather");
                apiThread.setLatitude(location.getLatitude());
                apiThread.setLongitude(location.getLongitude());
                apiThread.start();

            }
        });
        TextView locationName = convertView.findViewById(R.id.location_name);

        locationName.setText(location.getName());

        return convertView;

    }
    @Nullable
    @Override
    public Location getItem(int position) { //Todo : implement this method
        return super.getItem(position);
    }


}
