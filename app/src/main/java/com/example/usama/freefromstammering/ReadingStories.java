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
import java.util.Objects;

public class ReadingStories extends AppCompatActivity {

    ImageView backReading;
    private List<ItemReading> readingStories = new ArrayList<>();
    private RecyclerView recyclerViews;
    private AdapterReading adapterReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_reading_stories);

        recyclerViews = findViewById(R.id.recycler_view_readings);
        adapterReading = new AdapterReading(readingStories);
        backReading = findViewById(R.id.backtoReading);
        backReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView.LayoutManager layoutManagerReading = new LinearLayoutManager(getApplicationContext());
        recyclerViews.setLayoutManager(layoutManagerReading);
        recyclerViews.setItemAnimator(new DefaultItemAnimator());
        recyclerViews.setAdapter(adapterReading);

        //listener
        recyclerViews.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerViews,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        ItemReading itemReading = readingStories.get(position);
                        view.getContext();
                        Intent readingIntent = new Intent(view.getContext(), ReadingSite.class);
                        readingIntent.putExtra("links", itemReading.getReading());
                        startActivity(readingIntent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
        ItemStoryReading();
    }

    private void ItemStoryReading() {

        ItemReading itemListStories = new ItemReading("Marc Anthony", "5 min", "" +
                "https://www.stutteringhelp.org/content/singing-safe-haven-marc-anthony");
        readingStories.add(itemListStories);

        itemListStories = new ItemReading("Emily Blunt", "10 min", "" +
                "https://www.stutteringhelp.org/famous-people/emily-blunt");
        readingStories.add(itemListStories);

        itemListStories = new ItemReading("Wayne Brady", "6 min", "" +
                "https://www.stutteringhelp.org/content/wayne-brady");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Noel and Liam Gallagher", "8 min", "" +
                "https://www.stutteringhelp.org/content/singer-rocks");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Tim Gunn", "7 min", "" +
                "https://www.stutteringhelp.org/content/tim-gunn");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Steve Harvey", "8 min", "" +
                "https://www.stutteringhelp.org/content/steve-harvey");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("John Lee Hooker", "7 min", "" +
                "https://www.stutteringhelp.org/content/john-lee-hooker");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Samuel L. Jackson", "10 min", "" +
                "https://www.stutteringhelp.org/content/samuel-l-jackson");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Scatman John", "9 min", "" +
                "https://www.stutteringhelp.org/content/scatman-john");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("James Earl Jones", "5 min", "" +
                "https://www.stutteringhelp.org/famous-people/james-earl-jones");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Nicole Kidman", "3 min", "" +
                "https://www.stutteringhelp.org/content/nicole-kidman");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("B.B. King", "6 min", "" +
                "https://www.stutteringhelp.org/content/bb-king");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Harvey Keitel", "4 min", "" +
                "https://www.stutteringhelp.org/content/harvey-keitel");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Kendrick Lamar", "2 min", "" +
                "https://www.stutteringhelp.org/content/kendrick-lamar");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Peggy Lipton", "4 min", "" +
                "https://www.stutteringhelp.org/content/peggy-lipton");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("John Melendez (Podcasts)", "40 min", "" +
                "http://stuttertalk.com/mr-john-melendez-from-the-tonight-show-with-jay-leno-talks-about-stuttering-episode-91/");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Marilyn Monroe", "5 min", "" +
                "https://www.stutteringhelp.org/famous-people/marilyn-monroe");
        readingStories.add(itemListStories);

        itemListStories = new ItemReading("Sam Neill", "10 min", "" +
                "https://www.stutteringhelp.org/content/actor-sam-neill-talks-about-stuttering");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Jack Paar", "11 min", "" +
                "https://www.stutteringhelp.org/famous-people/jack-paar");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Elvis Presley", "7 min", "" +
                "https://www.stutteringhelp.org/content/elvis-presley");
        readingStories.add(itemListStories);
        itemListStories = new ItemReading("Eric Roberts", "6 min", "" +
                "https://www.stutteringhelp.org/content/eric-roberts");
        readingStories.add(itemListStories);

        adapterReading.notifyDataSetChanged();
    }
}