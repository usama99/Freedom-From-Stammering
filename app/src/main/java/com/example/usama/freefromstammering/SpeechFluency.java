package com.example.usama.freefromstammering;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;

public class SpeechFluency extends AppCompatActivity {

    ImageView backTech5;
    LinearLayout articleTech5, videoTech5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_speech_fluency);
        backTech5 = findViewById(R.id.backtotech5);
        articleTech5 = findViewById(R.id.articletech5);
        videoTech5 = findViewById(R.id.videotech5);

        backTech5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        articleTech5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech5 = new Intent(SpeechFluency.this, ArticleTech5.class);
                intentArtTech5.putExtra("tech5", "https://www.sltinfo.com/fluency-shaping/");
                startActivity(intentArtTech5);
            }
        });

        videoTech5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech5 = new Intent(Intent.ACTION_VIEW);
                playIntentTech5.setData(Uri.parse("https://www.youtube.com/watch?v=DVDzNim079A"));
                playIntentTech5.putExtra("force_fullscreen", true);
                startActivity(playIntentTech5);
            }
        });
    }
}
