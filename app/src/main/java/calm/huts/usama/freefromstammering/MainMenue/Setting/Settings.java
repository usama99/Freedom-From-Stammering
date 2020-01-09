package calm.huts.usama.freefromstammering.MainMenue.Setting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import calm.huts.usama.freefromstammering.Authentication.logedin;
import calm.huts.usama.freefromstammering.BuildConfig;
import calm.huts.usama.freefromstammering.R;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
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
        help = findViewById(R.id.help);
        back = findViewById(R.id.backmain);
        share = findViewById(R.id.shareapp);
        rate = findViewById(R.id.rateit);
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
                Intent intentInvite = new Intent(Intent.ACTION_SEND);
                intentInvite.setType("text/plain");
                String body = "https://play.google.com/store/apps/details?id=calm.huts.usama.freefromstammering";
                intentInvite.putExtra(Intent.EXTRA_TEXT, "Let me recommend you this app\n" + body);
                startActivity(Intent.createChooser(intentInvite, "Share using"));
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
                }
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
