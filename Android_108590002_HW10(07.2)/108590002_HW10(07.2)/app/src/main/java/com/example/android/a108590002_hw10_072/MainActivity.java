package com.example.android.a108590002_hw10_072;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView textView;
    private Spinner spinner;
    private String header;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.titleText);
        spinner = (Spinner)findViewById(R.id.spinner);
        editText = (EditText)findViewById(R.id.bookInput);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.http_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(spnOnItemSelected);
        getSupportLoaderManager().initLoader(0, null, this);
    }

    private AdapterView.OnItemSelectedListener spnOnItemSelected = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(getApplicationContext(), parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
            header = parent.getItemAtPosition(pos).toString();
        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new BookLoader(this, header+editText.getText().toString());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        textView.setText(s);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
    }

    public void searchBooks(View view){
        Bundle queryBundle = new Bundle();
        queryBundle.putString("queryString", header+editText.getText().toString());
        getSupportLoaderManager().restartLoader(0, queryBundle, this);
    }

    public static class instreamTOstr {
        public static String readStream(InputStream in) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            in.close();
            String content = new String(baos.toByteArray());
            return content;
        }
    }
}