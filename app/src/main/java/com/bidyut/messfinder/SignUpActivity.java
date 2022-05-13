package com.bidyut.messfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bidyut.messfinder.Models.Users;
import com.bidyut.messfinder.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating...");
        progressDialog.setMessage("Creating your account...");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();

                auth.createUserWithEmailAndPassword
                        (binding.etEmail.getText().toString(),
                                binding.etPassword.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Sucessfully Created", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                            Users user = new Users(binding.etUserName.getText().toString(),
                                                   binding.etEmail.getText().toString(),
                                                   binding.etPassword.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                        }
                        else {
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}