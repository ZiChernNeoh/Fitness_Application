package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_register extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    EditText confirmpassword;
    CheckBox checkBox;
    Button next;
    Boolean checkemailexist;
    Boolean checkusernameexist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.registerusername);
        email=findViewById(R.id.registeremail);
        password=findViewById(R.id.registerpassword);
        confirmpassword=findViewById(R.id.registerconfirmpassword);
        checkBox=findViewById(R.id.checkBox);
        next=findViewById(R.id.continuebutton1);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this, term_of_service.class);
                activity_register.this.startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper=new DatabaseHelper(activity_register.this);
                Model model;
                model = new Model(-1, username.getText().toString(), email.getText().toString(), password.getText().toString(), confirmpassword.getText().toString(), checkBox.isChecked());
                checkemailexist=databaseHelper.isEmailExist(email.getText().toString());
                checkusernameexist=databaseHelper.isUsernameExist(username.getText().toString());
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) ||
                        TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(confirmpassword.getText().toString())) {
                    Toast.makeText(activity_register.this, "Make sure all of the information are entered correctly", Toast.LENGTH_SHORT).show();
                }
                else if (checkemailexist==true){
                    Toast.makeText(activity_register.this, "This email already exist. Please use a different email.", Toast.LENGTH_SHORT).show();
                }
                else if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
                    Toast.makeText(activity_register.this, "Password does not match.", Toast.LENGTH_SHORT).show();
                }
                else if (checkusernameexist==true){
                    Toast.makeText(activity_register.this, "This username already exist. Please use a different username.", Toast.LENGTH_SHORT).show();
                }
                else if (checkBox.isChecked()) {
                    DatabaseHelper databaseHelper1 = new DatabaseHelper(activity_register.this);
                    databaseHelper1.addOne(model);
                    Intent intent = new Intent(activity_register.this, MainActivity.class);
                    activity_register.this.startActivity(intent);
                    activity_register.this.getIntent();
                    Toast.makeText(activity_register.this, "Account registered successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(activity_register.this, "Please tick the checkbox", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
