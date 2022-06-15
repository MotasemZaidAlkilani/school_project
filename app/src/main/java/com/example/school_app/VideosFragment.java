package com.example.school_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters
    private static final String GradeIdText = "GradeId";
    private static final String GradeText = "Grade";
    private static final String GradeNoText = "GradeNo";
    private static final String SubjectText = "Subject";
    private static final String TeacherSSNText = "TeacherSSN";
    private static final String TeacherNameText = "TeacherName";

    private String GradeId ;
    private String Grade;
    private String GradeNo;
    private String Subject;
    private String TeacherSSN;
    private String TeacherName;

    TextView tt;
    Button vidUpload;
    RecyclerView vidRecycler;

    public VideosFragment() {
        // Required empty public constructor
    }





    // TODO: Rename and change types and number of parameters
    public static VideosFragment newInstance(String GradeId,String Grade , String GradeNo ,String Subject , String TeacherSSN,String TeacherName) {
        VideosFragment fragment = new VideosFragment();
        Bundle args = new Bundle();
        args.putString(GradeIdText, GradeId);
        args.putString(GradeText, Grade);
        args.putString(GradeNoText, GradeNo);
        args.putString(SubjectText, Subject);
        args.putString(TeacherSSNText, TeacherSSN);
        args.putString(TeacherNameText, TeacherName);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v =  inflater.inflate(R.layout.fragment_videos, container, false);

        if (getArguments() != null) {
            GradeId = getArguments().getString(GradeIdText);
            Grade =  getArguments().getString(GradeText);
            GradeNo =  getArguments().getString(GradeNoText);
            Subject = getArguments().getString(SubjectText);
            TeacherSSN =  getArguments().getString(TeacherSSNText);
            TeacherName = getArguments().getString(TeacherNameText);
        }

        vidUpload=v.findViewById(R.id.uploadVidBtn);
        vidUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent= new Intent(getActivity(),uploadVideo.class);
                myIntent.putExtra(GradeIdText,GradeId);
                myIntent.putExtra(GradeText,Grade);
                myIntent.putExtra(GradeNoText, GradeNo);
                myIntent.putExtra(SubjectText,Subject);
                myIntent.putExtra(TeacherSSNText,TeacherSSN);
                myIntent.putExtra(TeacherNameText,TeacherName);
                startActivity(myIntent);

            }
        });

        return  v ;
    }








}