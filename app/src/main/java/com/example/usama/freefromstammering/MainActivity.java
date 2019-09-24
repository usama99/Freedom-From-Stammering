package com.example.usama.freefromstammering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signup, alreadyacount, guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        guest = findViewById(R.id.guest);
        signup = findViewById(R.id.signUp);
        alreadyacount = findViewById(R.id.alreayAccount);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadeout);
//                signup.startAnimation(animation);
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });

        alreadyacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink_anim);
//                alreadyacount.startAnimation(animation);
                Intent intent = new Intent(MainActivity.this, logedin.class);
                startActivity(intent);
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGuest = new Intent(MainActivity.this, SpeechTrainingGuest.class);
                startActivity(intentGuest);
            }
        });

    }
}
