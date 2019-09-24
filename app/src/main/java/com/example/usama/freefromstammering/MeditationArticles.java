package com.example.usama.freefromstammering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MeditationArticles extends AppCompatActivity {

    ImageView backMedArticle;
    private List<CommunityItems> medItems = new ArrayList<>();
    private RecyclerView recyclerViewMeditation;
    MeditationAdapter meditationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_meditation_articles);
        backMedArticle = findViewById(R.id.backtomedarticle);
        meditationAdapter = new MeditationAdapter(medItems);
        recyclerViewMeditation = findViewById(R.id.recycler_view_meditation);
        RecyclerView.LayoutManager layoutManagerMeditation = new LinearLayoutManager(getApplicationContext());
        recyclerViewMeditation.setLayoutManager(layoutManagerMeditation);
        recyclerViewMeditation.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMeditation.setAdapter(meditationAdapter);
        backMedArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //item listerner
        recyclerViewMeditation.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerViewMeditation,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        CommunityItems medvalues = medItems.get(position);
                        view.getContext();
                        Intent intent = new Intent(view.getContext(), MeditationArctileLinks.class);
                        intent.putExtra("descriptionMeditation",medvalues.getIcon());
                        startActivity(intent);

//                    Toast.makeText(getApplicationContext(), medvalues.getIcon() + " is selected!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
        ItemDataMeditation();
    }

    private void ItemDataMeditation() {

        CommunityItems itemsMed = new CommunityItems("Meditation 101       ", "" +
                "https://fitnessgoat.com/meditation-101/?msID=e23499fd-9a2a-4e7f-8b6c-c9ea3728c630");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("American Stutter As. ", "" +
                "https://stutteringtreatment.org/meditation-resources/");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Mindful meditation   ","" +
                "https://www.mindful.org/speaking-without-stammering/");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("BSA Hypnosis         ","" +
                "https://www.stammering.org/speaking-out/speaking-out-tags/hypnosis");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Uncommon Knowledge   ","" +
                "https://www.hypnosisdownloads.com/clinical-hypnotherapy/stuttering");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Hypnosis Trainee     ","" +
                "https://hypnosistrainingacademy.com/hypnosis-for-stuttering-treatment/");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Approach to Hypnosis ","" +
                "https://britishhypnosisresearch.com/hypnosis-and-stuttering/");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Hyptherapy Directory ", "" +
                "https://www.hypnotherapy-directory.org.uk/articles/stuttering.html");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Medical News Today   ", "" +
                "https://www.medicalnewstoday.com/articles/321995.php");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("How I recover.John.C ", "" +
                "http://www.masteringstuttering.com/recovery-stuttering.htm");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("Mindful Stuttering   ", "" +
                "https://mindfulstuttering.wordpress.com/");
        medItems.add(itemsMed);

        itemsMed = new CommunityItems("WiHow How to meditate", "" +
                "https://www.wikihow.com/Meditate");
        medItems.add(itemsMed);

    }
}
