package jp.techacademy.takashi.sasaki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        BigDecimal value1 = new BigDecimal(intent.getStringExtra("value1"));
        BigDecimal value2 = new BigDecimal(intent.getStringExtra("value2"));
        Log.d("debug", "type:" + type);
        Log.d("debug", "value1:" + value1.toString());
        Log.d("debug", "value2:" + value2.toString());

        TextView view1 = findViewById(R.id.value1);
        view1.setText(value1.toString());
        TextView view2 = findViewById(R.id.value2);
        view2.setText(value2.toString());
        TextView operator = findViewById(R.id.operator);
        TextView result = findViewById(R.id.result);

        if (type == R.id.additionButton) {
            operator.setText("+");
            result.setText(value1.add(value2).toString());
        }
        if (type == R.id.subtractionButton) {
            operator.setText("-");
            result.setText(value1.subtract(value2).toString());
        }
        if (type == R.id.multiplicationButton) {
            operator.setText("*");
            result.setText(value1.multiply(value2).toString());
        }
        if (type == R.id.divisionButton) {
            operator.setText("/");
            result.setText(value1.divide(value2, 10, BigDecimal.ROUND_HALF_UP).toString());
        }
    }
}
