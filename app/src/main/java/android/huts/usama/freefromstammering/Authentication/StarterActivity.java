package android.huts.usama.freefromstammering.Authentication;

import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class StarterActivity extends AppCompatActivity {

    private static int TIME_OUT = 1000;
    ImageView starter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

//        final View mylayout = findViewById(R.id.mainStarter);
        starter = findViewById(R.id.starterImage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StarterActivity.this, MainActivity.class);
                startActivity(intent);
//                overridePendingTransition(R.anim.translate, R.anim.alpha);
                finish();
            }
        }, TIME_OUT);
    }
}
