package android.huts.usama.freefromstammering.MainMenue.ExerciseSection.SpeechFlows;

import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SpeechFlow extends AppCompatActivity {

    ImageView backFlow;
    TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_flow);
        details = findViewById(R.id.detailsOfFlow);
        backFlow = findViewById(R.id.backtoflow);
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
