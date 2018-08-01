package com.example.admin.mycalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {

    private enum OPERATOR{
        PLUS, SUBSTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    TextView txtCalculations;
    TextView txtResults;

    // Instnce Variables

    private String currentNum;
    private String stringNumAtLeft;
    private String stringNumAtRight;
    private OPERATOR currentOperator;
    private int calcResult;
    private String calcString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentNum = "";
        calcResult = 0;
        calcString = "";

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btnPlus).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMult).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSub).setOnClickListener(Calculator.this);
        findViewById(R.id.btnC).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Calculator.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEqual:
                operatorIsTyped(OPERATOR.EQUAL);
                break;
            case R.id.btn7:
                numIsTapped(7);
                break;
            case R.id.btn8:
                numIsTapped(8);
                break;
            case R.id.btn9:
                numIsTapped(9);
                break;
            case R.id.btnPlus:
                operatorIsTyped(OPERATOR.PLUS);
                calcString += " + ";
                break;
            case R.id.btn4:
                numIsTapped(4);
                break;
            case R.id.btn5:
                numIsTapped(5);
                break;
            case R.id.btn6:
                numIsTapped(6);
                break;
            case R.id.btnSub:
                operatorIsTyped(OPERATOR.SUBSTRACT);
                calcString += " - ";
                break;
            case R.id.btn1:
                numIsTapped(1);
                break;
            case R.id.btn2:
                numIsTapped(2);
                break;
            case R.id.btn3:
                numIsTapped(3);
                break;
            case R.id.btnMult:
                operatorIsTyped(OPERATOR.MULTIPLY);
                calcString += " * ";
                break;
            case R.id.btnC:
                clearTapped();
                break;
            case R.id.btn0:
                numIsTapped(0);
                break;
            case R.id.btnDivide:
                operatorIsTyped(OPERATOR.DIVIDE);
                calcString += " / ";
                break;
        }
        txtCalculations.setText(calcString);

    }

private void numIsTapped(int tappedNum){
        currentNum = currentNum + String.valueOf(tappedNum);
        txtResults.setText(currentNum);

        calcString = currentNum;
        txtCalculations.setText(calcString);
}

    private void operatorIsTyped(OPERATOR tappedOperator){
        if (currentOperator != null) {

            if (currentNum != "") {

                stringNumAtRight = currentNum;
                currentNum = "";
                switch (currentOperator) {
                    case PLUS:
                        calcResult = Integer.parseInt(stringNumAtLeft) +
                                Integer.parseInt(stringNumAtRight);
                        break;
                    case SUBSTRACT:
                        calcResult = Integer.parseInt(stringNumAtLeft) -
                                Integer.parseInt(stringNumAtRight);
                        break;
                    case MULTIPLY:
                        calcResult = Integer.parseInt(stringNumAtLeft) *
                                Integer.parseInt(stringNumAtRight);
                        break;
                    case DIVIDE:
                        calcResult = Integer.parseInt(stringNumAtLeft) /
                                Integer.parseInt(stringNumAtRight);
                        break;
                }
                stringNumAtLeft = String.valueOf(calcResult);
                txtResults.setText(stringNumAtLeft);
                calcString = stringNumAtLeft;
            }
        }

        else {
            stringNumAtLeft = currentNum;
            currentNum = "";
        }

        currentOperator = tappedOperator;

    }

    private void clearTapped(){

        stringNumAtLeft = "";
        stringNumAtRight = "";
        calcResult = 0;
        currentNum = "";
        currentOperator = null;
        txtResults.setText("0");
        calcString = "0";

    }

}
