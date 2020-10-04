package com.example.sleepapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    public static LocalTime next_event_time;
    public static int sleepTime;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView nextEvent = (TextView) findViewById(R.id.editTextTime);
        final TextView seeNextEvent = (TextView) findViewById(R.id.next_event_id);
        Button sleepSix = (Button) findViewById(R.id.button2);
        Button sleepSeven = (Button) findViewById(R.id.button3);
        Button sleepEight = (Button) findViewById(R.id.button4);
        nextEvent.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String totalTime = v.getText().toString();
                if (totalTime.length() == 3){
                    totalTime = "0"+totalTime.substring(0,1)+":"+totalTime.substring(1);
                } else if (totalTime.length() == 4){
                    totalTime = totalTime.substring(0,2)+":"+totalTime.substring(2);
                }
                if (Integer.parseInt(totalTime.substring(0,2)) > 23 || Integer.parseInt(totalTime.substring(3)) > 59){
                    totalTime = "00:00";
                }
                if (totalTime.contains(":")){
                    next_event_time = LocalTime.parse(totalTime);
                }
                seeNextEvent.setText("The next event is at " + next_event_time.toString());

                return true;
            }
        }
        );

        Button sleepFive = (Button) findViewById(R.id.button);
        sleepFive.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                sleepTime = 5;
                Intent myIntent = new Intent(view.getContext(), FlightActivity.class);
                startActivityForResult(myIntent,0);
            }
        });

        sleepSix.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                sleepTime = 6;
                Intent myIntent = new Intent(view.getContext(), FlightActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        sleepSeven.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                sleepTime = 7;
                Intent myIntent = new Intent(view.getContext(), FlightActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        sleepEight.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                sleepTime = 8;
                Intent myIntent = new Intent(view.getContext(), FlightActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}