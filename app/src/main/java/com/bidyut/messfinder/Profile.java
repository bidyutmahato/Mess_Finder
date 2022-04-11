package com.bidyut.messfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bidyut.messfinder.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;


public class Profile extends Fragment {
    public Profile() {
        // Required empty public constructor
    }
    TextView textView;
    FragmentProfileBinding binding;
    FirebaseAuth auth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        textView = view.findViewById(R.id.txtLogout);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "logout", Toast.LENGTH_SHORT).show();
                auth.signOut();

            }

        });


        return view;

    }
}