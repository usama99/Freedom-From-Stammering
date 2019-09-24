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

public class ArtcileTech1 extends AppCompatActivity {

    ProgressDialog progressDialogTech1;
    ImageView fromSiteTech1;
    WebView webViewsTech1;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_artcile_tech1);
        fromSiteTech1 = findViewById(R.id.backtech1);
        webViewsTech1 = findViewById(R.id.webviewtech1);

        fromSiteTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String urlTech1 = getIntent().getStringExtra("tech1");
        webViewsTech1.setWebViewClient(new WebViewClient());
        webViewsTech1.getSettings().setJavaScriptEnabled(true);
        webViewsTech1.loadUrl(urlTech1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech1 = ProgressDialog.show(this, "Please wait", "Processing...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech1.dismiss();
            }
        }.start();
    }

}
