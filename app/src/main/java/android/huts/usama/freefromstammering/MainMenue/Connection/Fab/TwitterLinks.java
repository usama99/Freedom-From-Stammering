package android.huts.usama.freefromstammering.MainMenue.Connection.Fab;

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

public class TwitterLinks extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView fromSiteTwitter;
    WebView webViewsTwitter;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_links);

        fromSiteTwitter = findViewById(R.id.backtotwittergroup);
        webViewsTwitter = findViewById(R.id.webviewtwitter);
        fromSiteTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlTwitter = getIntent().getStringExtra("Twiterlinks");
        webViewsTwitter.setWebViewClient(new WebViewClient());
        webViewsTwitter.getSettings().setJavaScriptEnabled(true);
        webViewsTwitter.loadUrl(urlTwitter);
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
