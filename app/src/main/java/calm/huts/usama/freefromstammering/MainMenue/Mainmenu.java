package calm.huts.usama.freefromstammering.MainMenue;

import android.content.DialogInterface;
import android.content.Intent;
import calm.huts.usama.freefromstammering.MainMenue.Connection.Connections;
import calm.huts.usama.freefromstammering.MainMenue.ExerciseSection.Exercises;
import calm.huts.usama.freefromstammering.MainMenue.Meditations.Meditation;
import calm.huts.usama.freefromstammering.MainMenue.Setting.Settings;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.Techniques;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Mainmenu extends AppCompatActivity {

    LinearLayout diff_exercise, techniques, connection, meditations;
    ImageView setting, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        info = findViewById(R.id.infos);
        diff_exercise = findViewById(R.id.exercise);
        connection = findViewById(R.id.connection);
        setting = findViewById(R.id.settings);
        techniques = findViewById(R.id.techs);
        meditations = findViewById(R.id.meditaion);

        meditations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMeditation = new Intent(Mainmenu.this, Meditation.class);
                startActivity(intentMeditation);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingIntent = new Intent(Mainmenu.this, Settings.class);
                Animation myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.icon_rotate);
                setting.startAnimation(myRotation);
                startActivity(settingIntent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Mainmenu.this);
                builder.setIcon(R.drawable.ic_info_outline_black_24dp);
                builder.setTitle("Daily Remainder")
                        .setMessage("\"1- Stuttering is not a speech problem. It's a problem of the speaking system.\n" +
                                "2- People who stutter are capable of speaking fluently.\n" +
                                "3- Your mindset and the processes you use to speak are linked.\n" +
                                "4- Speaking must be an automatic process.\n" +
                                "5- The brain develops language in the same way when you're speaking\n" +
                                " to yourself silently and speaking aloud to yourself or others.\n" +
                                "6- There is no such thing as getting speech OUT!\n" +
                                "7- The mouth moves automatically to create speech sounds.\n" +
                                "8- Stuttering is harmless condition, mainly caused by repressed emotions.\n" +
                                "9- Stuttering exist only to distract my attention from the emotions.\n" +
                                "10- I will shift my attention from stuttering to emotional issues.\n" +
                                "11- I will be assertive and not hold back.\n" +
                                "12- As a adult I am not vulnerable child a used to be.")
//                        .setView(info)
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
        diff_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExercise = new Intent(Mainmenu.this, Exercises.class);

                startActivity(intentExercise);
            }
        });
        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent connect = new Intent(Mainmenu.this, Connections.class);
                startActivity(connect);
            }
        });

        techniques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTechs = new Intent(Mainmenu.this, Techniques.class);
                startActivity(intentTechs);
            }
        });
    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                }).setNegativeButton("no", null).show();

    }

}
