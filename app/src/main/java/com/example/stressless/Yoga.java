package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Yoga extends AppCompatActivity {

    private CheckBox catPose, bridgePose, boatPose, camelPose, lordPose, pigeonPose;
    private Integer catImg, bridgeImg, boatImg, camelImg, lordImg, pigeonImg;
    private ArrayList<String> choices;
    private ArrayList<Integer> images;
    private Button next;
    private int timeInSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"15 sec", "30 sec", "45 sec", "1 min"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                String timeSegment = item.substring(0, item.indexOf(" "));
                timeInSeconds = Integer.parseInt(timeSegment);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        catPose = findViewById(R.id.checkBox);
        bridgePose = findViewById(R.id.checkBox2);
        boatPose = findViewById(R.id.checkBox3);
        camelPose = findViewById(R.id.checkBox4);
        lordPose = findViewById(R.id.checkBox5);
        pigeonPose = findViewById(R.id.checkBox6);

        catImg = R.drawable.cat_pose;
        bridgeImg = R.drawable.bridge_pose;
        boatImg = R.drawable.boat_pose;
        camelImg = R.drawable.camel_pose;
        lordImg = R.drawable.lord_of_the_dance_pose;
        pigeonImg = R.drawable.king_pigeon_pose;

        choices = new ArrayList<>();
        images = new ArrayList<>();

        catPose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(catPose.isChecked()) {
                    choices.add("Cat Pose");
                    images.add(catImg);
                }
                else {
                    choices.remove("Cat Pose");
                    images.remove(catImg);
                }
            }
        });

        bridgePose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(bridgePose.isChecked()) {
                    choices.add("Bridge Pose");
                    images.add(bridgeImg);
                }
                else{
                    choices.remove("Bridge Pose");
                    images.remove(bridgeImg);
                }
            }
        });

        boatPose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(boatPose.isChecked()) {
                    choices.add("Boat Pose");
                    images.add(boatImg);
                }
                else {
                    choices.remove("Boat Pose");
                    images.remove(boatImg);
                }
            }
        });

        camelPose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(camelPose.isChecked()) {
                    choices.add("Camel Pose");
                    images.add(camelImg);
                }
                else {
                    choices.remove("Camel Pose");
                    images.remove(camelImg);
                }
            }
        });

        lordPose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(lordPose.isChecked()) {
                    choices.add("Lord of the Dance Pose");
                    images.add(lordImg);
                }
                else {
                    choices.remove("Lord of the Dance Pose");
                    images.remove(lordImg);
                }
            }
        });

        pigeonPose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(pigeonPose.isChecked()) {
                    choices.add("King Pigeon Pose");
                    images.add(pigeonImg);
                }
                else {
                    choices.remove("King Pigeon Pose");
                    images.remove(pigeonImg);
                }
            }
        });

        next = findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(Yoga.this, yogaSeries.class);
                intent.putExtra("Selected", choices);
                intent.putExtra("ImgIDs", images);
                intent.putExtra("TimeInSec", timeInSeconds);
                startActivity(intent);
            }
        });
    }

}

