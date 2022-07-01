package com.bidyut.messfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.bidyut.messfinder.Models.MainModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
FirebaseAuth auth;
BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);
        auth = FirebaseAuth.getInstance();

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

             //   if (id==R.id.nav_Home){
                 //   loadFrag(new Home(),false);

              //  }else

                if (id==R.id.nav_search){
                    loadFrag(new Search(),false);

                }else if (id==R.id.nav_add){
                    loadFrag(new Add(),false);

                }else if (id==R.id.nav_manager){
                    loadFrag(new Manager(),false);

                }else {  // profile
                    loadFrag(new Profile() ,false);
                }

                return true;
            }
        });
        bnView.setSelectedItemId(R.id.nav_search);
    }
    public void loadFrag (Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);

        ft.commit();
    }
}