package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class AdmissionNotification extends AppCompatActivity {

    //Declaring Handler type handler
    public Handler handler;

    //variable declaration
    ImageButton formBackButtonAN;

    ProgressBar pBarAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_notification);

        //Binding
        pBarAd=findViewById(R.id.pBarAdmission);

        pBarAd.setVisibility(View.VISIBLE);

        //making an instance of Handler Class
        handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pBarAd.setVisibility(View.GONE);

                //Loading the PDF
                String url=getIntent().getStringExtra("pdf_url");
                WebView webViewAdmissionNotification=findViewById(R.id.webViewProspectus);
                webViewAdmissionNotification.setWebViewClient(new WebViewClient());
                webViewAdmissionNotification.getSettings().setSupportZoom(true);
                webViewAdmissionNotification.getSettings().setJavaScriptEnabled(true);
                webViewAdmissionNotification.loadUrl(url);
            }
        },2000);

        //binding back button
        formBackButtonAN=findViewById(R.id.formBackButtonAN);

        formBackButtonAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AdmissionNotification.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });




    }
}