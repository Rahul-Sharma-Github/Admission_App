package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Prospectus extends AppCompatActivity {

    ImageButton BackButtonP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospectus);

        //binding
        BackButtonP=findViewById(R.id.formBackButtonP);

        BackButtonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Prospectus.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });


        String url=getIntent().getStringExtra("pdf_url");
        WebView webViewProspectus=findViewById(R.id.webViewProspectus);
        webViewProspectus.setWebViewClient(new WebViewClient());
        webViewProspectus.getSettings().setSupportZoom(true);
        webViewProspectus.getSettings().setJavaScriptEnabled(true);
        webViewProspectus.loadUrl(url);

    }
}