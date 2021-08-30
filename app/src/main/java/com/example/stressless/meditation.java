package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class meditation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        //mystical garden audio play/pause on click
        final MediaPlayer mysticalGardenMP = MediaPlayer.create(this, R.raw.mystical_garden);
        final Button mysticalGarden = (Button) this.findViewById(R.id.garden);

        mysticalGarden.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(mysticalGardenMP.isPlaying())
                    mysticalGardenMP.pause();

                else
                    mysticalGardenMP.start();
            }
        });

        //autumn cottage audio play/pause on click
        final MediaPlayer autumnCottageMP = MediaPlayer.create(this, R.raw.autumn_cottage);
        final Button autumnCottage = (Button) this.findViewById(R.id.cottage);

        autumnCottage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(autumnCottageMP.isPlaying())
                    autumnCottageMP.pause();

                else
                    autumnCottageMP.start();

            }
        });

        //healing temple audio play/pause on click
        final MediaPlayer healingTempleMP = MediaPlayer.create(this, R.raw.healing_temple);
        final Button healingTemple = (Button) this.findViewById(R.id.temple);

        healingTemple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (healingTempleMP.isPlaying())
                    healingTempleMP.pause();

                else
                    healingTempleMP.start();

            }
        });
    }
}