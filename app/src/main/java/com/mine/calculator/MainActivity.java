package com.mine.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner operated;
    EditText numberOne, numberTwo;
    TextView total;
    Button result;

    String[] operation = {"+", "/", "*", "-"};
    String opr;

    private View.OnClickListener listener = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            double firstNumber = Double.parseDouble( numberOne.getText().toString() );
            double secondNumber = Double.parseDouble( numberTwo.getText().toString() );
            double result;

            if(opr.equals( "-" )){
                result = firstNumber - secondNumber;
                total.setText( Double.toString( result ) );
            } else if(opr.equals( "+" )){
                result = firstNumber + secondNumber;
                total.setText( Double.toString( result ) );
            }else if(opr.equals( "/" )){
                result = firstNumber / secondNumber;
                total.setText( Double.toString( result ) );
            }else if(opr.equals( "*" )){
                result = firstNumber * secondNumber;
                total.setText( Double.toString( result ) );
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        operated = (Spinner) findViewById( R.id.spinner );
        result = (Button) findViewById( R.id.button );
        total = (TextView) findViewById( R.id.Result );

        numberOne = (EditText) findViewById( R.id.viewOne );
        numberTwo = (EditText) findViewById( R.id.viewTwo );

        result.setOnClickListener( listener );

        ArrayAdapter<String> adpt = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, operation );
        adpt.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        operated.setAdapter( adpt );
        operated.setOnItemSelectedListener( this );

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        opr = operation[position];
        Toast.makeText( this, "You Choose" + opr, Toast.LENGTH_LONG ).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText( this, "Please Choose Operation", Toast.LENGTH_LONG ).show();
    }
}