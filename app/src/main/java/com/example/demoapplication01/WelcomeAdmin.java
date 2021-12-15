package com.example.demoapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


public class WelcomeAdmin extends AppCompatActivity {

    TextView welcomeUser;
    Button signOutBtn,createNewUser,createNewAdmin,basicCalculator;
    FrameLayout newCreationLayout;
    ConstraintLayout constrainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_admin);

        //Calling Value From XML
        welcomeUser = findViewById(R.id.welcomeUser);
        signOutBtn = findViewById(R.id.signOutBtn);
        createNewUser = findViewById(R.id.createNewUser);
//        createNewAdmin = findViewById(R.id.createNewAdmin);
        newCreationLayout = findViewById(R.id.newCreationLayout);
        constrainLayout = findViewById(R.id.constrainLayout);
        basicCalculator = findViewById(R.id.basicCalculator);

        //Getting Intend From Login and SignIn For nameData
        Intent i = getIntent();
        String nameData = i.getExtras().getString("nameValue","");
        welcomeUser.setText("Welcome "+nameData);

        Fragment fragment = new CreateNewAdmin();

//        getSupportFragmentManager().beginTransaction().add(R.id.newCreationLayout, new CreateNewAdmin()).commit();

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                finish();
            }
        });

        createNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                newCreationLayout.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.bg_newuser_admin));
                getSupportFragmentManager().beginTransaction().add(R.id.newCreationLayout,fragment).commit();
                newCreationLayout.setVisibility(View.VISIBLE);
                newCreationLayout.bringToFront();
            }
        });

        basicCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Basic Calculator",Toast.LENGTH_SHORT).show();
            }
        });

        constrainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getSupportFragmentManager().beginTransaction().remove(fragment);
                Log.d("Clicked","0");
                return false;
            }
        });
    }
}
