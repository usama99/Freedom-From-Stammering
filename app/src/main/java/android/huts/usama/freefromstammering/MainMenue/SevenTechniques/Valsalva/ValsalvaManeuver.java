package android.huts.usama.freefromstammering.MainMenue.SevenTechniques.Valsalva;

import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ValsalvaManeuver extends AppCompatActivity {

    ImageView backTech1;
    LinearLayout articleTech1, videoTech1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valsalva_maneuver);
        backTech1 = findViewById(R.id.backtotech1);
        backTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        articleTech1 = findViewById(R.id.articletech1);
        videoTech1 = findViewById(R.id.videotech1);

        articleTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech1 = new Intent(ValsalvaManeuver.this, ArtcileTech1.class);
                intentArtTech1.putExtra("tech1", "http://www.valsalva.org/valsalva.htm");
                startActivity(intentArtTech1);
            }
        });

        videoTech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech1 = new Intent(Intent.ACTION_VIEW);
                playIntentTech1.setData(Uri.parse("https://www.youtube.com/watch?v=QIFPEf71ZJ0"));
                playIntentTech1.putExtra("force_fullscreen", true);
                startActivity(playIntentTech1);
            }
        });

    }
}
