package com.example.task2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private double num1, num2;
    private char operator;
    private boolean isNewCalculation = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        setButtonOnClickListeners();
    }

    private void setButtonOnClickListeners() {
        findViewById(R.id.btn_clear).setOnClickListener(v -> clearDisplay());
        findViewById(R.id.btn_0).setOnClickListener(v -> updateDisplay("0"));
        findViewById(R.id.btn_1).setOnClickListener(v -> updateDisplay("1"));
        findViewById(R.id.btn_2).setOnClickListener(v -> updateDisplay("2"));
        findViewById(R.id.btn_3).setOnClickListener(v -> updateDisplay("3"));
        findViewById(R.id.btn_4).setOnClickListener(v -> updateDisplay("4"));
        findViewById(R.id.btn_5).setOnClickListener(v -> updateDisplay("5"));
        findViewById(R.id.btn_6).setOnClickListener(v -> updateDisplay("6"));
        findViewById(R.id.btn_7).setOnClickListener(v -> updateDisplay("7"));
        findViewById(R.id.btn_8).setOnClickListener(v -> updateDisplay("8"));
        findViewById(R.id.btn_9).setOnClickListener(v -> updateDisplay("9"));
        findViewById(R.id.btn_decimal).setOnClickListener(v -> updateDisplay("."));
        findViewById(R.id.btn_add).setOnClickListener(v -> setOperator('+'));
        findViewById(R.id.btn_subtract).setOnClickListener(v -> setOperator('-'));
        findViewById(R.id.btn_multiply).setOnClickListener(v -> setOperator('*'));
        findViewById(R.id.btn_divide).setOnClickListener(v -> setOperator('/'));
        findViewById(R.id.btn_equal).setOnClickListener(v -> performCalculation());
    }
    private void updateDisplay(String value) {
        String currentInput = display.getText().toString();
        if (isNewCalculation) {
            display.setText(value);
            isNewCalculation = false;
        } else {
            display.setText(currentInput + value);
        }
    }

    private void setOperator(char op) {
        String currentInput = display.getText().toString();
        if (!currentInput.isEmpty()) {
            num1 = Double.parseDouble(currentInput);
            operator = op;
            isNewCalculation = true;
        }
    }
    private void performCalculation() {
        String currentInput = display.getText().toString();
        if (!currentInput.isEmpty()) {
            num2 = Double.parseDouble(currentInput);

            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    }
                    else {
                        display.setText("Error: Division by zero");
                        isNewCalculation = true;
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            isNewCalculation = true;
        }
    }

    private void clearDisplay() {
        display.setText("");
        isNewCalculation = true;
    }

}
