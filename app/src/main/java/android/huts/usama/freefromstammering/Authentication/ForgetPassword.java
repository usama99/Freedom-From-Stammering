package android.huts.usama.freefromstammering.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    ImageView backForget;
    EditText newPass;
    Button resetIt;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialogreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        backForget = findViewById(R.id.backforget);
        newPass = findViewById(R.id.enterpass);
        resetIt = findViewById(R.id.forgetbutton);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialogreset = new ProgressDialog(this);
        backForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        resetIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (newPass.getText().toString().equalsIgnoreCase("")){
                    newPass.setError("Please enter your email");
                }
                else{
                    progressDialogreset.setMessage("Sending Please Wait...");
                    progressDialogreset.show();
                    firebaseAuth.sendPasswordResetEmail(newPass.getText().toString()).addOnCompleteListener(
                            new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        newPass.setText("");
                                        Toast.makeText(ForgetPassword.this, "Send reset password link to your emailID," +
                                                        " Please confirm it",
                                                Toast.LENGTH_LONG).show();
                                        Intent backLogin = new Intent(ForgetPassword.this, logedin.class);
                                        startActivity(backLogin);
                                    }
                                    else{
                                        Toast.makeText(ForgetPassword.this, task.getException().getMessage(),
                                                Toast.LENGTH_LONG).show();
                                    }
                                    progressDialogreset.dismiss();
                                }
                            });
                }
            }
        });

    }
}
