package jp.techacademy.takashi.sasaki.calcapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button additionButton = (Button) findViewById(R.id.additionButton);
        additionButton.setOnClickListener(this);
        Button subtractionButton = (Button) findViewById(R.id.subtractionButton);
        subtractionButton.setOnClickListener(this);
        Button multiplicationButton = (Button) findViewById(R.id.multiplicationButton);
        multiplicationButton.setOnClickListener(this);
        Button divisionButton = (Button) findViewById(R.id.divisionButton);
        divisionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText text1 = findViewById(R.id.value1);
        EditText text2 = findViewById(R.id.value2);

        if (text1.getText().toString().equals("")) {
            Snackbar.make(v, "値1を入力して下さい", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            text1.requestFocus();
            return;
        }
        if (text2.getText().toString().equals("")) {
            Snackbar.make(v, "値2を入力して下さい", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            text2.requestFocus();
            return;
        }

        // android:inputType="numberDecimal"を指定しているが入力値検証は必要か？
        BigDecimal value1 = new BigDecimal(text1.getText().toString());
        BigDecimal value2 = new BigDecimal(text2.getText().toString());
        Log.d("debug", "value1:" + value1);
        Log.d("debug", "value2:" + value2);

        if (v.getId() == R.id.divisionButton && value2.compareTo(BigDecimal.ZERO) == 0) {
            Snackbar.make(v, "0で割る事はできません", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            text2.setText("");
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("type", (int) v.getId());
        intent.putExtra("value1", value1.toString());
        intent.putExtra("value2", value2.toString());
        startActivity(intent);
    }
}
