package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Level extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    TextView textView_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);

        textView_timer = findViewById(R.id.text_view);
        long duration = TimeUnit.SECONDS.toMillis(20);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                    ,TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    ,TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                textView_timer.setText(sDuration);
            }

            @Override
            public void onFinish() {
                textView_timer.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext()
                    ,"Koniec czasu", Toast.LENGTH_LONG).show();

            }
        }.start();

    }


    @Override
    public void onClick(View v)
    {   String currentText = btn.getText().toString();
        String currentText2 = btn2.getText().toString();
        String currentText3 = btn3.getText().toString();
        String currentText4 = btn4.getText().toString();
        String currentText5 = btn5.getText().toString();
        if (v.getId() == R.id.button)
            btn.setText(currentText.equals("0") ? "1" : "0");
        if (v.getId() == R.id.button2)
            btn2.setText(currentText2.equals("0") ? "1" : "0");
        if (v.getId() == R.id.button3)
            btn3.setText(currentText3.equals("0") ? "1" : "0");
        if (v.getId() == R.id.button4)
            btn4.setText(currentText4.equals("0") ? "1" : "0");
        if (v.getId() == R.id.button5)
            btn5.setText(currentText5.equals("0") ? "1" : "0");


    }

}