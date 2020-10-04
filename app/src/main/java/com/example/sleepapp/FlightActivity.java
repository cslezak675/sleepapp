package com.example.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FlightActivity extends Activity {
    public static String airport;
    public static Integer flight;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flying);

        final TextView airportText = (TextView) findViewById(R.id.textView8);
        final TextView flightText = (TextView) findViewById(R.id.textView9);
        final TextView airportEntry = (TextView) findViewById(R.id.airport_entry);
        final TextView flightEntry = (TextView) findViewById(R.id.flight_entry);
        final TextView flightError = (TextView) findViewById(R.id.flight_error);
        final Button next = (Button) findViewById(R.id.button11);
        Button yes = (Button) findViewById(R.id.button9);
        Button no = (Button) findViewById(R.id.button10);



        yes.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                airportText.setVisibility(View.VISIBLE);
                flightText.setVisibility(View.VISIBLE);
                airportEntry.setVisibility(View.VISIBLE);
                flightEntry.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
            }
        });

        no.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent(view.getContext(), ExcerciseActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        next.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                if (airportEntry.getText().toString().length() > 0 && flightEntry.getText().toString().length() > 0){
                    airport = airportEntry.getText().toString();
                    flight = Integer.parseInt(flightEntry.getText().toString());
                    Intent myIntent = new Intent(view.getContext(), ExcerciseActivity.class);
                    startActivityForResult(myIntent, 0);
                } else {
                    flightError.setVisibility(View.VISIBLE);
                    flightError.setText("Please enter your destination airport and flight number above.");
                }

            }
        });
    }
}
