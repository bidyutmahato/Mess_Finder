package com.bidyut.messfinder;

import android.Manifest;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bidyut.messfinder.Models.MainModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Add extends Fragment {

    public Add() {
        // Required empty public constructor
    }

    EditText name, type ,location , roll, amount, about;
    Button btnAdd;
    Uri filepath;
    ImageView img;
    Button browse;
    Bitmap bitmap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        name = (EditText)view.findViewById(R.id.txtName);
        type = (EditText)view.findViewById(R.id.txtType);
        location = (EditText)view.findViewById(R.id.txtLocation);
        roll=(EditText)view.findViewById(R.id.roll);
        amount=(EditText)view.findViewById(R.id.txtAmount);
        about=(EditText)view.findViewById(R.id.txtAbout);


        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        img = (ImageView) view.findViewById(R.id.img);
        browse=(Button)view.findViewById(R.id.browse_image);




        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withContext(getContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"select image file"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtofirebase();
                // insertData();
                // clearAll();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1 & resultCode ==getActivity().RESULT_OK){
            filepath = data.getData();
            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(filepath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);

            }catch (Exception ex){

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    private void uploadtofirebase() {

        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setTitle("File uploading...");
        dialog.show();


        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference uploader = storage.getReference("Image "+ new Random().nextInt(100));

        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                dialog.dismiss();
                                FirebaseDatabase db = FirebaseDatabase.getInstance();
                                DatabaseReference root = db.getReference("Mess");

                                MainModel obj = new MainModel(name.getText().toString(),
                                        location.getText().toString(),type.getText().toString(),
                                        uri.toString(),amount.getText().toString(),about.getText().toString());

                                root.child(roll.getText().toString()).setValue(obj);

                                clearAll();
                                Toast.makeText(getContext(), "Successfully data inserted", Toast.LENGTH_SHORT).show();



                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        float percent = (100*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        dialog.setMessage("Uploaded: "+(int)percent +"%");

                    }
                });

    }



     /* private void insertData(){
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

      */
    private void clearAll(){
        name.setText(" ");
        type.setText(" ");
        location.setText(" ");
        roll.setText(" ");
        img.setImageResource(R.drawable.icon_home);
        amount.setText(" ");
        about.setText(" ");
    }

}