package android.huts.usama.freefromstammering.MainMenue.SevenTechniques.McGuire;

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

public class ArticleTech4 extends AppCompatActivity {

    ProgressDialog progressDialogTech4;
    ImageView fromSiteTech4;
    WebView webViewsTech4;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_tech4);
        fromSiteTech4 = findViewById(R.id.backtotech4);
        webViewsTech4 = findViewById(R.id.webviewtech4);

        fromSiteTech4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlTech4 = getIntent().getStringExtra("tech4");
        webViewsTech4.setWebViewClient(new WebViewClient());
        webViewsTech4.getSettings().setJavaScriptEnabled(true);
        webViewsTech4.loadUrl(urlTech4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech4 = ProgressDialog.show(this, "Please wait", "Opening...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech4.dismiss();
            }
        }.start();
    }

}
