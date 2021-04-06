package com.example.android.a108590002_hw6_042;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private CheckBox chocolate_syrup;
    private CheckBox sprinkles;
    private CheckBox crushed_nuts;
    private CheckBox cherries;
    private CheckBox orio_cookie_crumbles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        chocolate_syrup = findViewById( R.id.Chocolate_syrup );
        sprinkles = findViewById( R.id.Sprinkles );
        crushed_nuts = findViewById( R.id.Crushed_nuts );
        cherries = findViewById( R.id.Cherries );
        orio_cookie_crumbles = findViewById( R.id.Orio_cookie_crumbles );
    }

    public void showToast(View view){
        String toast = "Topping: ";
        if(chocolate_syrup.isChecked()){
            toast += "Chocolate syrup ";
        }

        if(sprinkles.isChecked()){
            toast += "Sprinkles ";
        }

        if(crushed_nuts.isChecked()){
            toast += "Crushed nuts ";
        }

        if(cherries.isChecked()){
            toast += "Cherries ";
        }

        if(orio_cookie_crumbles.isChecked()){
            toast += "Orio cookie crumbles ";
        }

        if (!(chocolate_syrup.isChecked()) && !(sprinkles.isChecked()) && !(crushed_nuts.isChecked()) && !(cherries.isChecked()) && !(orio_cookie_crumbles.isChecked())) {
            toast += "nothing";
        }

        toast += ".";

        Toast.makeText( this, toast, Toast.LENGTH_LONG ).show();
    }
}