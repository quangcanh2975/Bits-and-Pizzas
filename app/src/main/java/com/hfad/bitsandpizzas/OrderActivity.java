package com.hfad.bitsandpizzas;

import android.app.ActionBar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}