package android.huts.usama.freefromstammering.MainMenue.Connection.Fab;

import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WhatsappGroups extends AppCompatActivity {

    ImageView backToWhatsapp;
    LinearLayout g1, g2, g3, g4, g5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp_groups);
        backToWhatsapp = findViewById(R.id.backtowhatsappicon);
        backToWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        g1 = findViewById(R.id.group1);
        g2 = findViewById(R.id.group2);
        g3 = findViewById(R.id.group3);
        g4 = findViewById(R.id.group4);
        g5 = findViewById(R.id.group5);

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWhatsapp1 = new Intent(Intent.ACTION_VIEW);
                String url1 = "https://chat.whatsapp.com/4kJYnoCDCBzKdHBS1pVUxa";
                intentWhatsapp1.setData(Uri.parse(url1));
                intentWhatsapp1.setPackage("com.whatsapp");
                startActivity(intentWhatsapp1);
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWhatsapp2 = new Intent(Intent.ACTION_VIEW);
                String url2 = "https://chat.whatsapp.com/ELXsEAsF2hPI3LaCGW5JiY";
                intentWhatsapp2.setData(Uri.parse(url2));
                intentWhatsapp2.setPackage("com.whatsapp");
                startActivity(intentWhatsapp2);
            }
        });
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWhatsapp3 = new Intent(Intent.ACTION_VIEW);
                String url3 = "https://chat.whatsapp.com/J3otb22w8yf8bUxpGQmi88";
                intentWhatsapp3.setData(Uri.parse(url3));
                intentWhatsapp3.setPackage("com.whatsapp");
                startActivity(intentWhatsapp3);
            }
        });
        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWhatsapp4 = new Intent(Intent.ACTION_VIEW);
                String url4 = "https://chat.whatsapp.com/KpPiyXL3IamAAhCQaR2Eja";
                intentWhatsapp4.setData(Uri.parse(url4));
                intentWhatsapp4.setPackage("com.whatsapp");
                startActivity(intentWhatsapp4);
            }
        });
        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWhatsapp5 = new Intent(Intent.ACTION_VIEW);
                String url5 = "https://chat.whatsapp.com/4kJYnoCDCBzKdHBS1pVUxa";
                intentWhatsapp5.setData(Uri.parse(url5));
                intentWhatsapp5.setPackage("com.whatsapp");
                startActivity(intentWhatsapp5);
            }
        });
    }
}
