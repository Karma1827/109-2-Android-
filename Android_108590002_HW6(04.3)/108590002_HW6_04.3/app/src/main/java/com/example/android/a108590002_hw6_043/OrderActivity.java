package com.example.android.a108590002_hw6_043;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order );
        Intent intent = getIntent();
        String orderMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textView);
        textView.setText(orderMessage);

        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter( adapter );
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onChecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.sameday));
                break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.nextday));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pickup));
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showDate(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String strMonth = Integer.toString(month+1);
        String strDay = Integer.toString(day);
        String strYear = Integer.toString(year);
        String dateMessage = (strMonth + "/" + strDay + "/" + strYear);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }
}