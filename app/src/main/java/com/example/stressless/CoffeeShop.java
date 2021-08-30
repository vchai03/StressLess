package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.view.View;

public class CoffeeShop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shop);

        final VideoView videoView = findViewById(R.id.coffee_shop);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.rainy_coffee_shop;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        MediaController mediaController = new MediaController(CoffeeShop.this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
