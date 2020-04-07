package com.example.weather.ui;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.weather.MainActivity;
import com.example.weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Loading extends Fragment {

    public Loading() {
        System.out.println("HELLOOOOOOOOOO");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.loading, container, false);
        ImageView loadImage = v.findViewById(R.id.anim_load);
        Animation load = AnimationUtils.loadAnimation(getActivity(), R.anim.loadsymbol);
        loadImage.startAnimation(load);
        return v;
    }

    public void showLoading(Activity activity) {

        if(activity.findViewById(R.id.fragment_container) != null) {
            this.setArguments(activity.getIntent().getExtras());

            android.app.FragmentManager fragmentManager = activity.getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.fragment_container, this, "loadingFragment");
            ft.commit();

        }
    }

    public void removeLoadFragment(Activity activity) {
        if(activity.findViewById(R.id.fragment_container) != null) {
            Fragment loading = getFragmentManager().findFragmentByTag("loadingFragment");
            if (loading != null) {
                getFragmentManager().beginTransaction().remove(loading).commit();
            }
        }


    }


}

