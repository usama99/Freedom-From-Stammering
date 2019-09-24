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

import java.util.ArrayList;
import java.util.List;

public class FacebookPagesAndGroups extends AppCompatActivity {

    ImageView backToicon;
    private List<FacebookGroups> facebookGroups = new ArrayList<>();
    private RecyclerView recyclerViewGroups;
    private FacebookGroupAdapter facebookGroupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_facebook_pages_and_groups);
        backToicon = findViewById(R.id.backtofbicons);
        facebookGroupAdapter = new FacebookGroupAdapter(facebookGroups);
        recyclerViewGroups = findViewById(R.id.recycler_view_facebook);
        backToicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManagerFacebook = new LinearLayoutManager(getApplicationContext());
        recyclerViewGroups.setLayoutManager(layoutManagerFacebook);
        recyclerViewGroups.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGroups.setAdapter(facebookGroupAdapter);

        //item listerner
        recyclerViewGroups.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerViewGroups,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        FacebookGroups fbgroup = facebookGroups.get(position);
                        view.getContext();
                        Intent intent = new Intent(view.getContext(), FacebookLinks.class);
                        intent.putExtra("facebooklinks",fbgroup.getFbGroupIconName());
                        startActivity(intent);

//                    Toast.makeText(getApplicationContext(), communityvalues.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

        facebookGroupData();
    }

    private void facebookGroupData() {

        FacebookGroups groups = new FacebookGroups("Stutter Social       ", "" +
                "https://www.facebook.com/stuttersocialofficial/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Drew Lynch(Comedian) ", "" +
                "https://www.facebook.com/TheDrewLynch/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Fnd       ", "" +
                "https://www.facebook.com/stutteringhelp/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Community ", "" +
                "https://www.facebook.com/groups/98233252577/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Theraphy  ", "" +
                "https://www.facebook.com/groups/stuttheralt/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Interrupt ", "" +
                "https://www.facebook.com/stuttererinterrupted/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Academy   ", "" +
                "https://www.facebook.com/groups/168290933806220/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("National Stutter Aso.", "" +
                "https://www.facebook.com/WeStutter/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Inter Stuttering Aso.", "" +
                "https://www.facebook.com/isastutter/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Mind Body Disorder   ", "" +
                "https://www.facebook.com/groups/1808396596092330/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Arena     ", "" +
                "https://www.facebook.com/groups/239310959439557/?ref=br_rs");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Hangouts  ", "" +
                "https://www.facebook.com/groups/stutteringhangout/?ref=br_rs");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Foundation", "" +
                "https://www.facebook.com/stutteringhelp/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stutter              ", "" +
                "https://www.facebook.com/stutterband.ph/");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Stuttering Out Loud  ", "" +
                "https://www.facebook.com/groups/StutteringOutLoud/?ref=search");
        facebookGroups.add(groups);

        groups = new FacebookGroups("Speech Fluency Zone  ", "" +
                "https://www.facebook.com/groups/254485435079458/?ref=search");
        facebookGroups.add(groups);

        facebookGroupAdapter.notifyDataSetChanged();
    }
}
