package com.example.weather.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class loading extends Fragment {


    public loading() {
        // Required empty public constructor
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

}
