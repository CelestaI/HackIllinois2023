package com.example.hackillinois2023;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // loading Animation from
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // getting the Button from activity_main.xml file
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start the animation
                button.startAnimation(animation);
            }
        });
    }
}

    // loading Animation from
    final Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide);

    // getting the Button from activity_main.xml file
    final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        // start the animation
        button.startAnimation(animation);
        }
        });
        }
        }
// loading Animation from
final Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);

// getting the Button from activity_main.xml file
final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        // start the animation
        button.startAnimation(animation);
        }
        });
        }
        }
// loading Animation from
final Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);

// getting the Button from activity_main.xml file
final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        // start the animation
        button.startAnimation(animation);
        }
        });
        }
        }
