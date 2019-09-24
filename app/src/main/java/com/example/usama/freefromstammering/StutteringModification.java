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

public class StutteringModification extends AppCompatActivity {

    ImageView backTech6;
    LinearLayout articleTech6, videoTech6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_stuttering_modification);
        backTech6 = findViewById(R.id.backtotech6);
        articleTech6 = findViewById(R.id.articletech6);
        videoTech6 = findViewById(R.id.videotech6);

        backTech6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        articleTech6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech6 = new Intent(StutteringModification.this, ArticleTech6.class);
                intentArtTech6.putExtra("tech6", "https://www.learning-loft.com/blogs/learning-loft-blog/" +
                        "how-to-stop-stuttering-with-stuttering-modification-therapy");
                startActivity(intentArtTech6);
            }
        });

        videoTech6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech6 = new Intent(Intent.ACTION_VIEW);
                playIntentTech6.setData(Uri.parse("https://www.youtube.com/watch?v=upjKbN2RsJM"));
                playIntentTech6.putExtra("force_fullscreen", true);
                startActivity(playIntentTech6);
            }
        });
    }
}
