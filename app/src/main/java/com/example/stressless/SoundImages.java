package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundImages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_images);

        //coffee shop sound image
        Button coffee_shop = findViewById(R.id.coffee_shop);
        coffee_shop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(SoundImages.this, CoffeeShop.class);
                startActivity(intent);
            }
        });

        //autumn morning sound image
        Button autumn_morning = findViewById(R.id.autumn_morning);
        autumn_morning.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(SoundImages.this, AutumnMorning.class);
                startActivity(intent);
            }
        });

        //waterfall sound image
        Button waterfall = findViewById(R.id.waterfall);
        waterfall.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(SoundImages.this, Waterfall.class);
                startActivity(intent);
            }
        });
    }
}
