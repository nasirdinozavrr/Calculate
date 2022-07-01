package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double first, second;
    private Boolean onСlick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.result);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                checkDigit(0);
                break;
            case R.id.btn_one:
                checkDigit(1);
                break;
            case R.id.btn_two:
                checkDigit(2);
                break;
            case R.id.btn_three:
                checkDigit(3);
                break;
            case R.id.btn_four:
                checkDigit(4);
                break;
            case R.id.btn_five:
                checkDigit(5);
                break;
            case R.id.btn_six:
                checkDigit(6);
                break;
            case R.id.btn_seven:
                checkDigit(7);
                break;
            case R.id.btn_eight:
                checkDigit(8);
                break;
            case R.id.btn_nine:
                checkDigit(9);
                break;
            case R.id.btn_cleaner:
                textView.setText("0");
                first = 0.0;
                second = 0.0;
                break;
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                operation = "+";
                getFirstValue();
                break;
            case R.id.btn_minus:
                operation = "-";
                getFirstValue();
                break;
            case R.id.btn_multiply:
                operation = "x";
                getFirstValue();
                break;
            case R.id.btn_divide:
                operation = "/";
                getFirstValue();
                break;
            case R.id.btn_percent:
                operation = "%";
                getFirstValue();
                break;
            case R.id.btn_negative:
                if (!textView.getText().toString().equals("0")) {
                    String s = "";
                    if (!textView.getText().toString().contains("-")) {
                        s = "-" + textView.getText();
                    } else {
                        s += textView.getText().toString().substring(1);
                    }
                    textView.setText(s);
                }
                break;
            case R.id.btn_equal:
                performOperation(operation);
                break;
            case R.id.btn_dot:
                if (!textView.getText().toString().contains(".")) {
                    textView.append(".");
                }
                break;
        }
    }

    public void checkDigit(Integer integer) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(String.valueOf(integer));
        } else if (onСlick) {
            textView.setText(String.valueOf(integer));
        } else {
            textView.append(String.valueOf(integer));
        }
        onСlick = false;
    }

    public void getFirstValue() {
        first = Double.parseDouble(textView.getText().toString());
        setVariable(first);
        onСlick = true;
    }

    public void performOperation(String s) {
        Double result = 0.0;
        second = Double.parseDouble(textView.getText().toString());

        switch (s) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "/":
                result = first / second;
                break;
            case "x":
                result = first * second;
                break;
            case "%":
                result = first / 100;
                break;
        }

        setVariable(result);
        onСlick = true;
    }

    public void setVariable(Double d) {
        if (d % 1 == 0) {
            textView.setText(String.valueOf(Math.round(d)));
        } else {
            textView.setText(d.toString());
        }

    }
}