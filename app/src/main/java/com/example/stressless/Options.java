package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Options extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        //change text based on seekbar
        text = findViewById(R.id.recs);
        text.setText(getIntent().getStringExtra("message"));

        //buttons
        Button meditation = findViewById(R.id.meditation);
        meditation.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Options.this, MeditationInstructions.class);
                startActivity(intent);
            }
        });

        Button breathing = findViewById(R.id.breathing);
        breathing.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Options.this, Breathe.class);
                startActivity(intent);
            }
        });

        Button soundImages = findViewById(R.id.sound_images);
        soundImages.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Options.this, SoundImages.class);
                startActivity(intent);
            }
        });

        Button yoga = findViewById(R.id.yoga);
        yoga.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Options.this, YogaInstructions.class);
                startActivity(intent);
            }
        });
    }
}