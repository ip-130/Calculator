package com.android.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
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
    private float second_value;
    private char operation;
    private String str_numb = "";
    private String str_numb_two = "";

    private static final String Key = "KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        btnOne = (Button) findViewById(R.id.button_One);
        btnTwo = (Button) findViewById(R.id.button_Two);
        btnThree = (Button) findViewById(R.id.button_Three);
        btnFour = (Button) findViewById(R.id.button_Four);
        btnFive = (Button) findViewById(R.id.button_Five);
        btnSix = (Button) findViewById(R.id.button_Six);
        btnSeven = (Button) findViewById(R.id.button_Seven);
        btnEight = (Button) findViewById(R.id.button_Eight);
        btnNine = (Button) findViewById(R.id.button_Nine);
        btnNull = (Button) findViewById(R.id.button_Null);

        btnPoint = (Button) findViewById(R.id.button_Point);
        btnSum = (Button) findViewById(R.id.button_Sum);
        btnRazn = (Button) findViewById(R.id.button_Razn);
        btnDiv = (Button) findViewById(R.id.button_Div);
        btnPow = (Button) findViewById(R.id.button_Pow);
        btnEquals = (Button) findViewById(R.id.button_Equals);
        btnPersent = (Button) findViewById(R.id.button_Persent);
        btnClear = (Button) findViewById(R.id.button_Clear);
        btnClearOneSymbol = (Button) findViewById(R.id.button_ClearOneSymbol);
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
                point();
                break;
            case R.id.button_Sum:
                mathOperation('+');
                break;
            case R.id.button_Razn:
                mathOperation('-');
                break;
            case R.id.button_Pow:
                mathOperation('X');
                break;
            case R.id.button_Div:
                mathOperation('/');
                break;
            case R.id.button_Clear:
                clear();
                break;
            case R.id.button_Persent:
                percent();
                break;
            case R.id.button_ClearOneSymbol:
                clearOneSymbol();
                break;
            case R.id.button_Equals:
                if(this.operation == '+' || this.operation == '-'
                        || this.operation == '/' || this.operation == 'X')
                    equalMethod();
                break;
        }
    }

    public void percent() {
        if (!this.str_numb.equals("")) {
            float num = Float.parseFloat(this.str_numb) * 0.01f;
            this.str_numb = Float.toString(num);
            calcDisplay.setText(str_numb);
        }
    }

    public void equalMethod() {
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
                    Toast.makeText(this, "  null!!!", Toast.LENGTH_SHORT).show();;
                break;
            case 'X':
                res = this.first_value * Float.parseFloat(this.str_numb);
                break;
        }
        clear();
        calcDisplay.setText(Float.toString(res));
    }

    public void clearOneSymbol() {
        this.str_numb = "";
        this.operation = 'A';
        this.first_value = 0;
    }

    public void clear() {
        calcDisplay.setText("0");
        this.str_numb = "";
        this.first_value = 0;
        this.operation = 'A';
    }

    public void addNumber(int number) {
        str_numb += Integer.toString(number);
        if(first_value != 0) {
            str_numb_two += Integer.toString(number);
        }
        calcDisplay.setText(str_numb_two);
    }

    public void mathOperation(char operation) {
        if (this.operation != '+' && this.operation != '-'
                && this.operation != '/' && this.operation != 'X') {
            this.first_value = Float.parseFloat(this.str_numb);
            calcDisplay.setText(String.valueOf(operation));
            this.str_numb = "";
            this.operation = operation;
        }
    }

    public void point() {
        if (!this.str_numb.contains(".")) {
            this.str_numb += ".";
            calcDisplay.setText(str_numb);
        }
    }
}