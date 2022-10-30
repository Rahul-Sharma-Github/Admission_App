package com.example.imageslider;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class CourseEligibility extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_eligibility);
        String url=getIntent().getStringExtra("pdf_url");
        WebView webViewCourseEligibility=findViewById(R.id.webViewProspectus);
        webViewCourseEligibility.setWebViewClient(new WebViewClient());
        webViewCourseEligibility.getSettings().setSupportZoom(true);
        webViewCourseEligibility.getSettings().setJavaScriptEnabled(true);
        webViewCourseEligibility.loadUrl(url);

    }
}