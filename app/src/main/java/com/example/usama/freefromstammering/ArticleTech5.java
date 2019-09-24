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

public class ArticleTech5 extends AppCompatActivity {

    ProgressDialog progressDialogTech5;
    ImageView fromSiteTech5;
    WebView webViewsTech5;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_article_tech5);
        fromSiteTech5 = findViewById(R.id.backtech5);
        webViewsTech5 = findViewById(R.id.webviewtech5);

        fromSiteTech5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlTech5 = getIntent().getStringExtra("tech5");
        webViewsTech5.setWebViewClient(new WebViewClient());
        webViewsTech5.getSettings().setJavaScriptEnabled(true);
        webViewsTech5.loadUrl(urlTech5);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech5 = ProgressDialog.show(this, "Please wait", "Processing...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech5.dismiss();
            }
        }.start();
    }

}
