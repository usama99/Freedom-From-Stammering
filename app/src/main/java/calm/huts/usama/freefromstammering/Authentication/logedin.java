package calm.huts.usama.freefromstammering.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import calm.huts.usama.freefromstammering.MainMenue.Mainmenu;
import calm.huts.usama.freefromstammering.R;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class logedin extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    ImageView back;
    EditText emisignin, passlogin;
    Button login;
    TextView forget;
    ProgressDialog progressDialoglogin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logedin);
        mAuth = FirebaseAuth.getInstance();

//        loginGoogle = findViewById(R.id.signingoogle);
        forget = findViewById(R.id.forgetpass);
        emisignin = findViewById(R.id.emaillogin);
        passlogin = findViewById(R.id.passwordlogin);
        login = findViewById(R.id.signin);
        back = findViewById(R.id.back);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            Intent i = new Intent(this, Mainmenu.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        progressDialoglogin = new ProgressDialog(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentforget = new Intent(logedin.this, ForgetPassword.class);
                startActivity(intentforget);
            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

//        loginGoogle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//                startActivityForResult(signInIntent, 101);
//            }
//        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 101) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(Objects.requireNonNull(account));
            } catch (ApiException e) {
                Toast.makeText(this, "Login error, try again", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent goTomain = new Intent(getApplicationContext(), Mainmenu.class);
                            startActivity(goTomain);
                            Toast.makeText(logedin.this, "" +
                                    "Signin Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(logedin.this, "" +
                                    "Couldn't login, try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void loginUser() {
        //getting email and password from edit texts
        final String emaillogin = emisignin.getText().toString().trim();
        String passwordslogin = passlogin.getText().toString().trim();

        if ((emaillogin.equalsIgnoreCase(""))){

            emisignin.setError("Please enter email");

        }
        else if ((passwordslogin.equalsIgnoreCase(""))){

            passlogin.setError("Please enter password");

        }
        else{
            progressDialoglogin.setMessage("Login Please Wait...");
            progressDialoglogin.show();
            mAuth.signInWithEmailAndPassword(emaillogin, passwordslogin)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null){
                                    emisignin.setText("");
                                    passlogin.setText("");
                                    Intent goToMainlogin = new Intent(
                                            logedin.this,
                                            Mainmenu.class);
                                    startActivity(goToMainlogin);
                                }
                                Toast.makeText(logedin.this, "" +
                                        "Signin Successfully", Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(logedin.this, "" +
                                        "Authentication Failed, Try again!", Toast.LENGTH_SHORT).show();
                                emisignin.setText("");
                                passlogin.setText("");
                            }
                            progressDialoglogin.dismiss();
                        }
                    });
        }

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

}