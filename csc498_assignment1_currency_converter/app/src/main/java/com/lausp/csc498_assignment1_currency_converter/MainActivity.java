package com.lausp.csc498_assignment1_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText addAmount;
     private TextView result;
     int amount;
     Button convertToLBP;
     Button convertToDollars;
     double results;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAmount = (EditText) findViewById(R.id.first);


        results =0;
        result = (TextView) findViewById(R.id.result);

    }
public boolean isInt(String n){
        if (n == null)
            return false;
        else{
            try {
                int num = Integer.parseInt(n);
            }catch (NumberFormatException e){
                return false;
            }

        }
        return true;
}

// add button to specify if lbp or usd (boolean )
    public void convertToLBP(View v) {
        //boolean flag  ;
        String given = addAmount.getText().toString();
        if (isInt(given)) {
            int amount = Integer.parseInt(addAmount.getText().toString());
            results = amount * 22000;
            String m = (String.valueOf(results)) + "LBP";
            result.setText(m);
            Toast.makeText(getApplicationContext(), "lbp", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(), "invalid input", Toast.LENGTH_SHORT).show();
        }
    }
    public void convertToDollars(View v){
        double amount =  Integer.parseInt(addAmount.getText().toString());
        results = ((amount )/ 22000);
        String m1 =(String.format("%.2f",results)) + "USD";
        result.setText(m1);
        Toast.makeText(getApplicationContext(), "$$", Toast.LENGTH_SHORT).show();



    }
/* add conditions
* fix design
* double usd only 2 decimals*/







}