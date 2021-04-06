package com.example.android.a108590002_hw6_043;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String OrderMess;

    public static final String EXTRA_MESSAGE = "com.example.android.a108590002_hw5_041.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, OrderMess);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
        }
        return super.onOptionsItemSelected( item );
    }

    public void display(String message){
        Toast.makeText( getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void order_donut(View view){
        OrderMess = getString(R.string.donut_order);
        display( OrderMess );

    }

    public void order_ice_cream(View view){
        OrderMess = getString(R.string.ice_cream_order);
        display(OrderMess);
    }

    public void order_froyo(View view){
        OrderMess = getString(R.string.froyo_order);
        display( OrderMess );
    }

    public void shopping(View view){
        FloatingActionButton fab = findViewById( R.id.fab );
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, OrderActivity.class);
        intent.putExtra( EXTRA_MESSAGE, OrderMess );
        startActivity( intent );
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

}