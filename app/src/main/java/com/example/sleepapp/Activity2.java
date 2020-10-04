package com.example.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.Arrays;

public class Activity2 extends Activity {
    public String[] addToArray(String[] array, String string){
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = string;
            return array;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        final TextView enterMeds = (TextView) findViewById(R.id.medications_entry);
        final TextView medsList = (TextView) findViewById(R.id.medications_list);
        final Button done = (Button) findViewById(R.id.button7);
        final Button yes = (Button) findViewById(R.id.button5);
        final Button no = (Button) findViewById(R.id.button6);
        enterMeds.setVisibility(View.INVISIBLE);
        done.setVisibility(View.INVISIBLE);

        yes.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                enterMeds.setVisibility(View.VISIBLE);
                done.setVisibility(View.VISIBLE);
            }
        });

        enterMeds.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String medications = medsList.getText().toString();
                medications += "\n";
                medications += v.getText();
                v.setText("");

                medsList.setText(medications);
                return true;
            }
        });

        no.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AlertnessActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        done.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AlertnessActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }
}
