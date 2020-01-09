package calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.SpeechFlows;

import android.app.ProgressDialog;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class DetailsFlowSpeech extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView detailView;
    WebView detailSiteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_flow_speech);
        detailView = findViewById(R.id.backfromsiteFlow);
        detailSiteView = findViewById(R.id.webviewDetails);
        detailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String linkDetail = getIntent().getStringExtra("detailSite");
        detailSiteView.setWebViewClient(new WebViewClient());
        detailSiteView.loadUrl(linkDetail);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressDialog = ProgressDialog.show(this, "Please wait", "Opening...", true);
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
