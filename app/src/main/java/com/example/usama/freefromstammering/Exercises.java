package com.example.usama.freefromstammering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Exercises extends AppCompatActivity {

    LinearLayout toArticle, speechTraing, toReading, speech, vowelConsonants;
    ImageView backToexercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_exercises);

        toArticle = findViewById(R.id.art);
        backToexercise = findViewById(R.id.backtomainarea);
        toReading = findViewById(R.id.reading_practice);
        speech = findViewById(R.id.speech_flow);
        vowelConsonants = findViewById(R.id.vowel);
        speechTraing = findViewById(R.id.speech_training);
        vowelConsonants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vowelntent = new Intent(Exercises.this, VowelsConsonants.class);
                startActivity(vowelntent);
            }
        });

        speechTraing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trainingIntent = new Intent(Exercises.this, SpeechTraining.class);
                startActivity(trainingIntent);
            }
        });
        backToexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 onBackPressed();
            }
        });
        toArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toArticle = new Intent(Exercises.this, Articles.class);
                startActivity(toArticle);
            }
        });
        toReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toReadings = new Intent(Exercises.this, ReadingStories.class);
                startActivity(toReadings);
            }
        });
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent speeches = new Intent(Exercises.this, SpeechFlow.class);
                startActivity(speeches);
            }
        });
    }
}
