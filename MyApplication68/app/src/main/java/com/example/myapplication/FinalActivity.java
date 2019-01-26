package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView data;
    private TextView data2;
    private TextView countCorrect;
    private TextView countInCorrect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        data = findViewById(R.id.textView13);
        data2 = findViewById(R.id.textView15);

        countCorrect = findViewById(R.id.textView17);
        countInCorrect = findViewById(R.id.textView18);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        //data.setText("Your scope");
        countCorrect.setText(extras.getString("correct"));
        countInCorrect.setText(extras.getString("incorrect"));



    }
}
