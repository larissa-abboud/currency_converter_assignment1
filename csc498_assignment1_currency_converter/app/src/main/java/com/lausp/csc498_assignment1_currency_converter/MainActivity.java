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
    int amount;
    Button convertToLBP;
    Button convertToDollars;

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

        results =0;
        result = (TextView) findViewById(R.id.result);

    }
    public void reset(View v){
        addAmount2.setText("");
        addAmount1.setText("");


        show(v);
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

    public boolean isDouble(String n){
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


/** user inputs in dollar box, and presses dollar should show same amount
 * user input dollar an d preses the  lbp amount  should show  calculated amount
 * */
    // add button to specify if lbp or usd (boolean )
    public void convertToLBP(View v) {
        //boolean flag  ;
        String given = addAmount1.getText().toString();
        if (isInt(given)) {
            int amount = Integer.parseInt(addAmount1.getText().toString());
            results = amount * 22000;
            String m = (String.valueOf(results)) ;
            money_bag.animate().alpha(0).setDuration(25);
            addAmount2.setText(m);
            result.setText(m);
            addAmount1.setText("");
            Toast.makeText(getApplicationContext(), "successfully converted to lbp", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(), "invalid input", Toast.LENGTH_SHORT).show();
        }
        //
    }
    public void show(View v) {
        money_bag.animate().alpha(1).setDuration(50);
        result.setText("");

    }


    public void convertToDollars(View v){
        String given = addAmount2.getText().toString();
        if (isDouble(given)) {
            double amount = Double.parseDouble(addAmount2.getText().toString());
            results = ((amount) / 22000);
            String m1 = (String.format("%.2f", results)) ;
            money_bag.animate().alpha(0).setDuration(25);
            addAmount1.setText(m1);
            result.setText(m1);
            addAmount2.setText("");


            Toast.makeText(getApplicationContext(), "successfully converted to $$", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "invalid input", Toast.LENGTH_SHORT).show();
        }




    }
    /* add conditions
     * fix design
     * double usd only 2 decimals*/







}