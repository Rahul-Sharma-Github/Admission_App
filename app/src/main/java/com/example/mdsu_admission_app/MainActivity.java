package com.example.mdsu_admission_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imageslider.R;
import com.google.android.material.chip.Chip;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    //Image data for sliderview
    SliderView sliderView;
    int[] images = {R.drawable.one,
    R.drawable.two,
    R.drawable.three,
    R.drawable.four,
    R.drawable.five,
    R.drawable.six,
    R.drawable.seven,
    R.drawable.eight};


    //Declaration of Variables for Binding
    Chip AdmissionChipButton;

    Chip chip1,chip2,chip3,chipPayFeesOnline,chipEditForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding the AdmissionChipButton
        AdmissionChipButton=(Chip)findViewById(R.id.chip_Admission);

        //Adding click event to AdmissionChipButton
        AdmissionChipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent in=new Intent(MainActivity.this,FormActivity.class);
                startActivity(in);
                finish();*/

                //Visiting the Admission Portal Site
                Uri uri=Uri.parse("https://www.mdsuajmer.ac.in/admission/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();


        //binding the MainActivity Page's PDF chip buttons
        chip1=(Chip) findViewById(R.id.chip1);
        chip2=(Chip) findViewById(R.id.chip2);
        chip3=(Chip) findViewById(R.id.chip3);

        //binding chip buttons of online admission portal
        //chipPayFeesOnline=(Chip) findViewById(R.id.chipPayFees);
        chipEditForm=(Chip)findViewById(R.id.chipEditForm);

        //chip1 click event to open Admission Notification PDF Page
        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),AdmissionNotification.class);
                intent1.putExtra("pdf_url","https://drive.google.com/file/d/11CaBgX6jcqc336eW6KtJRXXp11ss_Qom/view?usp=sharing");
                startActivity(intent1);
                //finish();
            }
        });



        //chip2 click event to open Course and Eligibility PDF Page
        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),CourseEligibility.class);
                intent2.putExtra("pdf_url","https://drive.google.com/file/d/14IP1lM2xbUSNWPEb_RRUMYDjJ75fzdoz/view?usp=sharing");
                startActivity(intent2);
                //finish();
            }
        });



        //chip3 click event to open Prospectus PDF Page
        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getApplicationContext(),Prospectus.class);
                intent3.putExtra("pdf_url","https://drive.google.com/file/d/12L3m4_Wjzs0qkcImwhbe7eth33Gdoy1R/view?usp=sharing");
                startActivity(intent3);
                //finish();
            }
        });



        //chipVisitSite click event to open official website of MDSU Admission
        /*chipPayFeesOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.mdsuajmer.ac.in/admission/new/fees_pay.php");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });*/


        //click event to open Edit Form page of MDSU online admission portal
        chipEditForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://mdsuajmer.ac.in/admission/new.php");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
}