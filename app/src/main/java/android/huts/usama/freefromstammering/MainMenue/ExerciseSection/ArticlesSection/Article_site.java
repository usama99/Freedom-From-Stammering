package android.huts.usama.freefromstammering.MainMenue.ExerciseSection.ArticlesSection;

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

public class Article_site extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView fromSite;
    WebView webViews;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_site);
        webViews = findViewById(R.id.webview);
        fromSite = findViewById(R.id.backfromsite);
        fromSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String url = getIntent().getStringExtra("description");
        webViews.setWebViewClient(new WebViewClient());
        webViews.getSettings().setJavaScriptEnabled(true);
        webViews.loadUrl(url);
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
