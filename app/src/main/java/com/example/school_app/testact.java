package com.example.school_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class testact extends AppCompatActivity {
    DatabaseReference myReff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testact);

        myReff = FirebaseDatabase.getInstance().getReference().child("Students");


        Video myv = new Video();
        myv.setVideoUri("hhh");
        myv.setVideoName("kkk");

        myReff.child("11").setValue(myv);
    }
}