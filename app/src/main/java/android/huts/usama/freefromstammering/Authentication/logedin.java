package android.huts.usama.freefromstammering.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.huts.usama.freefromstammering.MainMenue.Mainmenu;
import android.huts.usama.freefromstammering.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class logedin extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    ImageView back;
    EditText emisignin, passlogin;
    Button login, loginGoogle;
    TextView forget;
    ProgressDialog progressDialoglogin;
//    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logedin);
        mAuth = FirebaseAuth.getInstance();

        loginGoogle = findViewById(R.id.signingoogle);
        forget = findViewById(R.id.forgetpass);
        emisignin = findViewById(R.id.emaillogin);
        passlogin = findViewById(R.id.passwordlogin);
        login = findViewById(R.id.signin);
        back = findViewById(R.id.back);
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

        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });
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
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e);
                // ...
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
//                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent goTomain = new Intent(getApplicationContext(), Mainmenu.class);
                            startActivity(goTomain);
                            Toast.makeText(logedin.this, "" +
                                    "Signin Successfully", Toast.LENGTH_SHORT).show();
                            finish();
//                            updateUI(user);
                        } else {
                            Toast.makeText(logedin.this, "" +
                                    "Couldn't login, try again", Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });

    }

    public void loginUser() {
        //getting email and password from edit texts
        String emaillogin = emisignin.getText().toString().trim();
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

//                            FirebaseUser user = mAuth.getCurrentUser();
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
                                        "Authentication failed", Toast.LENGTH_SHORT).show();
                                finish();
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
//    private void notifyUser(String message) {
//        Toast.makeText(this, message,
//                Toast.LENGTH_SHORT).show();
//    }
}