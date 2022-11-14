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

public class Prospectus extends AppCompatActivity {

    //Declaring Handler type handler
    public Handler handler;

    //declaration
    ImageButton BackButtonP;

    ProgressBar pBarPros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospectus);

        //binding
        pBarPros=findViewById(R.id.pBarProspectus);

        pBarPros.setVisibility(View.VISIBLE);

        //making an instance of Handler Class
        handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pBarPros.setVisibility(View.GONE);

                //Loading the PDF
                String url=getIntent().getStringExtra("pdf_url");
                WebView webViewProspectus=findViewById(R.id.webViewProspectus);
                webViewProspectus.setWebViewClient(new WebViewClient());
                webViewProspectus.getSettings().setSupportZoom(true);
                webViewProspectus.getSettings().setJavaScriptEnabled(true);
                webViewProspectus.loadUrl(url);

            }
        },1000);



        BackButtonP=findViewById(R.id.formBackButtonP);

        BackButtonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Prospectus.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });


    }
}