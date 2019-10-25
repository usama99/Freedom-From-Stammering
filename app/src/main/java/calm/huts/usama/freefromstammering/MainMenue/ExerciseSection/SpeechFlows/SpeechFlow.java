package calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.SpeechFlows;

import android.content.Intent;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SpeechFlow extends AppCompatActivity {

    ImageView backFlow;
    TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_flow);
        details = findViewById(R.id.detailsOfFlow);
        backFlow = findViewById(R.id.backtoflow);
        //google ads
        AdView adViewflow;
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adViewflow = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adViewflow.loadAd(adRequest);

        backFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(SpeechFlow.this, DetailsFlowSpeech.class);
                detailIntent.putExtra("detailSite", "" +
                        "http://copingwithstuttering.blogspot.com/2010/02/how-speech-sounds-are-formed.html");
                startActivity(detailIntent);
            }
        });
    }
}
