package com.example.hackillinois2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
        Log.i("TestOutput", "Game Start!");
    }
}