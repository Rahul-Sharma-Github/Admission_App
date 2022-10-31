package com.example.imageslider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    Button btnSubmit;

    //making instance of AlertDialog.Builder Class
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Showing AlertDialog on current activity
        builder=new AlertDialog.Builder(this);

        //Binding the Submit Form Button
        btnSubmit=(Button) findViewById(R.id.btnSubmitForm);

        //Navigating page to SubmittedActivity Page
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting builder properties
                builder.setMessage("Do you want to Submit this Form ?");
                builder.setCancelable(true);





            }
        });



    }
}