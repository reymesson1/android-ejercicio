package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WaitingActivity extends AppCompatActivity {

    private TextView countdownText;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 6000; //10min
    private boolean timeRunning;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        countdownText = findViewById(R.id.countdown_text);

        data = getIntent().getStringExtra("welcome");




        startStop();




    }

    private void startStop() {


        if(timeRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timeRunning = true;
    }

    private void stopTimer() {

        countDownTimer.cancel();
        timeRunning=false;
    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds<10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);

        if(timeLeftText.equals("0:01")){

            Intent homeIntent = new Intent(WaitingActivity.this, StartActivity.class);
            homeIntent.putExtra("welcome",data);
            startActivity(homeIntent);
            finish();

        }
    }
}
