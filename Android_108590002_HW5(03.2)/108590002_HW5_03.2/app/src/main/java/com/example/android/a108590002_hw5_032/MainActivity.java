package com.example.android.a108590002_hw5_032;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";
    private Calculator cal;
    private EditText _op1;
    private EditText _op2;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        cal = new Calculator();
        _op1 = findViewById( R.id.operand1 );
        _op2 = findViewById( R.id.operand2 );
        textview = findViewById( R.id.textView );
    }
    private static String getOperandText(EditText opEditText){
        String opText = opEditText.getText().toString();
        if(TextUtils.isEmpty( opText )){
            throw new NumberFormatException("Opreand cannot be empty!");
        }
        return opText;
    }
    private static Double getOperand(EditText opEditText){
        String opText = getOperandText( opEditText );
        return Double.valueOf( opText );
    }

    public void compute(Calculator.Operator operator){
        double op1;
        double op2;
        try{
            op1 = getOperand( _op1 );
            op2 = getOperand( _op2 );
        }catch(NumberFormatException nfe){
            Log.e(TAG,"NumberFormatException", nfe);
            textview.setText( "Error" );
            return;
        }

        String result;
        switch(operator){
            case ADD:
                result = String.valueOf( cal.add(op1, op2) );
                break;

            case SUB:
                result = String.valueOf( cal.sub(op1, op2) );
                break;

            case MUL:
                result = String.valueOf( cal.mul(op1, op2) );
                break;

            case DIV:
                result = String.valueOf( cal.div(op1, op2) );
                break;

            case POW:
                result = String.valueOf( cal.pow(op1, op2) );
                break;
            default:
                result = "Error";
                break;
        }
        textview.setText( result );
    }

    public void clickAdd(View view){compute(Calculator.Operator.ADD);}

    public void clickSub(View view){compute(Calculator.Operator.SUB);}

    public void clickMul(View view){compute(Calculator.Operator.MUL);}

    public void clickDiv(View view){
        try{
            compute( Calculator.Operator.DIV );
        }catch (IllegalArgumentException iae){
            Log.e(TAG, "IllegalAccessException", iae);
            textview.setText( "Error" );
        }
    }

    public void clickPow(View view){compute(Calculator.Operator.POW);}
}