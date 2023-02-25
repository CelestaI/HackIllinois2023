package com.example.hackillinois2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StoreActivity extends AppCompatActivity {
    /* Creates a global level variable to save which level the player's current level */
    public static String savedLevelNumber = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        /* Gets the saved level information from the Home Screen Activity */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String newLevelNumber = extras.getString("Level Number");
            savedLevelNumber = newLevelNumber;
        }
    }

    /* Moves back to the Home Screen Activity */
    public void backOnClick(View v){
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("Level Number", savedLevelNumber);
        startActivity(intent);
    }
}