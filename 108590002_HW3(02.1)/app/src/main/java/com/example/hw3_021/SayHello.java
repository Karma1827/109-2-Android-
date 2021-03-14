package com.example.hw3_021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SayHello extends AppCompatActivity {
    private TextView SAYHELLO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello);
        SAYHELLO = (TextView) findViewById(R.id.textView2);
        Bundle recieve = getIntent().getExtras();
        Integer recieve_count = recieve.getInt("number");
        if(SAYHELLO != null)
            SAYHELLO.setText(Integer.toString(recieve_count));
    }

}