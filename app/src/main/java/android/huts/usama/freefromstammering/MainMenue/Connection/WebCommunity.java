package android.huts.usama.freefromstammering.MainMenue.Connection;

import android.content.Intent;
import android.huts.usama.freefromstammering.Adapters.AdapterCommnunityItem;
import android.huts.usama.freefromstammering.Classes.CommunityItems;
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

public class WebCommunity extends AppCompatActivity {

    ImageView backToCommunity;
    private List<CommunityItems> communityItems = new ArrayList<>();
    private RecyclerView recyclerViewCommunity;
    AdapterCommnunityItem adapterCommnunityItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_community);
        backToCommunity = findViewById(R.id.backtocom);
        backToCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        adapterCommnunityItem = new AdapterCommnunityItem(communityItems);
        recyclerViewCommunity = findViewById(R.id.recycler_view_community);
        RecyclerView.LayoutManager layoutManagerCommunity = new LinearLayoutManager(getApplicationContext());
        recyclerViewCommunity.setLayoutManager(layoutManagerCommunity);
        recyclerViewCommunity.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCommunity.setAdapter(adapterCommnunityItem);

        //item listerner
        recyclerViewCommunity.addOnItemTouchListener(new RecycleTouchListener(getApplicationContext(), recyclerViewCommunity,
                new RecycleTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        CommunityItems communityvalues = communityItems.get(position);
                        view.getContext();
                        Intent intent = new Intent(view.getContext(), DetailSiteCommunity.class);
                        intent.putExtra("descriptionCommunity",communityvalues.getIcon());
                        startActivity(intent);

//                    Toast.makeText(getApplicationContext(), communityvalues.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
        ItemDataCommunity();
    }

    private void ItemDataCommunity() {
        CommunityItems items = new CommunityItems("BSA       ", "" +
                "https://www.stammering.org/");
        communityItems.add(items);
        items = new CommunityItems("NSA       ", "" +
                "https://westutter.org/");
        communityItems.add(items);
        items = new CommunityItems("PSH       ", "" +
                "http://www.isastutter.org/pakistan");
        communityItems.add(items);
        items = new CommunityItems("TISA      ", "" +
                "http://stammer.in/");
        communityItems.add(items);
        items = new CommunityItems("TSF       ", "" +
                "https://www.stutteringhelp.org/");
        communityItems.add(items);
        items = new CommunityItems("Speak Easy", "" +
                "http://www.speakeasy.org.za/");
        communityItems.add(items);
        items = new CommunityItems("ABOFAFD   ", "" +
                "https://www.stutteringspecialists.org/default.aspx");
        communityItems.add(items);
        items = new CommunityItems("Friends   ", "" +
                "https://www.friendswhostutter.org/");
        communityItems.add(items);
        items = new CommunityItems("Stotteren ", "" +
                "http://www.stotteren.be/");
        communityItems.add(items);
        items = new CommunityItems("Stoteren.F", "" +
                "http://www.stotterforum.be/");
        communityItems.add(items);
        items = new CommunityItems("SCAC      ", "" +
                "http://www.isastutter.org/cameroon/");
        communityItems.add(items);
        items = new CommunityItems("CSA       ", "" +
                "https://stutter.ca/");
        communityItems.add(items);
        items = new CommunityItems("EKU      ", "" +
                "http://www.kogelus.ee/");
        communityItems.add(items);
        items = new CommunityItems("FSA       ", "" +
                "http://www.ankytys.fi/");
        communityItems.add(items);
        items = new CommunityItems("FSD       ", "" +
                "https://stammeforeningen.dk/");
        communityItems.add(items);
        items = new CommunityItems("SWA       ", "" +
                "https://www.begaiement.org/");
        communityItems.add(items);
        items = new CommunityItems("FSD       ", "" +
                "https://stammeforeningen.dk/");
        communityItems.add(items);
        items = new CommunityItems("FAS       ", "" +
                "https://www.bvss.de/");
        communityItems.add(items);
        items = new CommunityItems("DEMOSTHENE", "" +
                "http://www.demosthenes.nl/");
        communityItems.add(items);
        items = new CommunityItems("NZSEAI    ", "" +
                "https://sites.google.com/site/nzspeakeasyassn/");
        communityItems.add(items);
        items = new CommunityItems("SAON      ", "" +
                "http://www.isastutter.org/nigeria/");
        communityItems.add(items);
        items = new CommunityItems("NIFS      ", "" +
                "http://stamming.no/");
        communityItems.add(items);

        adapterCommnunityItem.notifyDataSetChanged();
    }
}
