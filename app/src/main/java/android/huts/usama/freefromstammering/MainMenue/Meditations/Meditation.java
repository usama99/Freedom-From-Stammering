package android.huts.usama.freefromstammering.MainMenue.Meditations;

import android.content.DialogInterface;
import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Meditation extends AppCompatActivity {

    ImageView backMeditaion, infoStutter;
    LinearLayout article, videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        backMeditaion = findViewById(R.id.backtomeditation);
        article = findViewById(R.id.articlemeditation);
        videos = findViewById(R.id.videomeditation);
        infoStutter = findViewById(R.id.infostutter);
        backMeditaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        infoStutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Meditation.this);
                builder.setIcon(R.drawable.ic_info_outline_black_24dp);
                builder.setTitle("Quick Notes")
                        .setMessage("This meditation exercise is an excellent introduction to meditation techniques.\n" +
                                "1- Sit or lie comfortably. You may even want to invest in a meditation chair or cushion.\n" +
                                "2- Close your eyes. We recommend using one of our Cooling Eye Masks or Restorative Eye Pillows if lying down.\n" +
                                "3- Make no effort to control the breath; simply breathe naturally.\n" +
                                "4- Focus your attention on the breath and on how the body " +
                                "moves with each inhalation and exhalation. Notice the movement of your body as you breathe." +
                                "Observe your chest, shoulders, rib cage, and belly. Simply focus your attention on your breath" +
                                "without controlling its pace or intensity. If your mind wanders, return your focus back to your breath.\n" +
                                "Maintain this meditation practice for two to three minutes to start, and then try it for longer periods. ")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMeditationArticle = new Intent(Meditation.this, MeditationArticles.class);
                startActivity(intentMeditationArticle);
            }
        });
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoIntent = new Intent(Meditation.this, YouTubeVideos.class);
                startActivity(videoIntent);
            }
        });
    }
}
