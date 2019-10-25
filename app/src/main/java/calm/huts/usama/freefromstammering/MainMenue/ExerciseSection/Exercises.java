package calm.huts.usama.freefromstammering.MainMenue.ExerciseSection;

import android.content.Intent;
import calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.ArticlesSection.Articles;
import calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.Readings.ReadingStories;
import calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.SpeechFlows.SpeechFlow;
import calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.SpeechTrainingSection.SpeechTraining;
import calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.VowelsAndConsonents.VowelsConsonants;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Exercises extends AppCompatActivity {

    LinearLayout toArticle, speechTraing, toReading, speech, vowelConsonants;
    ImageView backToexercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        //google ads
        AdView adViewMain;
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adViewMain = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adViewMain.loadAd(adRequest);

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
