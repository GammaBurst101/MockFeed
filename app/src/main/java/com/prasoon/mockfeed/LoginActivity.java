package com.prasoon.mockfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button gotoSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gotoSignup = findViewById(R.id.signupBtn);

        //If clicked, the user should be redirected to the account creation page
        gotoSignup.setOnClickListener(view -> startActivity(new Intent(this, SignupActivity.class)));
    }
}