package calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.FluencyShaping;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class ArticleTech5 extends AppCompatActivity {

    ProgressDialog progressDialogTech5;
    ImageView fromSiteTech5;
    WebView webViewsTech5;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        progressDialogTech5 = ProgressDialog.show(this, "Please wait", "Opening...", true);
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
