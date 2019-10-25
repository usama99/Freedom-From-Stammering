package calm.huts.usama.freefromstammering.MainMenue.Setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import calm.huts.usama.freefromstammering.R;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Objects;

public class Help extends AppCompatActivity {

    ImageView backHelp;
    EditText issueSend;
    Button send;
    String issues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        backHelp = findViewById(R.id.backtohelp);
        backHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        issueSend = findViewById(R.id.issue);
        send = findViewById(R.id.sign);
        issues = Objects.requireNonNull(issueSend.getText()).toString();
        send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:usamaijaz404@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problem Occur!");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Issues "+ issues);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }
}