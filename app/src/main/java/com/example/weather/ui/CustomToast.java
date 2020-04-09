package com.example.weather.ui;

import android.content.Context;
import android.widget.Toast;

import com.example.weather.R;

public class CustomToast {
    private static int duration = Toast.LENGTH_LONG;

    public CustomToast(Context context, int net) {
        Toast toast = Toast.makeText(context, net, duration);
        toast.show();
    }
}
