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

public class forgot_password1 extends AppCompatActivity {

    Button next;
    EditText fpemail;
    EditText fpusername;
    String EmailHolder;
    String UsernameHolder;
    String TempEmail="NOT_FOUND";
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password1);
        next=findViewById(R.id.continuebutton2);
        fpemail=findViewById(R.id.fpemail);
        fpusername=findViewById(R.id.fpusername);
        databaseHelper=new DatabaseHelper(this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling EditText is empty or no method.
                forgot_password1.this.CheckEditTextStatus();
                // Calling next method.
                forgot_password1.this.nextFunction();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void CheckEditTextStatus(){
        // Getting value from All EditText and storing into String Variables.
        EmailHolder=fpemail.getText().toString();
        UsernameHolder=fpusername.getText().toString();
        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(UsernameHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }

    public void nextFunction(){
        if (EditTextEmptyHolder){
            // Opening SQLite database write permission
            sqLiteDatabase=databaseHelper.getWritableDatabase();
            // Adding search email query to cursor.
            cursor=sqLiteDatabase.query(databaseHelper.INFORMATION_TABLE, null, " "+ databaseHelper.COLUMN_USERNAME+"=?",
                    new String[]{UsernameHolder}, null, null, null);
            while (cursor.moveToNext()){
                if (cursor.isFirst()){
                    cursor.moveToFirst();
                    // Storing email associated with entered email.
                    TempEmail=cursor.getString(cursor.getColumnIndex(databaseHelper.COLUMN_EMAIL));
                    // Closing cursor.
                    cursor.close();
                }
            }
            // Calling method to check final result.
            CheckFinalResult();
        }
        else{
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(forgot_password1.this, "Make sure all of the information are entered", Toast.LENGTH_SHORT).show();
        }
    }

    // Checking entered email from SQLite database username associated email.
    public void CheckFinalResult(){
        if (TempEmail.equalsIgnoreCase(EmailHolder)){
            Intent intent=new Intent(forgot_password1.this, forgot_password2.class);
            intent.putExtra("EMAIL", fpemail.getText().toString().trim());
            intent.putExtra("USERNAME", fpusername.getText().toString().trim());
            startActivity(intent);
        }
        else{
            Toast.makeText(forgot_password1.this, "Invalid username or email. Try again.", Toast.LENGTH_SHORT).show();
        }
        TempEmail="NOT_FOUND";
    }

    public void emptyInputEditText(){
        fpemail.setText("");
    }
}
