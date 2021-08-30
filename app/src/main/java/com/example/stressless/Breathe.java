package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Breathe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);

        Button squareInstructions = findViewById(R.id.square_breathing);
        squareInstructions.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Breathe.this, SquareInstructions.class);
                startActivity(intent);
            }
        });

        Button fseBreathing = findViewById(R.id.four_seven_eight);
        fseBreathing.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Breathe.this, FSEInstructions.class);
                startActivity(intent);
            }
        });
    }
}
