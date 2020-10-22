package com.example.sanv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity4 extends AppCompatActivity {
    static final int picId= 123;
    Button cameraOpen;
    VideoView clickVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){
        }
        cameraOpen = (Button) findViewById(R.id.buttonCamera);
        //clickVideo = (VideoView) findViewById(R.id.videoViewR);

        cameraOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent =  new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(cameraIntent, picId);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent cameraIntent) {
        super.onActivityResult(requestCode, resultCode, cameraIntent);
        if(requestCode == picId){
            Uri video = (Uri) cameraIntent.getData();
            //clickVideo.setVideoURI(video);
        }
    }
}