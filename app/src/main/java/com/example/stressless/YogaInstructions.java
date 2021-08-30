package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YogaInstructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_instructions);

        Button yoga = findViewById(R.id.nextYoga);
        yoga.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(YogaInstructions.this, Yoga.class);
                startActivity(intent);
            }
        });
    }
}
