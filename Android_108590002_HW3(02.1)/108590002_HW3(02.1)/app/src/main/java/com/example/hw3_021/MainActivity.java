package com.example.hw3_021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int Count = 0;
    private TextView showCount;
    private Button sayHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView) findViewById(R.id.show_count);
    }

    public void countUp(View view){
        Count++;
        if(showCount != null){
            showCount.setText(Integer.toString(Count));
        }
    }

    public void SayHello(View view) {
        sayHello = (Button)findViewById(R.id.button_label_sayhello);
        Intent intent = new Intent();
        intent.setClass(this , SayHello.class);
        Bundle say_hello = new Bundle();
        say_hello.putInt("number", Count);
        intent.putExtras(say_hello);
        startActivity(intent);
    }
}