package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello TyphoonTail Debug");
        Log.i("MainActivity", "MainActivity layout is complete");
        Log.e("MainActivity", "Hello TyphoonTail Error");
        Log.w("MainActivity", "Hello TyphoonTail Warn");
    }
}