package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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

    Chip chip1,chip2,chip3;

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
                Intent in=new Intent(MainActivity.this,FormActivity.class);
                startActivity(in);
                finish();
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


        //chip1 click event to open Admission Notification PDF Page
        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),AdmissionNotification.class);
                intent1.putExtra("pdf_url","https://drive.google.com/file/d/11CaBgX6jcqc336eW6KtJRXXp11ss_Qom/view?usp=sharing");
                startActivity(intent1);
                finish();
            }
        });



        //chip2 click event to open Course and Eligibility PDF Page
        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),CourseEligibility.class);
                intent2.putExtra("pdf_url","https://drive.google.com/file/d/14IP1lM2xbUSNWPEb_RRUMYDjJ75fzdoz/view?usp=sharing");
                startActivity(intent2);
                finish();
            }
        });



        //chip3 click event to open Prospectus PDF Page
        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getApplicationContext(),Prospectus.class);
                intent3.putExtra("pdf_url","https://drive.google.com/file/d/12L3m4_Wjzs0qkcImwhbe7eth33Gdoy1R/view?usp=sharing");
                startActivity(intent3);
                finish();
            }
        });



    }
}