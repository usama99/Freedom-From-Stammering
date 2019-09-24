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

public class ArticleTech3 extends AppCompatActivity {

    ProgressDialog progressDialogTech3;
    ImageView fromSiteTech3;
    WebView webViewsTech3;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_article_tech3);
        fromSiteTech3 = findViewById(R.id.backtech3);
        webViewsTech3 = findViewById(R.id.webviewtech3);

        fromSiteTech3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String urlTech3 = getIntent().getStringExtra("tech3");
        webViewsTech3.setWebViewClient(new WebViewClient());
        webViewsTech3.getSettings().setJavaScriptEnabled(true);
        webViewsTech3.loadUrl(urlTech3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech3 = ProgressDialog.show(this, "Please wait", "Processing...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech3.dismiss();
            }
        }.start();
    }

}
