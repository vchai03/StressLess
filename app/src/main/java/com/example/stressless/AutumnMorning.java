package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class AutumnMorning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autumn_morning);

        final VideoView videoView = findViewById(R.id.autumn_morning);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.autumn_morning;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        MediaController mediaController = new MediaController(AutumnMorning.this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
