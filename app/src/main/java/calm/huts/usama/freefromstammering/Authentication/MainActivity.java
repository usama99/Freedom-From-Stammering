package calm.huts.usama.freefromstammering.Authentication;

import android.content.Intent;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signup, alreadyacount, guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guest = findViewById(R.id.guest);
        signup = findViewById(R.id.signUp);
        alreadyacount = findViewById(R.id.alreayAccount);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, calm.huts.usama.freefromstammering.Authentication.signup.class);
                startActivity(intent);
            }
        });

        alreadyacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
