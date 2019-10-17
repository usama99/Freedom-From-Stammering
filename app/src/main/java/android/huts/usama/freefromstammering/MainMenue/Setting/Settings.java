package android.huts.usama.freefromstammering.MainMenue.Setting;

import android.content.Intent;
import android.huts.usama.freefromstammering.Authentication.logedin;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class Settings extends AppCompatActivity {
//    Mainmenu rotate;
    ImageView back;
//    FirebaseAuth firebaseAuth;
    LinearLayout help, rate, share, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
//        firebaseAuth = FirebaseAuth.getInstance();
        help = findViewById(R.id.help);
        back = findViewById(R.id.backmain);
        rate = findViewById(R.id.rateapp);
        share = findViewById(R.id.shareapp);
        about = findViewById(R.id.aboutus);
        logout = findViewById(R.id.logoutfromapp);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHelp = new Intent(Settings.this, Help.class);
                startActivity(intentHelp);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at:");
                intentShare.setType("text/plain");
                startActivity(intentShare);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutit = new Intent(Settings.this, AboutUs.class);
                startActivity(aboutit);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance().signOut(Settings.this).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Settings.this, "Logout", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Settings.this, logedin.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//makesure user cant go back
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Settings.this, "Failed to logout", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}
