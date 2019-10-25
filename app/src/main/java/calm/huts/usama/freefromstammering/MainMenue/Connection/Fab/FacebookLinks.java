package calm.huts.usama.freefromstammering.MainMenue.Connection.Fab;

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

public class FacebookLinks extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView facebookOpen;
    WebView faceBookWeb;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_links);
        facebookOpen = findViewById(R.id.backfacebooklink);
        faceBookWeb = findViewById(R.id.webviewopenfacebooklinks);

        facebookOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String urlfacebook = getIntent().getStringExtra("facebooklinks");
        faceBookWeb.setWebViewClient(new WebViewClient());
        faceBookWeb.getSettings().setJavaScriptEnabled(true);
        faceBookWeb.loadUrl(urlfacebook);

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
