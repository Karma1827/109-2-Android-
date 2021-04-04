package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Comment(View view) {
        nextPage = (Button)findViewById(R.id.button_comment);
        Intent intent = new Intent();
        intent.setClass(MainActivity.this  , HW3_page2.class);
        startActivity(intent);
    }
}