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
import java.util.Objects;

public class Techniques extends AppCompatActivity {

    ImageView backToTechniques;
    private List<CommunityItems> techItems = new ArrayList<>();
    private RecyclerView recyclerTechnique;
    TechniquesAdapter techniquesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_techniques);
        backToTechniques = findViewById(R.id.backtotechniques);
        backToTechniques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        techniquesAdapter = new TechniquesAdapter(techItems);
        recyclerTechnique = findViewById(R.id.recycler_view_techniques);
        RecyclerView.LayoutManager layoutManagerTechnique = new LinearLayoutManager(getApplicationContext());
        recyclerTechnique.setLayoutManager(layoutManagerTechnique);
        recyclerTechnique.setItemAnimator(new DefaultItemAnimator());
        recyclerTechnique.setAdapter(techniquesAdapter);

        //item listerner
        recyclerTechnique.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerTechnique,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        CommunityItems communityvalues = techItems.get(position);
                        view.getContext();
                        if (communityvalues.getName().equals("Valsalva maneuver    ")){
                            Intent intentValsalva = new Intent(view.getContext(), ValsalvaManeuver.class);
                            intentValsalva.putExtra("valsalva", 1);
                            startActivity(intentValsalva);
                        }
                        else if (communityvalues.getName().equals("TMS Stuttering       ")){
                            Intent intentTms = new Intent(view.getContext(), Tms.class);
                            intentTms.putExtra("tms", 1);
                            startActivity(intentTms);
                        }
                        else if (communityvalues.getName().equals("Costal Breathing     ")){
                            Intent intentCostal = new Intent(view.getContext(), CostalBreathing.class);
                            intentCostal.putExtra("costal", 1);
                            startActivity(intentCostal);
                        }
                        else if (communityvalues.getName().equals("McGuire Technique    ")){
                            Intent intentMcguire = new Intent(view.getContext(), McGuireProgram.class);
                            intentMcguire.putExtra("costal", 1);
                            startActivity(intentMcguire);
                        }
                        else if (communityvalues.getName().equals("Fluency Shaping Tech.")){
                            Intent intentFS = new Intent(view.getContext(), SpeechFluency.class);
                            intentFS.putExtra("fluency", 1);
                            startActivity(intentFS);
                        }
                        else if (communityvalues.getName().equals("Stutter Modification.")){
                            Intent intentSM = new Intent(view.getContext(), StutteringModification.class);
                            intentSM.putExtra("modification", 1);
                            startActivity(intentSM);
                        }
                        else if (communityvalues.getName().equals("Integrative approach.")){
                            Intent intentIntegrative = new Intent(view.getContext(), IntegrativeApproach.class);
                            intentIntegrative.putExtra("Integrative", 1);
                            startActivity(intentIntegrative);
                        }
                        else{
                            Toast.makeText(Techniques.this, "Invalid Option Selected", Toast.LENGTH_SHORT).show();
                        }
//                        Intent intent = new Intent(view.getContext(), DetailSiteCommunity.class);
//                        intent.putExtra("descriptionCommunity",communityvalues.getIcon());
//                        startActivity(intent);

//                    Toast.makeText(getApplicationContext(), communityvalues.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
        ItemDataTechniques();
    }

    private void ItemDataTechniques() {

        CommunityItems items = new CommunityItems("Valsalva maneuver    ", "");
        techItems.add(items);

        items = new CommunityItems("TMS Stuttering       ", "");
        techItems.add(items);

        items = new CommunityItems("Costal Breathing     ", "");
        techItems.add(items);

        items = new CommunityItems("McGuire Technique    ", "");
        techItems.add(items);

        items = new CommunityItems("Fluency Shaping Tech.", "");
        techItems.add(items);

        items = new CommunityItems("Stutter Modification.", "");
        techItems.add(items);

        items = new CommunityItems("Integrative approach.", "");
        techItems.add(items);

    }
}
