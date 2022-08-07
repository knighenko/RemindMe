package com.knyzhenko.remindme.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
   public final static int DATABASE_VERSION = 1;
   public final static String DATABASE_NAME = "terminDb";
   public final static String TABLE_TERMINS = "termins";
   public final static String KEY_ID = "id";
   public final static String KEY_TITLE = "title";
   public final static String KEY_DESCRIPTION = "description";
   public final static String KEY_CATEGORY = "category";
   public final static String KEY_IMPORTANCE = "importance";
   public final static String KEY_DATE = "date";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_TERMINS + " (" +
                KEY_ID + " INTEGER NOT NULL UNIQUE PRIMARY KEY, " +
                KEY_TITLE + " TEXT NOT NULL, " +
                KEY_DESCRIPTION + " TEXT, " +
                KEY_CATEGORY + " TEXT, " +
                KEY_IMPORTANCE + " INTEGER, " +
                KEY_DATE + " INTEGER NOT NULL" +
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
