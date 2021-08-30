package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button triangle = findViewById(R.id.triangle);
        triangle.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,StressLevel.class);
                startActivity(intent);
            }
        });

    }
}