package android.huts.usama.freefromstammering.MainMenue.SevenTechniques.Costal;

import android.content.Intent;
import android.huts.usama.freefromstammering.MainMenue.SevenTechniques.Valsalva.ArtcileTech1;
import android.huts.usama.freefromstammering.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CostalBreathing extends AppCompatActivity {

    ImageView backTech4;
    LinearLayout articleTech4, videoTech4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costal_breathing);
        backTech4 = findViewById(R.id.backtotech4);
        articleTech4 = findViewById(R.id.articletech4);
        videoTech4 = findViewById(R.id.videotech4);

        backTech4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        articleTech4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtTech4 = new Intent(CostalBreathing.this, ArtcileTech1.class);
                intentArtTech4.putExtra("tech1", "https://www.mnsu.edu/comdis/isad15/papers/quesal15.html");
                startActivity(intentArtTech4);
            }
        });

        videoTech4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntentTech4 = new Intent(Intent.ACTION_VIEW);
                playIntentTech4.setData(Uri.parse("https://www.youtube.com/watch?v=zz0oE7yfBw8"));
                playIntentTech4.putExtra("force_fullscreen", true);
                startActivity(playIntentTech4);
            }
        });
    }
}
