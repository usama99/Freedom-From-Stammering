package com.example.usama.freefromstammering;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.util.Objects;

public class ValsalvaManeuver extends AppCompatActivity {

    ImageView backTech1;
    LinearLayout articleTech1, videoTech1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_valsalva_maneuver);
        backTech1 = findViewById(R.id.backtotech1);
        backTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        articleTech1 = findViewById(R.id.articletech1);
        videoTech1 = findViewById(R.id.videotech1);

        articleTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech1 = new Intent(ValsalvaManeuver.this, ArtcileTech1.class);
                intentArtTech1.putExtra("tech1", "http://www.valsalva.org/valsalva.htm");
                startActivity(intentArtTech1);
            }
        });

        videoTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech1 = new Intent(Intent.ACTION_VIEW);
                playIntentTech1.setData(Uri.parse("https://www.youtube.com/watch?v=QIFPEf71ZJ0"));
                playIntentTech1.putExtra("force_fullscreen", true);
                startActivity(playIntentTech1);
            }
        });

    }
}
