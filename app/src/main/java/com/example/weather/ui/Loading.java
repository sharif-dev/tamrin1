package com.example.weather.ui;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
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

    FragmentManager fragmentManager;

    private FragmentActivity myContext;

    public Loading() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        System.out.println("aloooooooooooooo");



        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.loading, container, false);
        ImageView loadImage = v.findViewById(R.id.anim_load);
        Animation load = AnimationUtils.loadAnimation(getActivity(), R.anim.loadsymbol);
        loadImage.startAnimation(load);
        return v;
    }

    public void showLoading(Activity activity) {
        System.out.println("HELLOOOOOOOO??????");

        if(activity.findViewById(R.id.fragment_container) != null) {
            System.out.println("WHATTTTTTTTT?");
            Loading l = new Loading();
            l.setArguments(activity.getIntent().getExtras());
            ////
////            activity.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, l).commit();
            activity.getFragmentManager().beginTransaction().replace(R.id.fragment_container, l).commit();




        }
    }



}

