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

public class YouTubeVideos extends AppCompatActivity {

    ImageView backYoutubeVideo;
    LinearLayout v1, v2, v3, v4, v5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_you_tube_videos);
        backYoutubeVideo = findViewById(R.id.backtoyoutubevideo);
        v1 = findViewById(R.id.video1);
        v2 = findViewById(R.id.video2);
        v3 = findViewById(R.id.video3);
        v4 = findViewById(R.id.video4);
        v5 = findViewById(R.id.video5);
        backYoutubeVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Intent.ACTION_VIEW);
                playIntent.setData(Uri.parse("https://www.youtube.com/watch?v=nzCaZQqAs9I"));
                playIntent.putExtra("force_fullscreen", true);
                startActivity(playIntent
                );
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Intent.ACTION_VIEW);
                playIntent.setData(Uri.parse("https://www.youtube.com/watch?v=MggxikOZN80"));
                playIntent.putExtra("force_fullscreen", true);
                startActivity(playIntent
                );
            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Intent.ACTION_VIEW);
                playIntent.setData(Uri.parse("https://www.youtube.com/watch?v=9h4GiblYrPk&list=PLW5sxcnCkCYuzTNZRqdxnecvhgX5BCYRI"));
                playIntent.putExtra("force_fullscreen", true);
                startActivity(playIntent
                );
            }
        });

        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Intent.ACTION_VIEW);
                playIntent.setData(Uri.parse("https://www.youtube.com/watch?v=9frKEilvqHc"));
                playIntent.putExtra("force_fullscreen", true);
                startActivity(playIntent
                );
            }
        });

        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Intent.ACTION_VIEW);
                playIntent.setData(Uri.parse("https://www.youtube.com/watch?v=EoIBO2COcXo"));
                playIntent.putExtra("force_fullscreen", true);
                startActivity(playIntent
                );
            }
        });
    }
}
