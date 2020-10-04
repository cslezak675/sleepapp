package com.example.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertnessActivity extends Activity {
    public static String tired;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertness);

        Button tiredYes = (Button) findViewById(R.id.tired_yes);
        Button tiredNo = (Button) findViewById(R.id.tired_no);

        tiredYes.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                tired = "yes";
                Intent myIntent = new Intent(view.getContext(), NapActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        tiredNo.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                tired = "no";
                Intent myIntent = new Intent(view.getContext(), NapActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
