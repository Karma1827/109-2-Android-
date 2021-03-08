package com.example.hw2;
git
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button karma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        karma = (Button) findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello Toast!",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mCount != 0)
            karma.setBackgroundColor(Color.MAGENTA);
        if((mCount % 2) == 0 ){
            view.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }else{
            view.setBackgroundColor(getResources().getColor(R.color.teal_200));
        }
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }

    public void onZero(View view) {
        mCount = 0;
        mShowCount.setText(Integer.toString(mCount));
        karma.setBackgroundColor(Color.GRAY);
    }
}