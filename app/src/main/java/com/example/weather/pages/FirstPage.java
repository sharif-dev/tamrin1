package com.example.weather.pages;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.weather.R;
import com.example.weather.api.APIThread;
import com.example.weather.api.Location;
import com.example.weather.ui.Loading;
import com.example.weather.ui.LocationAdapter;

import java.util.ArrayList;

public class FirstPage {
    private Activity activity;
    private ArrayList<String> locationsName = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();
    private LocationAdapter adapter;
    private ListView listView;

    private ArrayList<String> strings = new ArrayList<>();

    private Loading loadFragment;

    public FirstPage(Activity _activity) {
        this.activity = _activity;
        this.adapter = new LocationAdapter(activity, locations);
        this.listView = activity.findViewById(R.id.locations_listView);
        listView.setAdapter(adapter);

        loadFragment = new Loading();

    }


    public void updateList(ArrayList<Location> myLocations) {
        locations.clear();
        locations.addAll(myLocations);


        adapter.notifyDataSetChanged();
    }

    public String getEditTextLocation() {
        EditText editText = activity.findViewById(R.id.enter_location);
        return editText.getText().toString();
    }

    public void onSearchButtonClick() {
        Button button = activity.findViewById(R.id.search_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIThread apiThread = new APIThread(activity, "location");
                apiThread.start();
            }
        });
    }

    public Activity getActivity() {
        return activity;
    }


    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Loading getLoadFragment() {
        return loadFragment;
    }

    public void setLoadFragment(Loading loadFragment) {
        this.loadFragment = loadFragment;
    }

}

