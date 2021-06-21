package com.android.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView calcDisplay;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnNull;
    private Button btnPoint;
    private Button btnSum;
    private Button btnRazn;
    private Button btnDiv;
    private Button btnPow;
    private Button btnEquals;
    private Button btnPersent;
    private Button btnClear;
    private Button btnClearOneSymbol;

    private float first_value;
    private char operation;
    private String str_numb;

    private static final String Key = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        ////обработка нажатий
        calcDisplay.setOnClickListener(this);

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

    public void initialization() {
        //получение пользовательских элементов по идентификатору
        calcDisplay = (TextView) findViewById(R.id.calcDisplay);
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
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Bundle instanceState = null;
        instanceState.putString(Key, calcDisplay.getText().toString());
        instanceState.putParcelable(Key, (Parcelable) calcDisplay);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Bundle instanceState = null;
        instanceState.putString(Key, calcDisplay.getText().toString());
        instanceState.putParcelable(Key, (Parcelable) calcDisplay);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_One:
                first_value = 1;
                addNumber((int) first_value);
                break;
            case R.id.button_Two:
                first_value = 2;
                addNumber((int) first_value);
                break;
            case R.id.button_Three:
                first_value = 3;
                addNumber((int) first_value);
                break;
            case R.id.button_Four:
                first_value = 4;
                addNumber((int) first_value);
                break;
            case R.id.button_Five:
                first_value = 5;
                addNumber((int) first_value);
                break;
            case R.id.button_Six:
                first_value = 6;
                addNumber((int) first_value);
                break;
            case R.id.button_Seven:
                first_value = 7;
                addNumber((int) first_value);
                break;
            case R.id.button_Eight:
                first_value = 8;
                addNumber((int) first_value);
                break;
            case R.id.button_Nine:
                first_value = 9;
                addNumber((int) first_value);
                break;
            case R.id.button_Null:
                first_value = 0;
                addNumber((int) first_value);
                break;
            case R.id.button_Point:
                mathOperation(".");
                break;
            case R.id.button_Sum:
                mathOperation("+");
                break;
            case R.id.button_Pow:
                mathOperation("*");
                break;
            case R.id.button_Div:
                mathOperation("/");
                break;
            case R.id.button_Persent:
                mathOperation("%");
                break;
            case R.id.button_Equals:
                if (this.operation == '+' || this.operation == '-'
                        || this.operation == '/' || this.operation == '*')
                    equalMethod();
                break;
            default:
        }
    }

    private void equalMethod() {
        float res = 0;
        switch (this.operation) {
            case '+':
                res = this.first_value + Float.parseFloat(this.str_numb);
                break;
            case '-':
                res = this.first_value - Float.parseFloat(this.str_numb);
                break;
            case '/':
                if (Float.parseFloat(this.str_numb) != 0)
                    res = this.first_value / Float.parseFloat(this.str_numb);
                else
                    Toast.makeText(this, "На ноль делить нельзя!!!", Toast.LENGTH_SHORT).show();
                ;
                break;
            case '*':
                res = this.first_value * Float.parseFloat(this.str_numb);
                break;
        }
        calcDisplay.setText(Float.toString(res));
        clear();
    }

    private void clear() {
        this.str_numb = "";
        this.operation = 'A';
        this.first_value = 0;
    }

    public void addNumber(int number) {
        str_numb += Integer.toString(number);
        calcDisplay.setText(str_numb);
    }

    private void mathOperation(String s) {
        if (this.operation != '+' && this.operation != '-'
                && this.operation != '/' && this.operation != '*' && this.operation != '.') {
            this.first_value = Float.parseFloat(this.str_numb);
            calcDisplay.setText(String.valueOf(operation));
            this.str_numb = "";
            this.operation = operation;
        }
    }

    public void sum() {
        if (!this.str_numb.equals("")) {
            float num = Float.parseFloat(this.str_numb) * -1;
            this.str_numb = Float.toString(num);
            calcDisplay.setText(str_numb);
        }
    }

    public void razn() {
        if (!this.str_numb.equals("")) {
            float num = Float.parseFloat(this.str_numb) * -1;
            this.str_numb = Float.toString(num);
            calcDisplay.setText(str_numb);
        }
    }
}