package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;


public class StartActivity extends AppCompatActivity implements SensorEventListener{

    private String data;
    private LinearLayout linear;
    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager SM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        linear = findViewById(R.id.linearlayout);

//        linear.setBackgroundColor(Color.RED);

        data = getIntent().getStringExtra("welcome");

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        xText = findViewById(R.id.xText);
        yText = findViewById(R.id.yText);
        zText = findViewById(R.id.zText);



    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if( (event.values[0]>2.8 && event.values[0]<=9) && (event.values[2]>-3 && event.values[2] <4)  ){

            linear.setBackgroundColor(Color.BLUE);
        }else if(event.values[0]>=7 &&event.values[2]<-5){

            linear.setBackgroundColor(Color.GREEN);

        }else if(event.values[0]>=3 && event.values[2]>=7){
            linear.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
