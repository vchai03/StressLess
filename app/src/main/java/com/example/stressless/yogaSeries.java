package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class yogaSeries extends AppCompatActivity {

    private ArrayList<String> choices;
    private ArrayList<Integer> images;
    private TextView countDownText;
    private Button countDownButton;
    private TextView poseName;
    private ImageView poseImage;
    private CountDownTimer countDownTimer;
    private long startTimeInMillis;
    private long timeLeftInMilliseconds;
    private boolean timerRunning = false;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_series);

        Intent intent = getIntent();
        choices = intent.getStringArrayListExtra("Selected");
        images = intent.getIntegerArrayListExtra("ImgIDs");
        timeLeftInMilliseconds = intent.getIntExtra("TimeInSec", 0) * 1000;
        startTimeInMillis = timeLeftInMilliseconds;


        countDownText = findViewById(R.id.countDownText);
        updateTimer();
        countDownButton = findViewById(R.id.countDownButton);
        poseName = findViewById(R.id.poseName);
        poseImage = findViewById(R.id.poseImage);

        poseName.setText(choices.get(index));
        poseImage.setImageResource(images.get(index));

        countDownButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                startStop();
            }
        });
    }

    public void startStop(){
        if(timerRunning)
            stopTimer();
        else
            startTimer();
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000){

            public void onTick(long l){
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            public void onFinish(){

                if(index < choices.size()){
                    index++;
                    poseName.setText(choices.get(index));
                    poseImage.setImageResource(images.get(index));
                    resetTimer();
                    startTimer();
                }
            }
        }.start();

        countDownButton.setText("Pause");
        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        countDownButton.setText("Start");
        timerRunning = false;
    }

    public void updateTimer(){
        int minutes = (int)timeLeftInMilliseconds / 60000;
        int seconds = (int)timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes + ":";

        if(seconds < 10)
            timeLeftText += "0";

        timeLeftText += seconds;

        countDownText.setText(timeLeftText);
    }

    public void resetTimer(){
        timeLeftInMilliseconds = startTimeInMillis;
        updateTimer();
    }

}
