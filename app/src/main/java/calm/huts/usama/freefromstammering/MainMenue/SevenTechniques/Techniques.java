package calm.huts.usama.freefromstammering.MainMenue.SevenTechniques;

import android.content.Intent;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.Integrative.IntegrativeApproach;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.McGuire.McGuireProgram;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import calm.huts.usama.freefromstammering.Adapters.TechniquesAdapter;
import calm.huts.usama.freefromstammering.Classes.CommunityItems;
import calm.huts.usama.freefromstammering.R;
import calm.huts.usama.freefromstammering.Classes.RecycleTouchListener;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.Costal.CostalBreathing;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.FluencyShaping.SpeechFluency;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.SpeechModification.StutteringModification;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.TMSs.Tms;
import calm.huts.usama.freefromstammering.MainMenue.SevenTechniques.Valsalva.ValsalvaManeuver;

import java.util.ArrayList;
import java.util.List;

public class Techniques extends AppCompatActivity {

    ImageView backToTechniques;
    private List<CommunityItems> techItems = new ArrayList<>();
    private RecyclerView recyclerTechnique;
    TechniquesAdapter techniquesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        switch (communityvalues.getName()) {
                            case "Valsalva maneuver    ":
                                Intent intentValsalva = new Intent(view.getContext(), ValsalvaManeuver.class);
                                intentValsalva.putExtra("valsalva", 1);
                                startActivity(intentValsalva);
                                break;
                            case "TMS Stuttering       ":
                                Intent intentTms = new Intent(view.getContext(), Tms.class);
                                intentTms.putExtra("tms", 1);
                                startActivity(intentTms);
                                break;
                            case "Costal Breathing     ":
                                Intent intentCostal = new Intent(view.getContext(), CostalBreathing.class);
                                intentCostal.putExtra("costal", 1);
                                startActivity(intentCostal);
                                break;
                            case "McGuire Technique    ":
                                Intent intentMcguire = new Intent(view.getContext(), McGuireProgram.class);
                                intentMcguire.putExtra("costal", 1);
                                startActivity(intentMcguire);
                                break;
                            case "Fluency Shaping Tech.":
                                Intent intentFS = new Intent(view.getContext(), SpeechFluency.class);
                                intentFS.putExtra("fluency", 1);
                                startActivity(intentFS);
                                break;
                            case "Stutter Modification.":
                                Intent intentSM = new Intent(view.getContext(), StutteringModification.class);
                                intentSM.putExtra("modification", 1);
                                startActivity(intentSM);
                                break;
                            case "Integrative approach.":
                                Intent intentIntegrative = new Intent(view.getContext(), IntegrativeApproach.class);
                                intentIntegrative.putExtra("Integrative", 1);
                                startActivity(intentIntegrative);
                                break;
                            default:
                                Toast.makeText(Techniques.this, "Invalid Option Selected", Toast.LENGTH_SHORT).show();
                                break;
                        }
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
