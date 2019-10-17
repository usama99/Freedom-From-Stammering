package android.huts.usama.freefromstammering.MainMenue.Connection.Fab;

import android.content.Intent;
import android.huts.usama.freefromstammering.Adapters.TwitterAdapter;
import android.huts.usama.freefromstammering.Classes.RecycleTouchListener;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class TwitterGroups extends AppCompatActivity {

    ImageView backWhatsapp;
    private RecyclerView recyclerViewTwiter;
    private List<FacebookGroups> twitterGroups = new ArrayList<>();
    private TwitterAdapter twitterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_groups);
        backWhatsapp = findViewById(R.id.backtotwittericon);
        backWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        twitterAdapter = new TwitterAdapter(twitterGroups);
        recyclerViewTwiter = findViewById(R.id.recycler_view_twitter);

        RecyclerView.LayoutManager layoutManagerWhatsapp = new LinearLayoutManager(getApplicationContext());
        recyclerViewTwiter.setLayoutManager(layoutManagerWhatsapp);
        recyclerViewTwiter.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTwiter.setAdapter(twitterAdapter);

        //item listerner
        recyclerViewTwiter.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerViewTwiter,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        FacebookGroups tgroup = twitterGroups.get(position);
                        view.getContext();
                        Intent intent = new Intent(view.getContext(), TwitterLinks.class);
                        intent.putExtra("Twiterlinks",tgroup.getFbGroupIconName());
                        startActivity(intent);

//                    Toast.makeText(getApplicationContext(), communityvalues.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

        twitterGroupData();
    }

    private void twitterGroupData() {


        FacebookGroups tgroups = new FacebookGroups("Nat Stutter Community ", "" +
                "https://twitter.com/westutter");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Stuttering is cool    ", "" +
                "https://twitter.com/stutterdude");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Stuttering Social     ", "" +
                "https://twitter.com/stuttersocial");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("LA speech therapy     ", "" +
                "https://twitter.com/LASpeechTherapy");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Speech Therapist FFM  ", "" +
                "https://twitter.com/SLT_Frankfurt");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Nexa Speech & Therapy ", "" +
                "https://twitter.com/nexaclinic");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("CAP Speech Therapy    ", "" +
                "https://twitter.com/capspeech");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Speech Therapy Works  ", "" +
                "https://twitter.com/SpeechTherapySG");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Speech Therpay Unltd  ", "" +
                "https://twitter.com/SpeechFixer");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("SLP Works             ", "" +
                "https://twitter.com/SLPWorks");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Ethan Marcotte        ", "" +
                "https://twitter.com/beep");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Sayorg                ", "" +
                "https://twitter.com/sayorg");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Stutter Friends       ", "" +
                "https://twitter.com/StutterFRIENDS");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Stuttering Treatment  ", "" +
                "https://twitter.com/StutteringTx");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Carl Herder           ", "" +
                "https://twitter.com/AIS_Carl");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Anita S. Blom         ", "" +
                "https://twitter.com/anita_stutters");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("CSA Stuttering        ", "" +
                "https://twitter.com/CSAStuttering");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Stuttering Super Hero ", "" +
                "https://twitter.com/KimBlock17");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Speech Stutter Inst   ", "" +
                "https://twitter.com/SpchStutterInst");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("OAPWS Community       ", "" +
                "https://twitter.com/OAPWS");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Stuttering Research   ", "" +
                "https://twitter.com/speechlabmsu");
        twitterGroups.add(tgroups);


        tgroups = new FacebookGroups("HCRI Stutter Therapy  ", "" +
                "https://twitter.com/Help4Stuttering");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Vicky C               ", "" +
                "https://twitter.com/vickycrofts24");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("The Fluency Trust     ", "" +
                "https://twitter.com/TheFluencyTrust");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Marie Halpin SLT      ", "" +
                "https://twitter.com/mariechalpin");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Jo Lester             ", "" +
                "https://twitter.com/JoLesterSLT");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Naomi Francis         ", "" +
                "https://twitter.com/NaomiSLP93");
        twitterGroups.add(tgroups);

        tgroups = new FacebookGroups("Sarah Rowlands        ", "" +
                "https://twitter.com/SarahTheSALT");
        twitterGroups.add(tgroups);

        twitterAdapter.notifyDataSetChanged();
    }
}
