        package com.example.school_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class uploadVideo extends AppCompatActivity {
    //the index id of data stored from intent

    private static final String GradeIdText = "GradeId";
    private static final String GradeText = "Grade";
    private static final String GradeNoText = "GradeNo";
    private static final String SubjectText = "Subject";
    private static final String TeacherSSNText = "TeacherSSN";
    private static final String TeacherNameText = "TeacherName";

    private static final int PICK_VIDEO_REQUEST = 1; // the value to get video from phone storage which will be used in method

    // to store data from intent
    private String GradeId;
    private String Grade;
    private String GradeNo;
    private String Subject;
    private String TeacherSSN;
    private String TeacherName;


    Button chooseBtn;
    Button uploadBtn;
    public EditText videoName;
    public Uri videoUri;
    VideoView vidView;
    MediaController myController;
    StorageReference myStorageRef;
    DatabaseReference myDataRef;
    ProgressBar mybar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_video);

        Intent myIntent = getIntent();
        GradeId = myIntent.getStringExtra(GradeIdText);
        Grade = myIntent.getStringExtra(GradeText);
        GradeNo = myIntent.getStringExtra(GradeNoText);
        Subject = myIntent.getStringExtra(SubjectText);
        TeacherSSN = myIntent.getStringExtra(TeacherSSNText);
        TeacherName = myIntent.getStringExtra(TeacherNameText);

        chooseBtn = findViewById(R.id.chooseVidBtn);
        uploadBtn = findViewById(R.id.vidConfirmBtn);
        videoName = findViewById(R.id.VidoeName);
        vidView = findViewById(R.id.myVidView);
        mybar = findViewById(R.id.uploadProgress);

        Intent myint = new Intent(uploadVideo.this , testact.class);
        startActivity(myint);



        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseVideo();

            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadEvent();
            }
        });




        myController = new MediaController(this);
        vidView.setMediaController(myController);
        myController.setAnchorView(vidView);
        vidView.start();

        myStorageRef = FirebaseStorage.getInstance().getReference().child(GradeId);





    }

    // get Video from storage method
    public void chooseVideo() {
        Intent myIntent = new Intent();
        myIntent.setType("vider/*");
        myIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(myIntent, PICK_VIDEO_REQUEST);


    }

    public void uploadEvent()
    {

        mybar.setVisibility(View.VISIBLE);
        StorageReference myUploader = myStorageRef.child("Videos").child(videoName.getText().toString());
        myUploader.putFile(videoUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        myUploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                mybar.setVisibility(View.INVISIBLE);
                                new SweetAlertDialog(uploadVideo.this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("Success !").show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                new SweetAlertDialog(uploadVideo.this,SweetAlertDialog.ERROR_TYPE).setTitleText("Failed!").show();
                            }
                        });
                    }
                });
    }




    // set chosen video to be played in the Videoview
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null)
            ;

        videoUri = data.getData();
        vidView.setVideoURI(videoUri);

    }

    // get the extension of media
    private String getFileExtenstion(Uri videoUri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(videoUri));

    }




}
