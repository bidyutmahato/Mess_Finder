package com.bidyut.messfinder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class Home extends Fragment {

    private AdView mAdView;

    public Home() {

    }

    ViewFlipper flipper;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        int imgarray[]={R.drawable.slideimage1,R.drawable.slideimage2,R.drawable.slideimage3};
        flipper=(ViewFlipper)view.findViewById(R.id.flipper);

        for (int i=0; i<imgarray.length;i++)
            showimage (imgarray[i]);



/*
        mAdView = view.findViewById(R.id.bannerAds);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdClosed() {

            }
        });



 */

        return view;
    }

    public void showimage(int img){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3200);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        flipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);


    }
 }


