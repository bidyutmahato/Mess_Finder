package com.bidyut.messfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bidyut.messfinder.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;


public class Profile extends Fragment {
    public Profile() {
        // Required empty public constructor
    }
    TextView privecy , invite , needhelp ,settings , notification;
    Button button ,editprofile;
    WebView webView;
    TextView listYourProperty;
    FragmentProfileBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        button = view.findViewById(R.id.btn_Logout);
        privecy = view.findViewById(R.id.privecy_policy);
        webView=view.findViewById(R.id.webView);
        listYourProperty = view.findViewById(R.id.list_Your_Property);
        invite = view.findViewById(R.id.invite_id);
        needhelp = view.findViewById(R.id.needhelp_id);
        settings = view.findViewById(R.id.setting_id);
        notification = view.findViewById(R.id.notification_id);
        editprofile = view.findViewById(R.id.edit_profile_id);



        privecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // webView.loadUrl("https://techbyts.in/mess-finder-privecy-policy/");

                Uri uri = Uri.parse("https://techbyts.in/mess-finder-privecy-policy/");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);

               FirebaseAuth.getInstance().signOut();

            }

        });

        listYourProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
               fm.replace(R.id.container,new Add()).commit();
            }
        });

        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Body = "Download the app now";
                String Sub = "https://play.google.com/store/apps/details?id=com.bidyut.messfinder";
                intent.putExtra(Intent.EXTRA_TEXT,Body);
                intent.putExtra(Intent.EXTRA_TEXT,Sub);
                startActivity(Intent.createChooser(intent,"Share this app"));
            }
        });

        needhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,new ContactUs()).commit();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,new Settings()).commit();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,new Notification()).commit();
            }
        });

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,new EditProfile()).commit();
            }
        });

        return view;

    }

}