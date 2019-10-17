package android.huts.usama.freefromstammering.MainMenue.SevenTechniques.TMSs;

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

public class ArtcileTech2 extends AppCompatActivity {

    ProgressDialog progressDialogTech2;
    ImageView fromSiteTech2;
    WebView webViewsTech2;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artcile_tech2);
        fromSiteTech2 = findViewById(R.id.backtech2);
        webViewsTech2 = findViewById(R.id.webviewtech2);

        fromSiteTech2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlTech2 = getIntent().getStringExtra("tech2");
        webViewsTech2.setWebViewClient(new WebViewClient());
        webViewsTech2.getSettings().setJavaScriptEnabled(true);
        webViewsTech2.loadUrl(urlTech2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialogTech2 = ProgressDialog.show(this, "Please wait", "Opening...", true);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialogTech2.dismiss();
            }
        }.start();
    }


}
