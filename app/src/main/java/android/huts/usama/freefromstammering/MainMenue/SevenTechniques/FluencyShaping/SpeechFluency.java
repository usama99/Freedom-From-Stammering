package android.huts.usama.freefromstammering.MainMenue.SevenTechniques.FluencyShaping;

import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SpeechFluency extends AppCompatActivity {

    ImageView backTech5;
    LinearLayout articleTech5, videoTech5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
