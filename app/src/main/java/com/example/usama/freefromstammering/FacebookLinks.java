package com.example.usama.freefromstammering;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import java.util.Objects;

public class FacebookLinks extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView facebookOpen;
    WebView faceBookWeb;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_facebook_links);
        facebookOpen = findViewById(R.id.backfacebooklink);
        faceBookWeb = findViewById(R.id.webviewopenfacebooklinks);

        facebookOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlfacebook = getIntent().getStringExtra("facebooklinks");
        faceBookWeb.setWebViewClient(new WebViewClient());
        faceBookWeb.getSettings().setJavaScriptEnabled(true);
        faceBookWeb.loadUrl(urlfacebook);

    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialog = ProgressDialog.show(this, "Please wait", "Processing...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }
}
