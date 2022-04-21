package com.bidyut.messfinder;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Add extends Fragment {

    public Add() {
        // Required empty public constructor
    }

    EditText name, type ,location;
    Button btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        name = (EditText) view.findViewById(R.id.txtName);
        type = (EditText) view.findViewById(R.id.txtType);
        location = (EditText) view.findViewById(R.id.txtLocation);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });

        return view;
    }


    private void insertData(){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("type",type.getText().toString());
        map.put("location",location.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Mess").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getContext(), "Successfully data inserted", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure( Exception e) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll(){
        name.setText(" ");
        type.setText(" ");
        location.setText(" ");
    }

}