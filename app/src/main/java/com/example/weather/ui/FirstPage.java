package com.example.weather.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.weather.MainActivity;
import com.example.weather.R;
import com.example.weather.api.APIThread;
import com.example.weather.api.Location;

import java.util.ArrayList;

public class FirstPage {
    private Activity activity;
    private ArrayList<String> locationsName = new ArrayList<>();
    private ArrayAdapter adapter;
    private ListView listView;

    public FirstPage(Activity _activity) {
        this.activity = _activity;
        this.adapter = new ArrayAdapter<String>(activity, R.layout.first_listview, locationsName);
        this.listView = activity.findViewById(R.id.locations_listView);
        listView.setAdapter(adapter);
    }

    public void updateList(ArrayList<Location> locations) {

        locationsName.clear();
        System.out.println("#$#$#$#$#$#$#$");

        for (String name :
                locationsName) {
            System.out.println("@@@@@@@@@@@@" + name);
        }

        System.out.println("^^^^^^^^^^6");



        for (Location location :
                locations) {
            locationsName.add(location.getName());
            System.out.println("________" + location.getName());
        }

        for (String name :
                locationsName) {
            System.out.println("@@@@@@@@@@@@" + name);
        }



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
                System.out.println("+++++++++is clickedddddddd");
//                Handler handler = new Handler();
                APIThread apiThread = new APIThread(activity, "location");

                apiThread.start();
            }
        });
    }
}


