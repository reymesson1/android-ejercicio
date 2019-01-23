package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    private TextView selected;
    private ImageButton button;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        selected = findViewById(R.id.selected);
        button = findViewById(R.id.imageButton);
        submit = findViewById(R.id.button);

        final String data = getIntent().getStringExtra("welcome");


        if(data.equals("politics")){
            button.setImageResource(R.drawable.politics2);
            selected.setText("Politics");
        }else if(data.equals("sports")){
            button.setImageResource(R.drawable.running);
            selected.setText("Sports");
        }else if(data.equals("guess")){
            button.setImageResource(R.drawable.guess2);
            selected.setText("Guess");
        }else{
            button.setImageResource(R.drawable.action);
            selected.setText("Actions");
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(ConfirmActivity.this, WaitingActivity.class);
                homeIntent.putExtra("welcome",data);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
