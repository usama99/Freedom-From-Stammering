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

public class PinterestDetails extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView detailViewPinterest;
    WebView detailSiteViewPinterest;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinterest_details);
        detailViewPinterest = findViewById(R.id.backfromsitepinterest);
        detailViewPinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        detailSiteViewPinterest = findViewById(R.id.webviewPintestDetails);
        String linkPinterest = getIntent().getStringExtra("pinterest");
        detailSiteViewPinterest.setWebViewClient(new WebViewClient());
        detailSiteViewPinterest.getSettings().setJavaScriptEnabled(true);
        detailSiteViewPinterest.loadUrl(linkPinterest);
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
