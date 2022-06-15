package com.example.school_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class admin extends AppCompatActivity {


   private String ssn;
   private Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        final Intent intent=getIntent();
        ssn=intent.getStringExtra("ssn");


        CardView e1=findViewById(R.id.add_student_card);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  intent2=new Intent(admin.this,add.class);
               intent2.putExtra("nametype","Add Student");
               startActivity(intent2);
            }
        });


        CardView e2=findViewById(R.id.add_teacher_card);
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    intent2=new Intent(admin.this,add.class);
                intent2.putExtra("nametype","Add Teacher");
               startActivity(intent2);
            }
        });

        CardView e3=findViewById(R.id.add_class_card);
        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    intent2=new Intent(admin.this,add.class);
                 intent2.putExtra("nametype","Add Class");
                startActivity(intent2);
            }
        });




        CardView e5=findViewById(R.id.search_card);
        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    intent2=new Intent(admin.this,.class);
                // intent2.putExtra("nametype","Search");
                //startActivity(intent2);
            }
        });

        CardView e6=findViewById(R.id.settings_card);
        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         intent2 =new Intent(admin.this,setting.class);
         startActivity(intent2);

            }
        });

               CardView e7=findViewById(R.id.delete_card);
        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        CardView e8=findViewById(R.id.add_admin_card);
        e8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 DatabaseReference myReff = FirebaseDatabase.getInstance().getReference().child("Admins").child("Admin-"+ssn);
                 myReff.addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot snapshot) {
                         String permession = snapshot.child("_AddPermession").getValue().toString();
                         if(permession.equals("Allowed"))
                         {
                             intent2=new Intent(admin.this,add.class);
                             intent2.putExtra("nametype","Add Admin");
                             startActivity(intent2);
                         }

                         else
                             new SweetAlertDialog(admin.this,SweetAlertDialog.ERROR_TYPE).setTitleText("You Arent Allowed to add Admins").show();
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });

            }
        });



    }
}