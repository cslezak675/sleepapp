package com.example.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalTime;

public class ExcerciseActivity extends Activity {
    public static String exerciseType;
    public static String exerciseTime;
    public static String exerciseMass;

    public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.excercise);

            final Spinner exerciseType = (Spinner) findViewById(R.id.exercise_spinner);
            final TextView exerciseTime = (TextView) findViewById(R.id.exercise_time);
            final TextView exerciseMass = (TextView) findViewById(R.id.exercise_mass);
            final TextView exerciseError = (TextView) findViewById(R.id.exercise_error);
            Button exerciseNext = (Button) findViewById(R.id.exercise_next);

        exerciseNext.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(exerciseTime.getText().length() > 0 && exerciseMass.getText().length() > 0){
                    Intent myIntent = new Intent(v.getContext(), NutritionActivity.class);
                    startActivityForResult(myIntent, 0);
                } else{
                    exerciseError.setVisibility(View.VISIBLE);
                    exerciseError.setText("Please enter a valid exercise time and weight into the appropriate boxes.");
                }
            }
        });


    }
}
