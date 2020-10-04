package com.example.sleepapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NapActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nap);

        TextView recommendNap = (TextView) findViewById(R.id.recommend_nap);

        if (MainActivity.sleepTime == 5 || ((MainActivity.sleepTime == 6 || MainActivity.sleepTime == 7) && AlertnessActivity.tired == "yes")){
            recommendNap.setText("A nap of {Insert Time Here} is recommended");
        } else{
            recommendNap.setText("No nap is recommended");
        }
    }
}
