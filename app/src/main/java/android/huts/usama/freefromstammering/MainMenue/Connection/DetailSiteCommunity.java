package android.huts.usama.freefromstammering.MainMenue.Connection;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class DetailSiteCommunity extends AppCompatActivity {

    ProgressDialog  progressDialog;
    ImageView fromSiteCommunity;
    WebView webViewsCommunity;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_site_community);
        fromSiteCommunity = findViewById(R.id.backfromsitecommunity);
        webViewsCommunity = findViewById(R.id.webviewcommunity);

        fromSiteCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String urlCommunity = getIntent().getStringExtra("descriptionCommunity");
        webViewsCommunity.setWebViewClient(new WebViewClient());
        webViewsCommunity.getSettings().setJavaScriptEnabled(true);
        webViewsCommunity.loadUrl(urlCommunity);
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
