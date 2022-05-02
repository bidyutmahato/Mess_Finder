package com.bidyut.messfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bidyut.messfinder.databinding.ActivityMessDetailsBinding;

public class MessDetailsActivity extends AppCompatActivity {
    ActivityMessDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}