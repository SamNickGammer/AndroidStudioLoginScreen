package com.example.demoapplication01;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BasicCalculator extends AppCompatActivity {

    private Button addBtn,subBtn,multiplyBtn,divideBtn;
    private EditText firstNumber,secondNumber;
    private TextView answerDisplay;
    float num1 =0,num2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Select Button
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        divideBtn = findViewById(R.id.divideBtn);
        //Select Edit Text
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        //Select TextView To Display Answer
        answerDisplay = findViewById(R.id.answerDisplay);
    }

    public void addFun(View v){
        num1 = Integer.parseInt(firstNumber.getText()+"");
        num2 = Integer.parseInt(secondNumber.getText()+"");
        answerDisplay.setText(num1+num2+"");
    }
    public void subFun(View v){
        num1 = Integer.parseInt(firstNumber.getText()+"");
        num2 = Integer.parseInt(secondNumber.getText()+"");
        answerDisplay.setText(num1-num2+"");
    }
    public void mulFun(View v){
        num1 = Integer.parseInt(firstNumber.getText()+"");
        num2 = Integer.parseInt(secondNumber.getText()+"");
        answerDisplay.setText(num1*num2+"");
    }
    public void divFun(View v){
        num1 = Float.parseFloat(firstNumber.getText()+"");
        num2 = Float.parseFloat(secondNumber.getText()+"");
        answerDisplay.setText(num1/num2+"");
    }


}
