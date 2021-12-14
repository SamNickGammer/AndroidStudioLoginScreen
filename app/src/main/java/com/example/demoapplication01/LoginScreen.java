package com.example.demoapplication01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    private TextView newUserReg,adminLogin;
    EditText usernameText,passwordText;
    Button loginBtn;
    public String textUserName,textPassword,textName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        newUserReg = findViewById(R.id.newUserReg);
        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);
        loginBtn = findViewById(R.id.loginBtn);
        adminLogin = findViewById(R.id.adminLogin);

        SharedPreferences userPref = getSharedPreferences("credential",MODE_PRIVATE);
        SharedPreferences adminPref = getSharedPreferences("adminCredential",MODE_PRIVATE);

        newUserReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignIn.class));
                finish();
            }
        });

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adminPref.getAll().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Error Data Not Found", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent((getApplicationContext()),AdminSignUp.class));
                }else {
                    startActivity(new Intent(getApplicationContext(), AdminLogin.class));
                }
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textUserName = usernameText.getText().toString().trim();
                textPassword = passwordText.getText().toString().trim();

                textName = userPref.getString("name"+textUserName,"");

                String username = userPref.getString("username"+textUserName,"");
                String password = userPref.getString("password"+textUserName,"");

                if(!textUserName.equals("")&&!textPassword.equals("")) {
                    if (!username.equals("") && password.equals(textPassword)) {
                        Intent i = new Intent(getApplicationContext(), WelcomeUser.class);
                        i.putExtra("nameValue", textName);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Credential", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Enter All Field", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
