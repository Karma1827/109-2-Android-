package com.example.android.a108590002_hw7_045;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void pho(View view){
        Intent intent = new Intent(this, Pho.class);
        startActivity( intent );
    }

    public void com_tam(View view){
        Intent intent = new Intent(this, Com_tam.class);
        startActivity( intent );
    }

    public void goi_cuon(View view){
        Intent intent = new Intent(this, Goi_cuon.class);
        startActivity( intent );
    }
}