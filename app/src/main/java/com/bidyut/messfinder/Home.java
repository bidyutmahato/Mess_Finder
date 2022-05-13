package com.bidyut.messfinder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home extends Fragment {



    public Home() {
        // Required empty public constructor
    }

    ViewFlipper flipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        int imgarray[]={R.drawable.slideimage1,R.drawable.slideimage2,R.drawable.slideimage3};
        flipper=(ViewFlipper)view.findViewById(R.id.flipper);

        for (int i=0; i<imgarray.length;i++)
            showimage (imgarray[i]);


        return view;
    }

    public void showimage(int img){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3500);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        flipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);


    }
}