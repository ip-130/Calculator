package com.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView calcDisplay;

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    private Button btnAdd;
    private Button btnSub;
    private Button btnMult;
    private Button btnDiv;
    private Button btnEquals;
    private Button btnPersent;
    private Button btnClear;
    private Button btnClearOneSymbol;
    private Button btnPoint;

    private float first_value;
    private char operation;
    private String str_numb = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initialization();

        //обработка нажатий
        calcDisplay.setOnClickListener(this);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPersent.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearOneSymbol.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
    }

    public void initialization() {

        //получение пользовательских элементов по идентификатору
        calcDisplay = (TextView) findViewById(R.id.calculatorDisplay);

        btn_0 = (Button) findViewById(R.id.button_0);
        btn_1 = (Button) findViewById(R.id.button_1);
        btn_2 = (Button) findViewById(R.id.button_2);
        btn_3 = (Button) findViewById(R.id.button_3);
        btn_4 = (Button) findViewById(R.id.button_4);
        btn_5 = (Button) findViewById(R.id.button_5);
        btn_6 = (Button) findViewById(R.id.button_6);
        btn_7 = (Button) findViewById(R.id.button_7);
        btn_8 = (Button) findViewById(R.id.button_8);
        btn_9 = (Button) findViewById(R.id.button_9);

        btnAdd =  findViewById(R.id.button_add);
        btnSub = findViewById(R.id.button_sub);
        btnMult = findViewById(R.id.button_mult);
        btnDiv = findViewById(R.id.button_div);
        btnEquals = findViewById(R.id.button_equals);
        btnPersent = findViewById(R.id.button_persent);
        btnClear = findViewById(R.id.button_clear);
        btnClearOneSymbol = findViewById(R.id.button_clearOneSymbol);
        btnPoint = findViewById(R.id.button_point);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Bundle instanceState = null;
//        instanceState.putString(Key, calcDisplay.getText().toString());
//        instanceState.putParcelable(Key, (Parcelable) calcDisplay);
//    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
//        super.onSaveInstanceState(saveInstanceState);
//        Bundle instanceState = null;
//        instanceState.putString(Key, calcDisplay.getText().toString());
//        instanceState.putParcelable(Key, (Parcelable) calcDisplay);
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                first_value = 0;
                addNumber((int) first_value);
                break;
            case R.id.button_1:
                first_value = 1;
                addNumber((int) first_value);
                break;
            case R.id.button_2:
                first_value = 2;
                addNumber((int) first_value);
                break;
            case R.id.button_3:
                first_value = 3;
                addNumber((int) first_value);
                break;
            case R.id.button_4:
                first_value = 4;
                addNumber((int) first_value);
                break;
            case R.id.button_5:
                first_value = 5;
                addNumber((int) first_value);
                break;
            case R.id.button_6:
                first_value = 6;
                addNumber((int) first_value);
                break;
            case R.id.button_7:
                first_value = 7;
                addNumber((int) first_value);
                break;
            case R.id.button_8:
                first_value = 8;
                addNumber((int) first_value);
                break;
            case R.id.button_9:
                first_value = 9;
                addNumber((int) first_value);
                break;
            case R.id.button_point:
                point();
                break;
            case R.id.button_add:
                mathOperation('+');
                break;
            case R.id.button_sub:
                mathOperation('-');
                break;
            case R.id.button_mult:
                mathOperation('*');
                break;
            case R.id.button_div:
                mathOperation('/');
                break;
            case R.id.button_clear:
                clearAll();
                break;
            case R.id.button_persent:
                percent();
                break;
            case R.id.button_clearOneSymbol:
                clearOneSymbol();
                break;
            case R.id.button_equals:
                if (this.operation == '+' || this.operation == '-'
                        || this.operation == '/' || this.operation == '*')
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
                res = Float.parseFloat(this.str_numb) + Float.parseFloat(this.str_numb);
                break;
            case '-':
                res = Float.parseFloat(this.str_numb) - Float.parseFloat(this.str_numb);
                break;
            case '/':
                if (Float.parseFloat(this.str_numb) != 0)
                    res = Float.parseFloat(this.str_numb) / Float.parseFloat(this.str_numb);
                else
                    Toast.makeText(this, "  null!!!", Toast.LENGTH_SHORT).show();
                ;
                break;
            case 'X':
                res = Float.parseFloat(this.str_numb) * Float.parseFloat(this.str_numb);
                break;
        }
        clearAll();
        calcDisplay.setText(Float.toString(res));
    }

    public void clearOneSymbol() {
        this.str_numb = "";
        this.operation = 'A';
        this.first_value = 0;
    }

    public void clearAll() {
        calcDisplay.setText("0");
        this.str_numb = "";
        this.first_value = 0;
        this.operation = 'A';
    }

    public void addNumber(int number) {
        str_numb += Integer.toString(number);
        calcDisplay.setText(str_numb);
    }

    public void mathOperation(char operation) {
        this.first_value = Float.parseFloat(this.str_numb);
        calcDisplay.setText(String.valueOf(operation));
        this.str_numb = "";
        this.operation = operation;
    }

    public void point() {
        if (!this.str_numb.contains(".")) {
            this.str_numb += ".";
            calcDisplay.setText(str_numb);
        }
    }
}