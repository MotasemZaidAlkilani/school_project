package com.example.school_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class splashWelcom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent HomeIntent = new Intent(splashWelcom.this,MainActivity.class);
                 startActivity(HomeIntent);
                 finish();
             }
         },3000);
        setContentView(R.layout.activity_splash_welcom);
    }



}