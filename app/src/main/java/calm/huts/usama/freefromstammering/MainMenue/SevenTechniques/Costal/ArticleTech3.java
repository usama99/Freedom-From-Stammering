package calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.Costal;

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

public class ArticleTech3 extends AppCompatActivity {

    ProgressDialog progressDialogTech3;
    ImageView fromSiteTech3;
    WebView webViewsTech3;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        progressDialogTech3 = ProgressDialog.show(this, "Please wait", "Opening...", true);
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
