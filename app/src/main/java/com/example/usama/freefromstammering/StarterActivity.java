package com.example.usama.freefromstammering;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StarterActivity extends AppCompatActivity {

    private static int TIME_OUT = 1000;
    ImageView starter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_starter);

//        final View mylayout = findViewById(R.id.mainStarter);
        starter = findViewById(R.id.starterImage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StarterActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate, R.anim.alpha);
                finish();
            }
        }, TIME_OUT);
    }
}
