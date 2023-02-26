package com.example.hackillinois2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class GameActivity extends AppCompatActivity {
    /* Creates a global level variable to save which level the player's current level */
    public static String savedLevelNumber = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /* Sets the End Game Pop-up to initially be invisible */
        ConstraintLayout baseLayout = (ConstraintLayout) findViewById(R.id.activity_game);
        CardView end_game_card = (CardView) findViewById(R.id.end_game_cardview);
        end_game_card.setVisibility(View.GONE);

        /* Gets the saved level information from the Home Screen Activity */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String newLevelNumber = extras.getString("Level Number");
            savedLevelNumber = newLevelNumber;
            Log.i("TestOutput", newLevelNumber);
        }
    }

    /* Opens an Instructions Pop-on which closes on touch */
    @Override
    protected void onStart() {
        super.onStart();

        ConstraintLayout baseLayout = (ConstraintLayout) findViewById(R.id.activity_game);
        CardView start_instructions = (CardView) findViewById(R.id.start_instructions_cardview);

        /* When the Instructions Pop-Up is closed, start the game */
        baseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_instructions.setVisibility(View.GONE);
                startGame();
            }
        });
    }

    public void startGame() {
        final ScrollingImageView scrollingBackground = (ScrollingImageView) findViewById(R.id.scrolling_background);
        scrollingBackground.start();
    }

    /* Opens an End Game Pop-up that moves back to the Home Screen Activity when clicked */
    public void endGame() {
        ConstraintLayout baseLayout = (ConstraintLayout) findViewById(R.id.activity_game);
        CardView end_game_card = (CardView) findViewById(R.id.end_game_cardview);
        end_game_card.setVisibility(View.VISIBLE);

        baseLayout.setOnClickListener(new View.OnClickListener() {
            /* Starting Intent from OnClickListener:
               https://stackoverflow.com/questions/19464100/starting-intent-from-onclicklistener */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomeScreenActivity.class);
                intent.putExtra("Level Number", savedLevelNumber);
                startActivity(intent);
            }
        });
    }

    /* Development 3 Second Timer to test End Game Pop-Up */
    public void testTimer() {
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                /* EMPTY */
            }
            public void onFinish() {
                endGame();
            }
        }.start();
    }
}