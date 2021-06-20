package com.android.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LifeCycleActivity";

    EditText edtWindowOutput;

    String operation = "";

    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find elements activity_main
        EditText edtWindowOutput = (EditText) findViewById(R.id.windowOutput);

        Button btnOne = (Button) findViewById(R.id.button_One);
        Button btnTwo = (Button) findViewById(R.id.button_Two);
        Button btnThree = (Button) findViewById(R.id.button_Three);
        Button btnFour = (Button) findViewById(R.id.button_Four);
        Button btnFive = (Button) findViewById(R.id.button_Five);
        Button btnSix = (Button) findViewById(R.id.button_Six);
        Button btnSeven = (Button) findViewById(R.id.button_Seven);
        Button btnEight = (Button) findViewById(R.id.button_Eight);
        Button btnNine = (Button) findViewById(R.id.button_Nine);
        Button btnNull = (Button) findViewById(R.id.button_Null);
        Button btnPoint = (Button) findViewById(R.id.button_Point);
        Button btnSum = (Button) findViewById(R.id.button_Sum);
        Button btnRazn = (Button) findViewById(R.id.button_Razn);
        Button btnDiv = (Button) findViewById(R.id.button_Div);
        Button btnPow = (Button) findViewById(R.id.button_Pow);
        Button btnEquals = (Button) findViewById(R.id.button_Equals);
        Button btnPersent = (Button) findViewById(R.id.button_Persent);
        Button btnClear = (Button) findViewById(R.id.button_Clear);
        Button btnClearOneSymbol = (Button) findViewById(R.id.button_ClearOneSymbol);

        ////button handler
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnNull.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnRazn.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPersent.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearOneSymbol.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart");
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy");
    }

    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }

    @Override
    public void onClick(View v) {
        int number1 = 0;
        int number2 = 0;
        int result = 0;

        if (TextUtils.isEmpty(edtWindowOutput.getText().toString()))
            return;

        number1 = Integer.parseInt(edtWindowOutput.getText().toString());

        switch (v.getId()){
            case R.id.button_Sum:
                operation = "+";
                result = number1 + number2;
                break;
            case R.id.button_Razn:
                operation = "-";
                result = number1 - number2;
                break;
            case R.id.button_Div:
                operation = "/";
                result = number1 / number2;
                break;
            case R.id.button_Pow:
                operation = "*";
                result = number1 * number2;
                break;
            default:
                break;
        }

        result.setText(number1 + " " + operation + " " + number2 + " = " + result);

    }
}