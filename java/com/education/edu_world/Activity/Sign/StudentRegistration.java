package com.education.edu_world.Activity.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.education.edu_world.Activity.MainActivity;
import com.education.edu_world.R;

public class StudentRegistration extends AppCompatActivity {

    private EditText edFirstName, edLastName, edEmail, edSchool, edPassword, edConfirmPassword;

    private TextView tvReturnToLogIn;

    private LinearLayout lyt_progress;

    String getFirstName;
    String getLastName;
    String getSchool;
    String getEmail;
    String getPassword;
    String getConfirmPassword;

    private Button btnSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        edFirstName = findViewById(R.id.reg_first_name);
        edLastName = findViewById(R.id.reg_last_name);
        edEmail = findViewById(R.id.reg_email);
        edSchool = findViewById(R.id.reg_school);
        edPassword = findViewById(R.id.reg_password);
        edConfirmPassword = findViewById(R.id.reg_confirm_password);

        tvReturnToLogIn = findViewById(R.id.sign_up);

        btnSignUp = findViewById(R.id.btn_registration);
        lyt_progress = (LinearLayout) findViewById(R.id.lyt_progress);
        lyt_progress.setVisibility(View.GONE);

        tvReturnToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyt_progress.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lyt_progress.setVisibility(View.GONE);
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        btnSignUp.setEnabled(true);
                        finish();
                    }
                }, 1000);

            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });


    }


    private void signUp() {
        if (!validate()) {
            btnSignUp.setEnabled(true);
            lyt_progress.setVisibility(View.GONE);
            return;
        }

        // ViewAnimation.fadeOut(lyt_progress);
        btnSignUp.setEnabled(false);
        startSignUp();
    }

    private boolean validate() {
        boolean valid = true;

        getFirstName = edFirstName.getText().toString().trim();
        getLastName = edLastName.getText().toString().trim();
        getEmail = edEmail.getText().toString().trim();
        getSchool = edSchool.getText().toString().trim();
        getPassword = edPassword.getText().toString().trim();
        getConfirmPassword = edConfirmPassword.getText().toString().trim();

        if (getFirstName.isEmpty() || getFirstName.length() < 3) {
            edFirstName.setError("Please Enter your name");
            edFirstName.requestFocus();

            valid = false;
        } else {
            edFirstName.setError((CharSequence) null);
        }

        if (getLastName.isEmpty() || getLastName.length() < 3) {
            edLastName.setError("Please enter your surname");
            edLastName.requestFocus();
            valid = false;
        } else {
            edLastName.setError((CharSequence) null);
        }
        if (getSchool.isEmpty() || getSchool.length() < 3) {
            edSchool.setError("Please enter your School");
            edSchool.requestFocus();
            valid = false;
        } else {
            edSchool.setError((CharSequence) null);
        }
        if (getEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(getEmail).matches()) {
            edEmail.setError("Pleas enter a valid edEmail address");
            edEmail.requestFocus();
            valid = false;
        } else {
            edEmail.setError((CharSequence) null);
        }

        if (getPassword.isEmpty() || getPassword.length() < 6 || getPassword.length() > 20) {
            edPassword.setError("Enter at least 6 characters");
            edPassword.requestFocus();
            valid = false;
        } else {
            edPassword.setError((CharSequence) null);
        }

        if (getConfirmPassword.isEmpty() || getConfirmPassword.length() < 6 || getConfirmPassword.length() > 20 || !getConfirmPassword.equals(getPassword)) {
            edConfirmPassword.setError("Password do not match");
            edConfirmPassword.requestFocus();
            return false;
        }
        edConfirmPassword.setError((CharSequence) null);
        return valid;
    }


    private void startSignUp() {
        lyt_progress.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lyt_progress.setVisibility(View.GONE);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                btnSignUp.setEnabled(true);
            }
        }, 1000);

    }
}