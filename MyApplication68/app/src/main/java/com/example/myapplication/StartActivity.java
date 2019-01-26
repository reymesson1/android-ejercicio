package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import android.os.CountDownTimer;


public class StartActivity extends AppCompatActivity implements SensorEventListener{

    private String data;
    private LinearLayout linear;
    private TextView xText, yText, zText, iText,jText;
    private TextView countdownText;
    private Sensor mySensor;
    private SensorManager SM;
    private int count = 0;
    private int countCorrect = 0;
    private int countInCorrect = 0;
    private int index = 0;
    private boolean validate = false;
    private String names[] = {"Donald Trump","Nicolas Maduro","Chin Yu Jum","Capitalismo","Comunismo","Democracia","Socialismo","Voto","Urnas","Derecho","Elecciones","Candidato","Orador","Multitud","Campaña","Bandera","Poder","Publico","Debate","Conflicto","Gobierno","Bien social","Sabiduria","Nepotismo","Historia","Cultura","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 60000; //10min
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startStop();


        linear = findViewById(R.id.linearlayout);

//        linear.setBackgroundColor(Color.RED);

        data = getIntent().getStringExtra("welcome");

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        xText = findViewById(R.id.xText);
        yText = findViewById(R.id.yText);
        zText = findViewById(R.id.zText);
        iText = findViewById(R.id.textView11);
        countdownText = findViewById(R.id.textView12);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }

    private void startStop() {

        if(timeRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }

    private void stopTimer() {

        countDownTimer.cancel();
        timeRunning=false;
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

            Intent homeIntent = new Intent(StartActivity.this, FinalActivity.class);
            Bundle extras = new Bundle();
            extras.putString("correct",Integer.toString(countCorrect));
            extras.putString("incorrect",Integer.toString(countInCorrect));
            homeIntent.putExtras(extras);
            startActivity(homeIntent);
            finish();

        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

//        xText.setText("X: " + event.values[0]);
//        yText.setText("Y: " + event.values[1]);
//        zText.setText("Z: " + event.values[2]);

        if( (event.values[0]>2.8 && event.values[0]<=9) && (event.values[2]>-3 && event.values[2] <4)  ){

            linear.setBackgroundColor(Color.BLUE);
            //iText.setText(Integer.toString(count));
            iText.setText(names[index]);
            //iText.setText(Integer.toString(index));

            validate = true;

        }else if(event.values[0]>=7 &&event.values[2]<-5){

            linear.setBackgroundColor(Color.GREEN);
            if(validate) {
                count++;
                index++;
                countCorrect++;
                validate=false;
            }

        }else if(event.values[0]>=3 && event.values[2]>=7){
            linear.setBackgroundColor(Color.RED);
            if(validate) {
                count--;
                index++;
                countInCorrect--;
                validate=false;
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
