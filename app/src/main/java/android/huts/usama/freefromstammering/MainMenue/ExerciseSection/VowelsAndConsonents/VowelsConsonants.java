package android.huts.usama.freefromstammering.MainMenue.ExerciseSection.VowelsAndConsonents;

import android.content.DialogInterface;
import android.huts.usama.freefromstammering.Adapters.SpeechFlowAdapter;
import android.huts.usama.freefromstammering.Classes.RecycleTouchListener;
import android.huts.usama.freefromstammering.Classes.VowelsItems;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VowelsConsonants extends AppCompatActivity {

    ImageView backVowels, infoVowel;
    private List<VowelsItems> vowelsItemsList = new ArrayList<>();
    private RecyclerView recyclerViewVowels;
    private SpeechFlowAdapter speechFlowAdapterVowels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vowels_consonants);
        backVowels = findViewById(R.id.backtovowels);
        backVowels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        recyclerViewVowels = findViewById(R.id.recycler_vowels);
        infoVowel = findViewById(R.id.info);
        speechFlowAdapterVowels = new SpeechFlowAdapter(vowelsItemsList);

        RecyclerView.LayoutManager layoutManagerVowels = new LinearLayoutManager(getApplicationContext());
        recyclerViewVowels.setLayoutManager(layoutManagerVowels);
        recyclerViewVowels.setItemAnimator(new DefaultItemAnimator());
        recyclerViewVowels.setAdapter(speechFlowAdapterVowels);

        infoVowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VowelsConsonants.this);
                builder.setIcon(R.drawable.ic_info_outline_black_24dp);
                builder.setTitle("Method!");
                builder.setMessage("Place one hand on your stomach. Breathe so that your hand moves out when you inhale, and in when you exhale.\n" +
                        "\n" +
                        "Notice that you're taking many small breaths. Your inhalation and exhalation are equal in time duration.\n" +
                        "\n" +
                        "This is called relaxed or diaphragmatic breathing" +
                        "Your vocal folds are flaps of muscle in your throat. Making your vocal folds vibrate produces sound. This sound then becomes your voice. Vocal fold vibration is called phonation.\n" +
                        "\n" +
                        "Two conditions produce phonation. First, you release air from your lungs. Next, you tension or tighten your vocal folds.\n" +
                        "\n" +
                        "Place your fingers on your throat. Exhale and hum. Your fingers should feel a vibration. This is your vocal folds vibrating.\n" +
                        "\n" +
                        "Stop humming, and feel the vibration stop. Practice switching your phonation on and off.\n" +
                        "\n" +
                        "Now vary your phonation in two ways. Change your volume by humming louder, then quieter. Change your pitch by humming up and down a musical scale.\n" +
                        "\n")
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

        recyclerViewVowels.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerViewVowels,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        VowelsItems moreItems = vowelsItemsList.get(position);
//                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), moreItems.getVolumeId());
//                        mediaPlayer.start();
//                        Intent intent = new Intent(view.getContext(), Article_site.class);
//                        intent.putExtra("description",moreItems.getDescriptions());
//                        startActivity(intent);

                Toast.makeText(getApplicationContext(), "'" + moreItems.getTitles() + "'" + " speak to articulate", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
        vowelsItems();
    }

    private void vowelsItems(){

        VowelsItems itemsOfVowels = new VowelsItems(R.drawable.v, "Able", "Category1", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Baby", "Category1", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Chainshaw", "Category1", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Dateline", "Category1", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.v, "Gatepost", "Category1", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Jaywalk", "Category1", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Mailbag", "Category2", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Shapeless", "Category2", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.v, "Weightless", "Category2", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Baboon", "Category2", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Famine", "Category2", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Ladder", "Category2", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Package", "Category3", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Shadow", "Category3", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.v, "Tacktile", "Category3", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Wacky", "Category3", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Macaw", "Category3", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Beachfront", "Category3", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Dealer", "Category4", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Feature", "Category4", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.v, "Healer", "Category4", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Meager", "Category4", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Kneecap", "Category4", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Sheepdog", "Category5", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Weasel", "Category5", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        itemsOfVowels = new VowelsItems(R.drawable.c, "Bedtime", "Category5", R.drawable.speech);
        vowelsItemsList.add(itemsOfVowels);

        speechFlowAdapterVowels.notifyDataSetChanged();
    }
}
