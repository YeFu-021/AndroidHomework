package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Info";
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_point, btn_clear, btn_back , btn_eql;
    Button btn_plus, btn_minus, btn_mul, btn_div;
    TextView result, history;
    String expression="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        // 数字按钮绑定

        btn_point = (Button) findViewById(R.id.button_decimal);
        btn_clear = (Button) findViewById(R.id.button_clear);
        btn_back = (Button) findViewById(R.id.button_back);
        btn_eql= (Button) findViewById(R.id.button_eql);
        //功能按钮绑定

        btn_plus = (Button) findViewById(R.id.button_plus);
        btn_minus = (Button) findViewById(R.id.button_minus);
        btn_mul = (Button) findViewById(R.id.button_mul);
        btn_div = (Button) findViewById(R.id.button_div);
        // 运算符按钮绑定

        result = (TextView)findViewById(R.id.result);
        history = (TextView)findViewById(R.id.history);

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
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_eql.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.button_decimal:
            case R.id.button_plus:
            case R.id.button_minus:
            case R.id.button_mul:
            case R.id.button_div:
                expression += ((Button)view).getText().toString();
                result.setText(expression);
                break;
            case R.id.button_clear:
                expression = "";
                result.setText(expression);
                break;
            case R.id.button_back:
                expression = expression.substring(0,expression.length()-1);
                result.setText(expression);
                break;
            case R.id.button_eql:
               try {
                    calculate cal = new calculate(expression);
                    result.setText(cal.getResult());
                    history.setText(cal.getResult());
                    expression = cal.getResult();}
               catch (Exception e){
                   Log.d(TAG, "逻辑有误");
               }
                break;

            default:
                break;


        }
    }

}