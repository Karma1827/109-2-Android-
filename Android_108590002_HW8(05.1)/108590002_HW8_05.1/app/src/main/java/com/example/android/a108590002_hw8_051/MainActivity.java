package com.example.android.a108590002_hw8_051;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView battery;
    private int batteryLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        battery = findViewById( R.id.imageView );
        battery.setImageLevel( batteryLevel );
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void changeLevel(View view){
        switch (view.getId()){
            case R.id.descrease:
                if(batteryLevel > 0){
                    batteryLevel --;
                    battery.setImageLevel( batteryLevel );
                    displayToast( "" + batteryLevel + "0%" );
                }
                break;
            case R.id.increase:
                if(batteryLevel < 10){
                    batteryLevel++;
                    battery.setImageLevel( batteryLevel );
                    displayToast( "" + batteryLevel + "0%");
                }
                break;
        }
    }
}