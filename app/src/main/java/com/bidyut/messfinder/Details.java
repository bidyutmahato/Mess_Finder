package com.bidyut.messfinder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import de.hdodenhof.circleimageview.CircleImageView;


public class Details extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String name, type, location, mimage, amount;
    private AdView mAdView;

    public Details() {

    }

    public Details (String name,String type,String location ,String mimage, String amount){
        this.name=name;
        this.type=type;
        this.location=location;
        this.mimage = mimage;
        this.amount = amount;

    }

    public static Details newInstance(String param1, String param2) {
        Details fragment = new Details();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView typeholder = view.findViewById(R.id.typeholder);
        TextView locationholder = view.findViewById(R.id.locationholder);
        TextView amountholder = view.findViewById(R.id.amountholder);
        ImageView imageholder = view.findViewById(R.id.image_holder);

        nameholder.setText(name);
        typeholder.setText(type);
        locationholder.setText(location);
        amountholder.setText(amount);
        Glide.with(getContext()).load(mimage).into(imageholder);


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

        return view;
    }
    public void onBackPress(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,new Search()).addToBackStack(null).commit();
    }
}