package com.example.sleepapp;

import androidx.annotation.NonNull;
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
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static LocalTime next_event_time;
    public static int selected_year;
    public static int selected_month;
    public static int selected_day;
    public static int sleepTime;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sleepSix = (Button) findViewById(R.id.button2);
        Button sleepSeven = (Button) findViewById(R.id.button3);
        Button sleepEight = (Button) findViewById(R.id.button4);
        Button sleepFive = (Button) findViewById(R.id.button);
        Button timeNext = (Button) findViewById(R.id.event_next);
        final TextView timeEntry = (TextView) findViewById(R.id.event_time);
        final CalendarView calendar = (CalendarView) findViewById(R.id.event_date);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selected_year = year;
                selected_day = dayOfMonth;
                selected_month = month;
            }
        });
        timeNext.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(calendar.getVisibility() == View.VISIBLE){
                    calendar.setVisibility(View.INVISIBLE);
                    timeEntry.setVisibility(View.VISIBLE);
                } else{
                    String time = timeEntry.getText().toString();
                    if(time.length() == 3 && Integer.parseInt(time.substring(1)) <= 59){
                        time = time.substring(0,1)+":"+time.substring(1);
                    }
                    calendar.setVisibility(View.VISIBLE);
                    timeEntry.setVisibility(View.INVISIBLE);
                }

            }
        });
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