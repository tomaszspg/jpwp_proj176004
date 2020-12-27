package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import java.util.Locale;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Level extends AppCompatActivity implements View.OnClickListener {
    private Switch switch1;
    private TextView pod16;
    private Button bt1_1;
    private Button bt1_2;
    private Button bt1_3;
    private Button bt1_4;
    private Button bt1_5;
    private Button bt1_6;
//    private List<Button> buttons;
//    private static final int[] BUTTON_IDS = {
//            R.id.btn1_1,
//            R.id.btn1_2,
//            R.id.btn1_3,
//            R.id.btn1_4,
//            R.id.btn1_5,
//
//    };
    TextView textView_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        switch1 = (Switch) findViewById(R.id.switch1);


        TextView pod16 = findViewById(R.id.pod16);
        TextView pod8 = (TextView) findViewById(R.id.pod8);
        TextView pod4 = (TextView) findViewById(R.id.pod4);
        TextView pod2 = (TextView) findViewById(R.id.pod2);
        TextView pod1 = (TextView) findViewById(R.id.pod1);
        bt1_1 = (Button) findViewById(R.id.bt1_1);
        bt1_1.setOnClickListener(this);
        bt1_2 = (Button) findViewById(R.id.bt1_2);
        bt1_2.setOnClickListener(this);
        bt1_3 = (Button) findViewById(R.id.bt1_3);
        bt1_3.setOnClickListener(this);
        bt1_4 = (Button) findViewById(R.id.bt1_4);
        bt1_4.setOnClickListener(this);
        bt1_5 = (Button) findViewById(R.id.bt1_5);
        bt1_5.setOnClickListener(this);
        bt1_6 = (Button) findViewById(R.id.bt1_6);
        bt1_6.setOnClickListener(this);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch1.isChecked())
                {
                    pod16.setVisibility(View.VISIBLE);
                    pod8.setVisibility(View.VISIBLE);
                    pod4.setVisibility(View.VISIBLE);
                    pod2.setVisibility(View.VISIBLE);
                    pod1.setVisibility(View.VISIBLE);
                }
                else
                {
                    pod16.setVisibility(View.GONE);
                    pod8.setVisibility(View.GONE);
                    pod4.setVisibility(View.GONE);
                    pod2.setVisibility(View.GONE);
                    pod1.setVisibility(View.GONE);
                }
            }
        });
//        if (switch1.isChecked())
//        {
//            pod16.setVisibility(View.GONE);
//        }

//        buttons = new ArrayList<Button>();
//        //buttons = new ArrayList<Button>(BUTTON_IDS.length);
//       // ArrayList<Character> answer = new ArrayList<Character>();
//        for (int id : BUTTON_IDS) {
//            Button button = (Button) findViewById(id);
//            button.setOnClickListener(this);
//            buttons.add(button);
//
//        }


        textView_timer = findViewById(R.id.text_view);
        long duration = TimeUnit.SECONDS.toMillis(20);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        , TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                textView_timer.setText(sDuration);
            }

            @Override
            public void onFinish() {
                textView_timer.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext()
                        , "Koniec czasu", Toast.LENGTH_LONG).show();

            }
        }.start();


    }

    @Override
    public void onClick(View v)
    {
        String currentText = bt1_1.getText().toString();
        String currentText2 = bt1_2.getText().toString();
        String currentText3 = bt1_3.getText().toString();
        String currentText4 = bt1_4.getText().toString();
        String currentText5 = bt1_5.getText().toString();
        String currentText6 = bt1_6.getText().toString();
        if (v.getId() == R.id.bt1_1)
            bt1_1.setText(currentText.equals("0") ? "1" : "0" );
        if (v.getId() == R.id.bt1_2)
            bt1_2.setText(currentText2.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt1_3)
            bt1_3.setText(currentText3.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt1_4)
            bt1_4.setText(currentText4.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt1_5)
            bt1_5.setText(currentText5.equals("0") ? "1" : "0");
       // String row1 = bt1_1.getText()+ bt1_2.getText()+bt1_3.getText()+bt1_4.getText()+bt1_5.getText();
        String row1 = bt1_1.getText().toString() + bt1_2.getText().toString() + bt1_3.getText().toString() + bt1_4.getText().toString() + bt1_5.getText().toString() ;
        int dec1= Integer.parseInt(row1,2); //2 - system dwojkowy, 3- system trojkowy itp
        int wynik=Integer.parseInt(bt1_6.getText().toString());
        if (dec1==wynik)
            {
                Toast.makeText(getApplicationContext()
                    , "Git jest", Toast.LENGTH_LONG).show();
                bt1_1.setVisibility(View.INVISIBLE);
                bt1_2.setVisibility(View.INVISIBLE);
                bt1_3.setVisibility(View.INVISIBLE);
                bt1_4.setVisibility(View.INVISIBLE);
                bt1_5.setVisibility(View.INVISIBLE);
                bt1_6.setVisibility(View.INVISIBLE);
            }
        if (switch1.isChecked())
        {
            pod16.setText("0");
        }





        // String currentText = buttons.getText().toString();
//        String currentText2 = btn2.getText().toString();
//        String currentText3 = btn3.getText().toString();
//        String currentText4 = btn4.getText().toString();
//        String currentText5 = btn5.getText().toString();
     //   if (v.getId() == R.id.button)
      //      btn1_1.setText(currentText.equals("0") ? "1" : "0");
//        if (v.getId() == R.id.button2)
//            btn2.setText(currentText2.equals("0") ? "1" : "0");
//        if (v.getId() == R.id.button3)
//            btn3.setText(currentText3.equals("0") ? "1" : "0");
//        if (v.getId() == R.id.button4)
//            btn4.setText(currentText4.equals("0") ? "1" : "0");
//        if (v.getId() == R.id.button5)
//            btn5.setText(currentText5.equals("0") ? "1" : "0");


    }


//    String getValuesPressed(){
//
//        for(int i = 0; i < buttons.length; i++){
//            buttons[i].setOnClickListener(new MyClickListener(i));
//        }
//
//        return textOnScreen;
//    }

}