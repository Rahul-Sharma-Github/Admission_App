package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CourseEligibility extends AppCompatActivity {

    ImageButton backBtnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_eligibility);

        //Binding
        backBtnC=findViewById(R.id.formBackButtonCe);

        backBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CourseEligibility.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        String url=getIntent().getStringExtra("pdf_url");
        WebView webViewCourseEligibility=findViewById(R.id.webViewProspectus);
        webViewCourseEligibility.setWebViewClient(new WebViewClient());
        webViewCourseEligibility.getSettings().setSupportZoom(true);
        webViewCourseEligibility.getSettings().setJavaScriptEnabled(true);
        webViewCourseEligibility.loadUrl(url);

    }
}