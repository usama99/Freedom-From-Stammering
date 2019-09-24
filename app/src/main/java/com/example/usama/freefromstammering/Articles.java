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
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Articles extends AppCompatActivity {

    ImageView backToExe;
    private List<Items> all_articles = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterItem adapterItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_articles);
        backToExe = findViewById(R.id.backtoexe);
        backToExe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        recyclerView = findViewById(R.id.recycler_view);
        adapterItem = new AdapterItem(all_articles);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterItem);
        //item listerner

        recyclerView.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerView,
                new RecycleTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Items moreItems = all_articles.get(position);
                view.getContext();
                Intent intent = new Intent(view.getContext(), Article_site.class);
                intent.putExtra("description",moreItems.getDescription());
                startActivity(intent);

//                Toast.makeText(getApplicationContext(), moreItems.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        ItemData();
    }

    private void ItemData(){

        Items itemList = new Items(getResources().getString(R.string.stutter1), "NIDCD   ", "" +
                "https://www.nidcd.nih.gov/health/stuttering", "10 mins");
        all_articles.add(itemList);

        itemList = new Items("15 ways to get rid of stutter.", "Home Cure", "" +
                "https://home-cure.net/stammering-exercises-treatment-home-cures-stuttering/", "8 mins");
        all_articles.add(itemList);

        itemList = new Items("Treatment|Therapy.", "NHS      ", "" +
                "https://www.nhs.uk/conditions/stammering/treatment/", "9 mins");
        all_articles.add(itemList);

        itemList = new Items("Any cure for stammering.", "BSA      ", "" +
                "https://www.stammering.org/help-information/topics/therapy-treatment/there-cure-stammering", "7 mins");
        all_articles.add(itemList);

        itemList = new Items("Treatment for adult.", "icommuns ", "" +
                "https://www.icommunicatetherapy.com/", "8 mins");
        all_articles.add(itemList);

        itemList = new Items("Stammer(Stutter) Treatments.", "Patient ", "" +
                "https://www.mayoclinic.org/diseases-conditions/stuttering/diagnosis-treatment/drc-20353577", "11 mins");
        all_articles.add(itemList);
        itemList = new Items("Stammering Therapy|Treatment.", "Hear SOL", "" +
                "https://www.hearingsol.com/articles/stutter-and-stammer/", "15 mins");
        all_articles.add(itemList);

        itemList = new Items("Stammering Vs Stuttering.", "H&H     ", "" +
                "http://www.irishhealth.com/article.html?con=101", "15 mins");
        all_articles.add(itemList);

        itemList = new Items("Effective Homeopathic Medicine.", "Dr Homeo", "" +
                "https://www.drhomeo.com/homeopathic-treatment/homeopathic-medicines-for-stammering/", "11 mins");
        all_articles.add(itemList);

        itemList = new Items("Stuttering Disease Reference Helper.", "Drugs.com", "" +
                "https://www.drugs.com/", "5 mins");
        all_articles.add(itemList);

        itemList = new Items("Stammering & Stuttering in children| How to help.", "WebMD    ", "" +
                "https://www.webmd.com/g00/children/guide/how-to-help-stammering-child?i10c.ua=1&i10c.encReferrer=" +
                "aHR0cHM6Ly93d3cud2VibWQuY29tL2NoaWxkcmVuL2d1aWRlL2hvdy10by1oZWxwLXN0YW1tZXJpbmctY2hpbGQ%3d&i10c.dv=2", "5 mins");
        all_articles.add(itemList);

        adapterItem.notifyDataSetChanged();
    }
}
