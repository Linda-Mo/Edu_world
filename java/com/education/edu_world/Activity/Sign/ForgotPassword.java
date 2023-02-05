package com.education.edu_world.Activity.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.education.edu_world.R;

public class ForgotPassword extends AppCompatActivity {

    private EditText edEmail;

    private ImageView imgBack;

    private LinearLayout lyt_progress;

    String email;

    private Button btnForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        imgBack = findViewById(R.id.forgot_back_password);
        edEmail = findViewById(R.id.forgot_pass_email);
        btnForgotPass = findViewById(R.id.btn_submit);
        lyt_progress = (LinearLayout) findViewById(R.id.lyt_progress);
        lyt_progress.setVisibility(View.GONE);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyt_progress.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lyt_progress.setVisibility(View.GONE);
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        btnForgotPass.setEnabled(true);
                        finish();
                    }
                }, 1000);

            }
        });


        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });


    }

    private void forgotPassword() {
        if (!validate()) {
            btnForgotPass.setEnabled(true);
            lyt_progress.setVisibility(View.GONE);
            return;
        }

        // ViewAnimation.fadeOut(lyt_progress);
        btnForgotPass.setEnabled(false);
        startForgotPassword();
    }


    private boolean validate() {
        boolean valid = true;
        email = edEmail.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edEmail.setError("Invalid email address");
            edEmail.requestFocus();
            valid = false;
        } else {

            edEmail.setError(null);
        }

        return valid;
    }


    private void startForgotPassword() {
        lyt_progress.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lyt_progress.setVisibility(View.GONE);
                // startActivity(new Intent(getApplicationContext(), MainActivity.class));
                btnForgotPass.setEnabled(true);
            }
        }, 1000);

    }


}