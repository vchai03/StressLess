package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class StressLevel extends AppCompatActivity {

    private SeekBar seek_bar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_level);

        intent = new Intent(StressLevel.this, Options.class);

        //change message based on seekbar
        seek_bar = findViewById(R.id.seekBar);

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress >= 0 && progress <= 2)
                    intent.putExtra("message", "suggested for low stress: get in the ambience with a sound image!");

                else if(progress >= 3 && progress <= 5)
                    intent.putExtra("message", "suggested for medium stress: do a short breathing exercise and get in the ambience with a sound image!");

                else if(progress >=6 && progress <= 8)
                    intent.putExtra("message", "suggested for high stress: use one of the guided meditations and do a breathing exercise!");

                else
                    intent.putExtra("message", "suggested for extreme stress: do yoga and meditate!");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button stress_level = findViewById(R.id.stress_level);
        stress_level.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(intent);
            }

        });

    }
}
