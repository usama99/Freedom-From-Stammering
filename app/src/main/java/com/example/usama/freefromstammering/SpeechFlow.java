package com.example.usama.freefromstammering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Objects;

public class SpeechFlow extends AppCompatActivity {

    ImageView backFlow;
    TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
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
