package com.example.a108590002_hw4_022;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int mCount;
    private TextView mShowCount;
    private EditText editText;
    private static final String EDIT_TEXT_KEY = "com.example.a108590002_hw4_022_EDIT_TEXT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount =(TextView) findViewById(R.id.show_count);
        editText = findViewById(R.id.editText);
    }

    public void CountUp(View view){
        mCount ++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        editText.setText(savedInstanceState.getString(EDIT_TEXT_KEY));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(EDIT_TEXT_KEY, editText.getText().toString());
        super.onSaveInstanceState(outState);
    }
}