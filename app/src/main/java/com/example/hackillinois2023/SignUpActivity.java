package com.example.hackillinois2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText emailEditText;
    EditText passwordEditText;
    PlayerDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        database = new PlayerDatabase(this, null, null, 1);

        usernameEditText = (EditText) findViewById(R.id.username_signup);
        emailEditText = (EditText) findViewById(R.id.email_signup);
        passwordEditText = (EditText) findViewById(R.id.password_signup);
    }

    public void signUpPlayerOnClick(View v) {
        try {
            String email = emailEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.equals("") || username.equals("") || password.equals("")) {
                throw new NullPointerException();
            }

            Player newPlayer = new Player(email, username, password);
            database.addNewPlayer(newPlayer);

            printTablePlayers();
            printTableGameData();

            Intent intent = new Intent(this, HomeScreenActivity.class);
            startActivity(intent);
        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(),"Please Fill in All Fields",Toast.LENGTH_SHORT).show();
        }
    }

    public void printTablePlayers() {
        String databaseString = database.viewTablePlayers();
        Log.i("DatabaseOutput", databaseString);
    }

    public void printTableGameData() {
        String databaseString = database.viewTableGameData();
        Log.i("DatabaseOutput", databaseString);
    }
}