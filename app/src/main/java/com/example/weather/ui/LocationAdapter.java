package com.example.weather.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.weather.activities.FirstActivity;
import com.example.weather.R;
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
                System.out.println("location sekevted :::::::"+location.getName());
                System.out.println("long :" + location.getLongitude());
                System.out.println("Lant : " + location.getLatitude());
                //todo : new page2
                //

               FirstActivity.secondPage.setLatitude(location.getLatitude());
               FirstActivity.secondPage.setLongitude(location.getLongitude());
               FirstActivity.firstPage.getActivity().setContentView(R.layout.second_page);
               //todo:back button(test)
               //Button button = FirstActivity.secondPage.getSecPageActivity().findViewById(R.id.btn_back);
               //button.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View v) {
//                       FirstActivity.secondPage.getSecPageActivity().setContentView(R.layout.first_page);
//                       FirstPage firstPage = new FirstPage(FirstActivity.firstPage.getActivity());
//                       firstPage.getActivity().setContentView(R.layout.first_page);
//                   }
//               });

                APIThread apiThread = new APIThread(FirstActivity.secondPage.getSecPageActivity() , "weather");
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
