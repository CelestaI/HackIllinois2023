package com.example.hackillinois2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PlayerDatabase extends SQLiteOpenHelper{
    /* Defines Database Name and Version */
    private static final String DATABASE_NAME = "players.db";
    private static final int DATABASE_VERSION = 1;

    /* Defines a Player Info Table in the Database */
    public static final String TABLE_PLAYERS = "players";
    public static final String COLUMN_ID_INFO = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD_HASH = "password_hash";

    /* Defines a Player Game Data Table in the Database */
    public static final String TABLE_GAME_DATA = "game_data";
    public static final String COLUMN_ID_DATA = "id";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_COINS = "coins";

    /* Basic Database Constructor */
    public PlayerDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String createInfoTable = "CREATE TABLE " + TABLE_PLAYERS + " (" + COLUMN_ID_INFO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_EMAIL + " VARCHAR(64) NOT NULL, " + COLUMN_USERNAME + " VARCHAR(32) NOT NULL, " + COLUMN_PASSWORD_HASH + " VARCHAR(64) NOT NULL);";
        String createGameDataTable = "CREATE TABLE " + TABLE_GAME_DATA + " (" + COLUMN_ID_DATA + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_LEVEL + " INTEGER NOT NULL, " + COLUMN_COINS + " INTEGER NOT NULL);";

        database.execSQL(createInfoTable);
        database.execSQL(createGameDataTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String dropInfoTable = "DROP TABLE IF EXISTS " + TABLE_PLAYERS;
        String dropGameDataTable = "DROP TABLE IF EXISTS " + TABLE_GAME_DATA;

        database.execSQL(dropInfoTable);
        database.execSQL(dropGameDataTable);

        onCreate(database);
    }

    public void addNewPlayer(Player player) {
        SQLiteDatabase database = getWritableDatabase();

        String queryTablePlayers = "INSERT INTO players(email, username, password_hash) VALUES ('" + player.getEmail() + "', '" + player.getUsername() +
                "', '" + player.getPasswordHash() + "');";
        String queryTableGameData = "INSERT INTO game_data(level, coins) VALUES (0, 0);";

        database.execSQL(queryTablePlayers);
        database.execSQL(queryTableGameData);
        database.close();
    }

    public boolean checkLoginInfo(String username, String password) {
        SQLiteDatabase database = getWritableDatabase();
        String password_hash = md5(password);
        String [] output = new String[] {username, password_hash};

        String loginValidation = "SELECT id, username FROM players WHERE username = ? AND password_hash = ?";
        Cursor c = database.rawQuery(loginValidation, output);

        if (!c.moveToFirst()) {
            database.close();
            return false;
        } else {
            database.close();
            return true;
        }
    }

    public String viewTablePlayers() {
        String databaseOutput = "";
        SQLiteDatabase database = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PLAYERS + " WHERE 1";
        // This means to select all from the database

        // The cursor will extract the entries from the database
        Cursor c = database.rawQuery(query, null);

        // Move the cursor to the first position and then move through the db to the last
        c.moveToFirst();
        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndexOrThrow(COLUMN_ID_INFO)) != null) {
                databaseOutput += c.getString(c.getColumnIndexOrThrow(COLUMN_EMAIL)) + ", ";
                databaseOutput += c.getString(c.getColumnIndexOrThrow(COLUMN_USERNAME)) + ", ";
                databaseOutput += c.getString(c.getColumnIndexOrThrow(COLUMN_PASSWORD_HASH));
                databaseOutput += "\n";
            }
            c.moveToNext();
        }

        database.close();
        return databaseOutput;
    }

    public String viewTableGameData() {
        String databaseOutput = "";
        SQLiteDatabase database = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_GAME_DATA + " WHERE 1";
        // This means to select all from the database

        // The cursor will extract the entries from the database
        Cursor c = database.rawQuery(query, null);

        // Move the cursor to the first position and then move through the db to the last
        c.moveToFirst();
        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndexOrThrow(COLUMN_ID_DATA)) != null) {
                databaseOutput += c.getString(c.getColumnIndexOrThrow(COLUMN_LEVEL)) + ", ";
                databaseOutput += c.getString(c.getColumnIndexOrThrow(COLUMN_COINS));
                databaseOutput += "\n";
            }
            c.moveToNext();
        }

        database.close();
        return databaseOutput;
    }

    /* Algorithm obtained from https://mobikul.com/converting-string-md5-hashes-android/ */
    public String md5(String s) {
        try {
            /* Create MD5 Hash */
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            /* Create Hex String */
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
