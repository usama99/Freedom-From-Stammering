package calm.huts.usama.freefromstammering.Authentication;

import android.content.Intent;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

public class StarterActivity extends AppCompatActivity {

    private static int TIME_OUT = 1000;
    ImageView starter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        starter = findViewById(R.id.starterImage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StarterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_OUT);
    }
}
