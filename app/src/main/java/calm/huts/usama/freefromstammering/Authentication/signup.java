package calm.huts.usama.freefromstammering.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import calm.huts.usama.freefromstammering.R;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class signup extends AppCompatActivity {

    ImageView backToMain;
    EditText username, email, password;
    ProgressDialog progressDialog;
    Button signup;
    //defining firebaseauth object
    FirebaseAuth firebaseAuth;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup = findViewById(R.id.signUps);

        progressDialog = new ProgressDialog(this);
        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        backToMain = findViewById(R.id.backtomain);
        username = findViewById(R.id.usi);
        email = findViewById(R.id.emi);
        password = findViewById(R.id.pass);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = username.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String passwords = password.getText().toString();
                if (usernames.equalsIgnoreCase("")){
                    username.setError("Please enter username");
                }
                else if (emails.equalsIgnoreCase("")){
                    email.setError("Please enter email");
                }
                else if (passwords.equalsIgnoreCase("")){
                    password.setError("Please enter password");
                }
                else{
                    progressDialog.setMessage("Registration Please Wait...");
                    progressDialog.show();
                    username.setText("");
                    email.setText("");
                    password.setText("");
                    performLoginOrAccountCreation(emails, passwords);
                }

            }
        });
    }

    private void performLoginOrAccountCreation(final String email, final String password){

        firebaseAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(this,
                new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        if (task.isSuccessful()){
                            SignInMethodQueryResult result = task.getResult();
                            if (result != null && result.getSignInMethods() != null
                            && result.getSignInMethods().size() > 0){
                                Toast.makeText(signup.this,
                                        "User Exists",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else {
                                registerAccount(email, password);
                            }
                        }
                        else {
                            Toast.makeText(signup.this,
                                    "There is problem, try again and enter correct credential",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
    }

    public void registerAccount(final String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(calm.huts.usama.freefromstammering.Authentication.signup.
                                    this, "Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent goToMainmenu = new Intent(calm.huts.usama.freefromstammering.Authentication.signup.this,
                                    logedin.class);
                            startActivity(goToMainmenu);
                        } else {
                            Toast.makeText(signup.this,
                                    "Account Registration Failed.",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}
