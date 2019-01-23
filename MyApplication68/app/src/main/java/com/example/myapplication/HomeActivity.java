package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout politics;
    private LinearLayout sports;
    private LinearLayout guess;
    private LinearLayout action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        politics = findViewById(R.id.politics);
        sports = findViewById(R.id.sports);
        guess = findViewById(R.id.guess);
        action = findViewById(R.id.action);

        politics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(HomeActivity.this, ConfirmActivity.class);
                homeIntent.putExtra("welcome","politics");
                startActivity(homeIntent);
                finish();
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(HomeActivity.this, ConfirmActivity.class);
                homeIntent.putExtra("welcome","sports");
                startActivity(homeIntent);
                finish();
            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(HomeActivity.this, ConfirmActivity.class);
                homeIntent.putExtra("welcome","guess");
                startActivity(homeIntent);
                finish();
            }
        });

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(HomeActivity.this, ConfirmActivity.class);
                homeIntent.putExtra("welcome","action");
                startActivity(homeIntent);
                finish();
            }
        });


    }
}
