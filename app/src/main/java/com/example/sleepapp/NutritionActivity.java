package com.example.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class NutritionActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition);

        SearchView foodSearch = (SearchView) findViewById(R.id.food_search);
        Button addFood = (Button) findViewById(R.id.add_food);
        Button removeFood = (Button) findViewById(R.id.remove_food);
        Button foodNext = (Button) findViewById(R.id.food_next);

        foodNext.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Activity2.class);
                startActivityForResult(myIntent, 0);

            }});
    }
}
