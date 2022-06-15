package com.example.school_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.provider.MediaStore;
import android.renderscript.ScriptGroup;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class setting extends AppCompatActivity {
    ArrayList  school_nameinArrayList;
    Intent intent3;
    EditText editText;
    RelativeLayout r1,r2;
    CardView change_logo,account_setting,change_name,logout,enterNameToChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        change_logo=findViewById(R.id.change_logo);


        account_setting=findViewById(R.id.account_settings);
        account_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        change_logo=findViewById(R.id.change_logo);
        change_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chang=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI) ;

                startActivityForResult(chang,100);

            }
        });



        change_name=findViewById(R.id.change_name);
        change_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterNameToChange=findViewById(R.id.change_name);
                enterNameToChange.setClickable(false);

                RelativeLayout r1=findViewById(R.id.re_name);
                r1.setVisibility(View.INVISIBLE);

                RelativeLayout r2=findViewById(R.id.re_name1);
                r2.setVisibility(View.VISIBLE);

            }
        });


        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3 =new Intent(setting.this,MainActivity.class);
                startActivity(intent3);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri u1 = data.getData();


        }
        Toast.makeText(setting.this, "Done", Toast.LENGTH_LONG).show();

    }

    public void change_name_school_button(View v){
        editText=(EditText) findViewById(R.id.edit_name);
        Toast.makeText(setting.this,"Done",Toast.LENGTH_LONG).show();
        r1=findViewById(R.id.re_name);
        r2=findViewById(R.id.re_name1);
        r2.setVisibility(View.INVISIBLE);
        r1.setVisibility(View.VISIBLE);


    }




}

