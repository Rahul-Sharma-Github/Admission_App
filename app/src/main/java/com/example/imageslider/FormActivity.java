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

                //'Yes' Button Logic
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent in=new Intent(FormActivity.this,SubmittedActivity.class);
                        startActivity(in);
                        finish();
                    }
                });

                //'No' Button Logic
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                //Now Creating the Dialog Box and setting it's Title manually
                AlertDialog alert=builder.create();
                alert.setTitle("Submit Form");
                alert.show();


            }
        });



    }
}