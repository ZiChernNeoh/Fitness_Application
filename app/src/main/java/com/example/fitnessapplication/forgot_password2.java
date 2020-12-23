package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forgot_password2 extends AppCompatActivity {

    Button next;
    EditText fppassword;
    EditText fpconfirmpassword;
    DatabaseHelper databaseHelper;
    String email;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password2);
        next=findViewById(R.id.changepassword);
        fppassword=findViewById(R.id.fppassword);
        fpconfirmpassword=findViewById(R.id.fpconfirmpassword);
        databaseHelper=new DatabaseHelper(this);
        Intent intent=getIntent();
        email=intent.getStringExtra("EMAIL");
        username=intent.getStringExtra("USERNAME");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgot_password2.this.updatePassword();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void updatePassword(){
        String password=fppassword.getText().toString().trim();
        String confirmpassword=fpconfirmpassword.getText().toString().trim();
        if (password.isEmpty() || confirmpassword.isEmpty()){
            Toast.makeText(this, "Make sure all information are entered", Toast.LENGTH_SHORT).show();
        }
        else if (!password.contentEquals(confirmpassword)){
            Toast.makeText(this, "Password are not matching", Toast.LENGTH_SHORT).show();
        }
        else {
            databaseHelper.resetpassword(username, email, password, confirmpassword);
            Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(forgot_password2.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
