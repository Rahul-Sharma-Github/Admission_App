package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubmittedActivity extends AppCompatActivity {

    //Declaring Variables for binding
    Button btnGoHone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);

        //Binding
        btnGoHone=(Button) findViewById(R.id.btnGoHome);

        //Navigating to HomePage
        btnGoHone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(SubmittedActivity.this,MainActivity.class);
                startActivity(in);
            }
        });

    }
}