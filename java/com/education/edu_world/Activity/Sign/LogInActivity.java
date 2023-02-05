package com.education.edu_world.Activity.Sign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.education.edu_world.Activity.MainActivity;
import com.education.edu_world.R;


public class LogInActivity extends AppCompatActivity {

    private EditText edUsername, edPassword;

    private TextView tvForgotPassword, tvSignUp;

    private LinearLayout lyt_progress;

    String email;
    String password;

    private Button btnSignIn;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        edUsername = findViewById(R.id.log_in_email);
        edPassword = findViewById(R.id.log_in_password);
        tvForgotPassword = findViewById(R.id.forgot_password);
        tvSignUp = findViewById(R.id.registration);
        btnSignIn = findViewById(R.id.btn_log_in);
        lyt_progress = (LinearLayout) findViewById(R.id.lyt_progress);
        lyt_progress.setVisibility(View.GONE);

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
                btnSignIn.setEnabled(true);
                lyt_progress.setVisibility(View.GONE);
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentRegistration.class));
                btnSignIn.setEnabled(true);
                lyt_progress.setVisibility(View.GONE);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });





    }

    private void login() {
        if (!validate()) {
            btnSignIn.setEnabled(true);
            lyt_progress.setVisibility(View.GONE);
            return;
        }

        // ViewAnimation.fadeOut(lyt_progress);
        btnSignIn.setEnabled(false);
        startSignIn();
    }


    private boolean validate() {
        boolean valid = true;
        email = edUsername.getText().toString();
        password = edPassword.getText().toString();

        if (email.isEmpty() ) {
            edUsername.setError("Invalid Userd ID");
            edUsername.requestFocus();
            valid = false;
        } else {

            edUsername.setError(null);
        }
        if (password.isEmpty() || password.length() < 6 || password.length() > 20) {
            edPassword.setError("Password is too small");
            edPassword.requestFocus();
            return false;
        }
        edPassword.setError(null);
        return valid;
    }


    private void startSignIn() {
        lyt_progress.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lyt_progress.setVisibility(View.GONE);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                btnSignIn.setEnabled(true);
            }
        }, 1000);

    }


    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {

            super.onBackPressed();
            return;
        }

        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                doubleBackToExitPressedOnce = false;
                System.exit(0);
            }
        }, 2000);
    }




}