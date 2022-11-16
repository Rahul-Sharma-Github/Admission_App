package com.example.mdsu_admission_app;

import static com.example.imageslider.R.id;
import static com.example.imageslider.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class CourseEligibility extends AppCompatActivity {

    ImageButton backBtnC;
    ProgressBar pBarC;

    public Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_course_eligibility);

        //Binding
        pBarC=findViewById(id.pBarCourse);

        pBarC.setVisibility(View.VISIBLE);

        //making an instance of Handler Class
        handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pBarC.setVisibility(View.GONE);

                //Loading the PDF
                String url=getIntent().getStringExtra("pdf_url");
                WebView webViewCourseEligibility=findViewById(id.webViewProspectus);
                webViewCourseEligibility.setWebViewClient(new WebViewClient());
                webViewCourseEligibility.getSettings().setSupportZoom(true);
                webViewCourseEligibility.getSettings().setJavaScriptEnabled(true);
                webViewCourseEligibility.loadUrl(url);
            }
        },1000);

        backBtnC=findViewById(id.formBackButtonCe);

        //back button Event
        backBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CourseEligibility.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        });



    }
}