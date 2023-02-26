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

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    PlayerDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = new PlayerDatabase(this, null, null, 1);
        printTablePlayers();
        printTableGameData();

        usernameEditText = (EditText) findViewById(R.id.username_login);
        passwordEditText = (EditText) findViewById(R.id.password_login);
    }

    public void loginOnClick(View v) {
        try {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.equals("") || password.equals("")) {
                throw new NullPointerException();
            }

            boolean isLoginValid = database.checkLoginInfo(username, password);

            if (isLoginValid) {
                Intent intent = new Intent(this, HomeScreenActivity.class);
                startActivity(intent);
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(), "Please Fill in All Fields", Toast.LENGTH_SHORT).show();
        } catch (ArrayIndexOutOfBoundsException e) {
            Toast.makeText(getApplicationContext(), "Username or Password Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void signUpOnClick(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
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