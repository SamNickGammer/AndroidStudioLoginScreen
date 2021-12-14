package com.example.demoapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeUser extends AppCompatActivity {

    TextView welcomeUser;
    Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        //Calling Value From XML
        welcomeUser = findViewById(R.id.welcomeUser);
        signOutBtn = findViewById(R.id.signOutBtn);

        //Getting Intend From Login and SignIn For nameData
        Intent i = getIntent();
        String nameData = i.getExtras().getString("nameValue","");
        welcomeUser.setText("Welcome "+nameData);

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                finish();
            }
        });

    }
}