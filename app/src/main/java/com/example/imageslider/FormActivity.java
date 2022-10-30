package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Binding the Submit Form Button
        btnSubmit=(Button) findViewById(R.id.btnSubmitForm);

        //Navigating page to SubmittedActivity Page
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(FormActivity.this,SubmittedActivity.class);
                startActivity(in);
            }
        });



    }
}