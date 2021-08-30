package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourSevenEight extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private TextView textView1;

    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    private int[] times = {4000,7000,8000};
    private String[] words = {"BREATHE IN","HOLD YOUR BREATH","BREATHE OUT"};
    private long timeLeft = 4000;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_seven_eight);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        textView1 = findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
    }

    public void startStop(){
        if(timerRunning){
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    public void startTimer(){
        textView1.setText(words[index]);
        countDownTimer = new CountDownTimer(times[index],1) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                index = (index+1)%3;
                startTimer();
            }
        }.start();

        button.setText("Restart");
        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        button.setText("Start");
        textView1.setText("Click Start to Start");
        index = 0;
        textView.setText("4.0");
        timerRunning = false;
    }

    public void updateTimer(){
        int seconds = (int)timeLeft/1000;
        int rem = (int)timeLeft%1000/100;

        String timeText = seconds + "." + rem;

//        if(rem < 100)
//            timeText += "0";
//        if(rem < 10)
//            timeText += "0";
//        timeText += rem;

        textView.setText(timeText);
    }
}
