package calm.huts.usama.freefromstammering.MainMenue.Setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import calm.huts.usama.freefromstammering.R;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    ImageView backSet;
    LinearLayout fb, tw, in, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        backSet = findViewById(R.id.backset);
        backSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fb = findViewById(R.id.joincommunityfb);
        tw = findViewById(R.id.joincommunitytw);
        in = findViewById(R.id.joincommunityins);
        mail = findViewById(R.id.joincommunitymail);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/groups/stutteringtoconfidence/"));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(AboutUs.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/FStuttering"));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(AboutUs.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View view) {
                try{
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:usamaijaz404@gmail.com"));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problem Occur!");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
                catch (Exception e){
                    Toast.makeText(AboutUs.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/stammuri/"));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(AboutUs.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
