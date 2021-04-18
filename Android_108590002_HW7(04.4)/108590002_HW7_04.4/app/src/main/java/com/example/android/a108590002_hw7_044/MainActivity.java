package com.example.android.a108590002_hw7_044;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private String OrderMess;
    public static final String EXTRA_MESSAGE = "com.example.android.a108590002_hw7_044.MESSAGE";
    private View order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void orderDonut(View view){
        order = findViewById( R.id.donut );
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Order_donut.class);
        intent.putExtra( EXTRA_MESSAGE, OrderMess );
        startActivity( intent );
    }

    public void orderFroyo(View view){
        order = findViewById( R.id.froyo );
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Order_froyo.class);
        intent.putExtra( EXTRA_MESSAGE, OrderMess );
        startActivity( intent );
    }

    public void orderIcecream(View view){
        order = findViewById( R.id.icecream );
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Order_ice_cream.class);
        intent.putExtra( EXTRA_MESSAGE, OrderMess );
        startActivity( intent );
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }
}