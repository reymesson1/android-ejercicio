package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView data;
    private TextView data2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        data = findViewById(R.id.textView13);
        data2 = findViewById(R.id.textView15);

        //data.setText("Your scope");
        data.setText(getIntent().getStringExtra("welcome"));


    }
}
