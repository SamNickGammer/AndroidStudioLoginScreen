package com.example.demoapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminSignUp extends AppCompatActivity {

    private TextView alreadyReg;
    Button signUpBtn;
    EditText inputName,inputUsername,inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        alreadyReg = findViewById(R.id.alreadyReg);
        signUpBtn = findViewById(R.id.signUpBtn);

        inputName = findViewById(R.id.inputName);
        inputUsername  = findViewById(R.id.inputUserName);
        inputPassword  = findViewById(R.id.inputPassword);


        SharedPreferences prefs = getSharedPreferences("adminCredential",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        alreadyReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefs.getAll().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Error Data Not Found", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent((getApplicationContext()),AdminSignUp.class));
                }else {
                    startActivity(new Intent(getApplicationContext(), AdminLogin.class));
                }
                finish();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString().trim();
                String username = inputUsername.getText().toString().trim();
                String pass = inputPassword.getText().toString().trim();

                if (!name.equals("")&&!username.equals("")&&!pass.equals("")){
                    String checkUser = prefs.getString("username"+username,"");
                    if(checkUser.equals("")) {
                        editor.putString("name" + username, name);
                        editor.putString("username" + username, username);
                        editor.putString("password" + username, pass);
                        editor.commit();
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), WelcomeAdmin.class);
                        i.putExtra("nameValue", name);
                        startActivity(i);
                        finish();

                    }else {
                        Toast.makeText(getApplicationContext(),"Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Enter All Field",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}