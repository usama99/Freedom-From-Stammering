package android.huts.usama.freefromstammering.MainMenue.SevenTechniques.Integrative;

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

public class ArticleTech7 extends AppCompatActivity {

    ProgressDialog progressDialogTech7;
    ImageView fromSiteTech7;
    WebView webViewsTech7;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_tech7);
        fromSiteTech7 = findViewById(R.id.backtech7);
        webViewsTech7 = findViewById(R.id.webviewtech7);

        fromSiteTech7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlTech7 = getIntent().getStringExtra("tech7");
        webViewsTech7.setWebViewClient(new WebViewClient());
        webViewsTech7.getSettings().setJavaScriptEnabled(true);
        webViewsTech7.loadUrl(urlTech7);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech7 = ProgressDialog.show(this, "Please wait", "Opening...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech7.dismiss();
            }
        }.start();
    }


}
