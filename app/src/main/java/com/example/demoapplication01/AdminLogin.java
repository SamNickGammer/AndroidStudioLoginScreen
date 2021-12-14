package com.example.demoapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class AdminLogin extends AppCompatActivity {

    TextView userLogin;
    EditText usernameText,passwordText;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        userLogin = findViewById(R.id.userLogin);
        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);
        loginBtn = findViewById(R.id.loginBtn);

        SharedPreferences prefs = getSharedPreferences("adminCredential",MODE_PRIVATE);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameInput = usernameText.getText().toString().trim();
                String passwordInput = passwordText.getText().toString().trim();

                String username = prefs.getString("username"+usernameInput,"");
                String password = prefs.getString("password"+usernameInput,"");
                String name = prefs.getString("name"+usernameInput,"");

                if(!usernameInput.equals("")&&!passwordInput.equals("")){
                    if(!username.equals("") && password.equals(passwordInput)){
                        Intent i = new Intent(getApplicationContext(),WelcomeAdmin.class);
                        i.putExtra("nameValue",name);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Wrong Credential",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Enter All Field",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}