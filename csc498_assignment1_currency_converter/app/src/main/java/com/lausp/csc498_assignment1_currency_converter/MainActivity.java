package com.lausp.csc498_assignment1_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText addAmount1;
    private TextView result;
    double results;
    ImageView money_bag;
    EditText addAmount2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAmount1 = (EditText) findViewById(R.id.first);
        money_bag = (ImageView) findViewById(R.id.moneyBag);
        addAmount2 = (EditText) findViewById(R.id.second);
        result = (TextView) findViewById(R.id.result);
        results =0;

    }
    public void show(View v) {// money bag appears 
        money_bag.animate().alpha(1).setDuration(50);
        result.setText("");

    }
    public void reset(View v){ // on click resets to empty
        addAmount2.setText("");
        addAmount1.setText("");
        show(v);
        result.setText("");
    }



    public boolean isDouble(String n){// to input only digits
        if (n == null)
            return false;
        else{
            try {
                Double num = Double.parseDouble(n);
            }catch (NumberFormatException e){
                return false;
            }

        }
        return true;
    }



    public void convertToLBP(View v) {// converts to lbp if digit

        String given = addAmount1.getText().toString();
        if (isDouble(given)) {
            double amount = Integer.parseInt(addAmount1.getText().toString());
            results = amount * 22000;
            String m = (String.format("%.2f",results)) ;
            money_bag.animate().alpha(0).setDuration(25);//shows the amount
            addAmount2.setText(m); //shows amount in lbp edit text
            result.setText(m); //shows under money bag
            addAmount1.setText("");

            Toast.makeText(getApplicationContext(), "successfully converted to lbp", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
        }

    }



    public void convertToDollars(View v){ //convert to dollars if digit
        String given = addAmount2.getText().toString();
        if (isDouble(given)) {
            double amount = Double.parseDouble(addAmount2.getText().toString());
            results = ((amount) / 22000);
            String m1 = (String.format("%.2f", results)) ;
            money_bag.animate().alpha(0).setDuration(25);
            addAmount1.setText(m1);
            addAmount2.setText("");
            result.setText(m1);


            Toast.makeText(getApplicationContext(), "successfully converted to $$", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
        }




    }








}