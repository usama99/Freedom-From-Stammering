package com.example.usama.freefromstammering;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Connections extends AppCompatActivity implements View.OnClickListener {

    LinearLayout doctor, communities;
    ImageView back;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2, fab3, fab4;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_connections);

        communities = findViewById(R.id.community);
        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);
        fab4 = findViewById(R.id.fab4);
        doctor = findViewById(R.id.doctor);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=speech therapists");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        communities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCommunity = new Intent(Connections.this, WebCommunity.class);
                startActivity(intentCommunity);
            }
        });
        back = findViewById(R.id.backmain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
                Intent fbIntent = new Intent(Connections.this, FacebookPagesAndGroups.class);
                startActivity(fbIntent);
//                Toast.makeText(this, "Click on fb", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2:

                Intent whatsappIntent = new Intent(Connections.this, WhatsappGroups.class);
                startActivity(whatsappIntent);
//                Toast.makeText(this, "Click on whatsapp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab3:

                Intent twitterIntent = new Intent(Connections.this, TwitterGroups.class);
                startActivity(twitterIntent);
//                Toast.makeText(this, "Click on twitter", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab4:

                Intent pinterestIntent = new Intent(Connections.this, PinterestDetails.class);
                pinterestIntent.putExtra("pinterest", "https://www.pinterest.com/stutteringfdn/");
                startActivity(pinterestIntent);
//                Toast.makeText(this, "Click on Pinterest", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            isFabOpen = false;
//            Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show();

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            isFabOpen = true;
//            Toast.makeText(this, "Open", Toast.LENGTH_SHORT).show();

        }
    }
}
