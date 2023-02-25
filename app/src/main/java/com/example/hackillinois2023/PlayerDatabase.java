package com.example.hackillinois2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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

    public void addNewPlayer() {

    }
}
