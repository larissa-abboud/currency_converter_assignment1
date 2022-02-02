package com.lausp.csc498_assignment1_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText addAmount;
     TextView result;
     Button convertToLBP;
     Button convertToDollars;
     int results;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAmount = (EditText) findViewById(R.id.first);
        result = (TextView) findViewById(R.id.result);
        convertToLBP = (Button) findViewById(R.id.button2);
        convertToDollars = (Button) findViewById(R.id.button3);



    }
    public void convertLbp(View v){
       int amount =  Integer.parseInt(addAmount.getText().toString());
        results = amount * 22000;
        



    }
}