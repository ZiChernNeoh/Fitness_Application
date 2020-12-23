package com.example.fitnessapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button createaccount;
    Button forgetpassword;
    DatabaseHelper databaseHelper;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    String UsernameHolder;
    String TempPassword="NOT_FOUND";
    String PasswordHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.loginusername);
        password=findViewById(R.id.loginpassword);
        forgetpassword=findViewById(R.id.forgetpasswordbutton);
        createaccount=findViewById(R.id.createaccount);
        login=findViewById(R.id.loginbutton);
        databaseHelper=new DatabaseHelper(this);

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, forgot_password1.class);
                activity_login.this.startActivity(intent);
            }
        });

        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                activity_login.this.startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling EditText is empty or no method.
                activity_login.this.CheckEditTextStatus();
                // Calling login method.
                activity_login.this.LoginFunction();
            }
        });
    }

    public void  CheckEditTextStatus(){
        // Getting value from All EditText and storing into String Variables.
        UsernameHolder=username.getText().toString();
        PasswordHolder=password.getText().toString();
        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(UsernameHolder) || TextUtils.isEmpty(PasswordHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }

    public void LoginFunction(){
        if (EditTextEmptyHolder){
            // Opening SQLite database write permission
            sqLiteDatabase=databaseHelper.getWritableDatabase();
            // Adding search email query to cursor.
            cursor=sqLiteDatabase.query(databaseHelper.INFORMATION_TABLE, null, " "+ databaseHelper.COLUMN_USERNAME+"=?",
                    new String[]{UsernameHolder}, null, null, null);
            while (cursor.moveToNext()){
                if (cursor.isFirst()){
                    cursor.moveToFirst();
                    // Storing Password associated with entered username.
                    TempPassword=cursor.getString(cursor.getColumnIndex(databaseHelper.COLUMN_CONFIRM_PASSWORD));
                    // Closing cursor.
                    cursor.close();
                }
            }
            // Calling method to check final result.
            CheckFinalResult();
        }
        else{
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(activity_login.this, "Make sure all of the information are entered", Toast.LENGTH_SHORT).show();
        }
    }

    // Checking entered password from SQLite database username associated password.
    public void CheckFinalResult(){
        if (TempPassword.equalsIgnoreCase(PasswordHolder)){
            Intent intent=new Intent(activity_login.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Welcome back, "+UsernameHolder, Toast.LENGTH_SHORT ).show();
        }
        else{
            Toast.makeText(activity_login.this, "Invalid username or password. Try again.", Toast.LENGTH_SHORT).show();
        }
        TempPassword="NOT_FOUND";
    }
}
