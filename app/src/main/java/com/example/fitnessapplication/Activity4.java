package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}