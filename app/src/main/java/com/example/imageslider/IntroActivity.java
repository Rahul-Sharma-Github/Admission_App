package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    //Declaring Handler type handler
    public Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //making an instance of Handler Class
        handler=new Handler();
        //Adding postDelayed() method to wait for a specific time
        handler.postDelayed(new Runnable() {
            @Override
            //after a specific time it Navigate to the MainActivity Page (Home Page)
            public void run() {
                Intent i=new Intent(IntroActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000); // 3 Seconds Delay

    }
}