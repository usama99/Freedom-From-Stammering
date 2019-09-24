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

public class ArticleTech6 extends AppCompatActivity {

    ProgressDialog progressDialogTech6;
    ImageView fromSiteTech6;
    WebView webViewsTech6;

    @SuppressLint("SetJavaScriptEnabled")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_article_tech6);
        fromSiteTech6 = findViewById(R.id.backtech6);
        webViewsTech6 = findViewById(R.id.webviewtech6);

        fromSiteTech6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlTech6 = getIntent().getStringExtra("tech6");
        webViewsTech6.setWebViewClient(new WebViewClient());
        webViewsTech6.getSettings().setJavaScriptEnabled(true);
        webViewsTech6.loadUrl(urlTech6);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech6 = ProgressDialog.show(this, "Please wait", "Processing...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech6.dismiss();
            }
        }.start();
    }

}
