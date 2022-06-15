package com.example.school_app;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ViewHolder extends RecyclerView.ViewHolder {

   TextView GradeText;
   TextView GradeNoText;
   TextView SubjectText;
   Button goToClassBtn;
   String classId ;
   String TeacherSSN ;
   String TeacherName;
   String Grade;
   String GradeNo;
   String Subject;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        GradeText=itemView.findViewById(R.id.gradeText);
        GradeNoText=itemView.findViewById(R.id.gradeNoText);
        SubjectText=itemView.findViewById(R.id.subjectText);
        goToClassBtn= itemView.findViewById(R.id.goToClassBtn);





    }
}
