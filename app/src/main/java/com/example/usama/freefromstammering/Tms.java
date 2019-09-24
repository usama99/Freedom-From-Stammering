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

public class Tms extends AppCompatActivity {

    ImageView backTech2;
    LinearLayout articleTech2, videoTech2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_tms);
        backTech2 = findViewById(R.id.backtotechnique2);
        articleTech2 = findViewById(R.id.articletech2);
        videoTech2 = findViewById(R.id.videotech2);

        backTech2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        articleTech2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech2 = new Intent(Tms.this, ArtcileTech2.class);
                intentArtTech2.putExtra("tech2", "http://stuttersense.blogspot.com/2016/07/is-stuttering-manifestation-of-tms.html");
                startActivity(intentArtTech2);
            }
        });

        videoTech2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech2 = new Intent(Intent.ACTION_VIEW);
                playIntentTech2.setData(Uri.parse("https://www.youtube.com/watch?v=fLRA4qPB06U"));
                playIntentTech2.putExtra("force_fullscreen", true);
                startActivity(playIntentTech2);
            }
        });
    }
}
