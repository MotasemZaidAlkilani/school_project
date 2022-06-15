package com.example.school_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class TeacherUI extends AppCompatActivity {
 TextView myView;
 Button CreateClassBtn;
 String userSSN, userName , userPassword , userPhone;
  DatabaseReference myRef;
  private FirebaseRecyclerOptions<ClassRoomModel> options;
  private FirebaseRecyclerAdapter<ClassRoomModel , ViewHolder> myAdapter;
  private RecyclerView myRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_u_i);



        final Intent intent=getIntent();
        userSSN =intent.getStringExtra("ssn");

        myView = findViewById(R.id.SSNText);

        myRef = FirebaseDatabase.getInstance().getReference().child("Teachers").child("teacher-"+userSSN);
        myRecycler=findViewById(R.id.classesRecycler);
        myRecycler.setHasFixedSize(true);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 userSSN = snapshot.child("_TeacherSSN").getValue().toString();
                userName= snapshot.child("_TeacherName").getValue().toString();
                 userPassword= snapshot.child("_TeacherPassword").getValue().toString();
                userPhone = snapshot.child("_TeacherPhone").getValue().toString();


                myView.setText("Welcome Mr "+userName+"\nchoose a Class or Create new Class :");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        CreateClassBtn= findViewById(R.id.createClassBtn);
        CreateClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(TeacherUI.this , AddClass.class);
                myIntent.putExtra("ssn",userSSN);
                myIntent.putExtra("Name",userName);
                startActivity(myIntent);

            }
        });
        myRef = FirebaseDatabase.getInstance().getReference().child("Teachers").child("teacher-"+userSSN).child("_Classes");
        Query query = FirebaseDatabase.getInstance().getReference().child("Teachers").child("teacher-"+userSSN).child("_Classes");

        CreateClassBtn =findViewById(R.id.createClassBtn);
        CreateClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntene = new Intent(TeacherUI.this , AddClass.class);
                myIntene.putExtra("ssn",userSSN);
                myIntene.putExtra("Name",userName);
                startActivity(myIntene);
            }
        });


       options = new FirebaseRecyclerOptions.Builder<ClassRoomModel>().setQuery(query,ClassRoomModel.class).build(); // switch to my ref
       myAdapter = new FirebaseRecyclerAdapter<ClassRoomModel, ViewHolder>(options) {
           @Override
           protected void onBindViewHolder(@NonNull final ViewHolder holder, int position, @NonNull final ClassRoomModel model) {

               holder.GradeText.setText(model.getClassGarde());
               holder.GradeNoText.setText("Grade No : "+model.getClassNo());
               holder.SubjectText.setText(model.getClassSubject());
               holder.classId=model.getClassID();
               holder.TeacherSSN=model.getClassTeacherSSN();
               holder.TeacherName=model.getClassTeacherName();
               holder.Grade = model.getClassGarde();
               holder.GradeNo=model.getClassNo();
               holder.Subject=model.classSubject;

               holder.goToClassBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String GradeId = holder.classId;
                       String TeacherSSN = holder.TeacherSSN;
                       String TeacherName = holder.TeacherName;
                       String Grade = holder.Grade;
                       String GradeNo = holder.GradeNo;
                       String Subject = holder.Subject;

                       Intent myIntent = new Intent(TeacherUI.this,TeacherClassRoom.class);
                       myIntent.putExtra("GradeId",GradeId);
                       myIntent.putExtra("Grade",Grade);
                       myIntent.putExtra("GradeNo",GradeNo);
                       myIntent.putExtra("Subject",Subject);
                       myIntent.putExtra("TeacherSSN",TeacherSSN);
                       myIntent.putExtra("TeacherName",TeacherName);
                       startActivity(myIntent);



                   }
               });


           }

           @NonNull
           @Override
           public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_class_layout,parent,false);

               return new ViewHolder(myView);
           }
       };

          myAdapter.startListening();
          myRecycler.setAdapter(myAdapter);


    }




}