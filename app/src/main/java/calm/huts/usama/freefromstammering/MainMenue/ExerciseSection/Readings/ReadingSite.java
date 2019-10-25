package calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.Readings;

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

public class ReadingSite extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView readingSite;
    WebView webViewReading;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_site);
        readingSite = findViewById(R.id.backfromsiteReading);
        webViewReading = findViewById(R.id.webviewRead);
        readingSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urls = getIntent().getStringExtra("links");
        webViewReading.setWebViewClient(new WebViewClient());
        webViewReading.getSettings().setJavaScriptEnabled(true);
        webViewReading.loadUrl(urls);
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
