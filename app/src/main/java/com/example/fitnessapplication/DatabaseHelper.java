package com.example.fitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String INFORMATION_TABLE = "INFORMATION_TABLE";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_CHECKBOX = "CHECKBOX";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CONFIRM_PASSWORD = "COLUMN_CONFIRM_PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "information.db", null, 1);
    }

    //This is called the first time a database is accessed.
    //There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + INFORMATION_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " + COLUMN_CONFIRM_PASSWORD +
                ", TEXT" + COLUMN_CHECKBOX + " BOOL)";
        db.execSQL(createTableStatement);
    }

    //This is called if the database version number changes.
    //It prevents previous users apps from break when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Add an account to database from Register Page
    public boolean addOne(Model model){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_USERNAME, model.getUsername());
        cv.put(COLUMN_EMAIL, model.getEmail());
        cv.put(COLUMN_PASSWORD, model.getPassword());
        cv.put(COLUMN_CONFIRM_PASSWORD, model.getConfirmpassword());
        long insert = db.insert(INFORMATION_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else {
            return  true;
        }
    }

    //Reset password
    public void resetpassword(String username, String email, String password, String confirmpassword){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_CONFIRM_PASSWORD, confirmpassword);
        db.update(INFORMATION_TABLE, values, COLUMN_USERNAME+"=?", new String[]{username});
        db.update(INFORMATION_TABLE, values, COLUMN_EMAIL+"=?", new String[]{email});
        db.close();
    }

    public boolean isEmailExist(String email){
        String query = "SELECT * FROM " + INFORMATION_TABLE + " WHERE " + COLUMN_EMAIL + " = ?";
        String[] whereArgs = {email};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, whereArgs);
        int count = cursor.getCount();
        cursor.close();
        return count >= 1;
    }

    public boolean isUsernameExist(String username){
        String query = "SELECT * FROM " + INFORMATION_TABLE + " WHERE " + COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, whereArgs);
        int count = cursor.getCount();
        cursor.close();
        return count >= 1;
    }
}
