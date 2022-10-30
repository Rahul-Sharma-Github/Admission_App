package com.example.imageslider;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class AdmissionNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_notification);
        String url=getIntent().getStringExtra("pdf_url");
        WebView webViewAdmissionNotification=findViewById(R.id.webViewProspectus);
        webViewAdmissionNotification.setWebViewClient(new WebViewClient());
        webViewAdmissionNotification.getSettings().setSupportZoom(true);
        webViewAdmissionNotification.getSettings().setJavaScriptEnabled(true);
        webViewAdmissionNotification.loadUrl(url);

    }
}