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

public class McGuireProgram extends AppCompatActivity {

    ImageView backTech3;
    LinearLayout articleTech3, videoTech3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_mc_guire_program);
        backTech3 = findViewById(R.id.backtotech3);
        articleTech3 = findViewById(R.id.articletech3);
        videoTech3 = findViewById(R.id.videotech3);

        backTech3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        articleTech3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech3 = new Intent(McGuireProgram.this, ArticleTech3.class);
                intentArtTech3.putExtra("tech3", "https://www.mcguireprogramme.com/en/how-it-works");
                startActivity(intentArtTech3);
            }
        });

        videoTech3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech3 = new Intent(Intent.ACTION_VIEW);
                playIntentTech3.setData(Uri.parse("https://www.youtube.com/watch?v=pFmu27GM9-k&list=PLo8L7S3J29iO-mVZaO-r9LfeCou4fh7RO"));
                playIntentTech3.putExtra("force_fullscreen", true);
                startActivity(playIntentTech3);
            }
        });
    }
}
