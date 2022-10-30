package com.example.imageslider;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Prospectus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospectus);
        String url=getIntent().getStringExtra("pdf_url");
        WebView webViewProspectus=findViewById(R.id.webViewProspectus);
        webViewProspectus.setWebViewClient(new WebViewClient());
        webViewProspectus.getSettings().setSupportZoom(true);
        webViewProspectus.getSettings().setJavaScriptEnabled(true);
        webViewProspectus.loadUrl(url);

    }
}