package com.example.hackillinois2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        /* Updates the player's current level so it isn't always reset to Level 1 */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String newLevelNumber = extras.getString("Level Number");
            Log.i("TestOutput", newLevelNumber);
            TextView levelSelector = (TextView) findViewById(R.id.levelNumber);
            levelSelector.setText(newLevelNumber);
        }
    }

    /* Increases the current level */
    /* TODO: Add a level cap based on how many levels a user has cleared */
    public void nextLevelOnClick(View v) {
        TextView levelSelector = (TextView) findViewById(R.id.levelNumber);
        String currentLevel = levelSelector.getText().toString();
        int levelNumber = Integer.parseInt(currentLevel);
        int newLevel = levelNumber + 1;
        levelSelector.setText(Integer.toString(newLevel));
    }

    /* Decreases the current level down to a minimum of Level 1 */
    public void prevLevelOnClick(View v) {
        TextView levelSelector = (TextView) findViewById(R.id.levelNumber);
        String currentLevel = levelSelector.getText().toString();
        int levelNumber = Integer.parseInt(currentLevel);
        int newLevel = levelNumber - 1;
        if (newLevel <= 0) {
            newLevel = 1;
        }
        levelSelector.setText(Integer.toString(newLevel));
    }

    /* Moves to the Store Page Activity */
    public void storeOnClick(View v){
        TextView levelNumberTextView = (TextView) findViewById(R.id.levelNumber);
        Intent intent = new Intent(this, StoreActivity.class);
        intent.putExtra("Level Number", levelNumberTextView.getText().toString());
        startActivity(intent);
    }

    /* Logs the Player out and moves back to the login screen */
    public void logoutOnClick(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /* Moves to the Game Page Activity */
    public void playOnClick(View v){
        TextView levelNumberTextView = (TextView) findViewById(R.id.levelNumber);
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("Level Number", levelNumberTextView.getText().toString());
        startActivity(intent);
    }

    /* Opens the Settings Pop-on */
    public void settingsOnClick(View v){
        ConstraintLayout baseLayout = (ConstraintLayout) findViewById(R.id.activity_home_screen);
        LayoutInflater inflater = getLayoutInflater();
        View settingsLayout = inflater.inflate(R.layout.settings_popup, baseLayout, false);
        baseLayout.addView(settingsLayout);

        /* Hides all buttons on the Game Page Activity */
        View settingsButton = findViewById(R.id.settingsButton);
        View storeButton = findViewById(R.id.storeButton);
        View prevLevelButton = findViewById(R.id.prevLevelButton);
        View nextLevelButton = findViewById(R.id.nextLevelButton);
        View playButton = findViewById(R.id.playButton);
        View logoutButton = findViewById(R.id.logoutButton);

        settingsButton.setVisibility(View.GONE);
        storeButton.setVisibility(View.GONE);
        prevLevelButton.setVisibility(View.GONE);
        nextLevelButton.setVisibility(View.GONE);
        playButton.setVisibility(View.GONE);
        logoutButton.setVisibility(View.GONE);

        /* Closes the Settings Pop-up and makes all buttons on the Game Page Activity visible */
        baseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseLayout.removeView(settingsLayout);

                settingsButton.setVisibility(View.VISIBLE);
                storeButton.setVisibility(View.VISIBLE);
                prevLevelButton.setVisibility(View.VISIBLE);
                nextLevelButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.VISIBLE);
                logoutButton.setVisibility(View.VISIBLE);
            }
        });
    }
}