package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Latwy extends AppCompatActivity implements View.OnClickListener {
    private Switch switch1;
    private Button bt1_1, bt1_2, bt1_3, bt1_4, bt1_5, bt1_6, bt2_1, bt2_2, bt2_3, bt2_4, bt2_5, bt2_6;
    private Button bt3_1, bt3_2, bt3_3, bt3_4, bt3_5, bt3_6, bt4_1, bt4_2, bt4_3, bt4_4, bt4_5, bt4_6;
    private Button bt5_1, bt5_2, bt5_3, bt5_4, bt5_5, bt5_6;
    int licznik=0;
    int pkt=0;
    int rz1=0; //0 - startuje, 2- zrobiony 1- poprzedni rzad zrobiony wiec w gotowosci
    int rz2=0;
    int rz3=0;
    int rz4=0;
    int rz5=0;
    boolean rz22;
    boolean rz33;
    boolean rz44;
    boolean rz55;
    boolean timerstop;
    boolean temp1=false, temp2=false,temp3=false,temp4=false;
    String sDuration;
    int pktrz1=0, pktrz2=0, pktrz3=0, pktrz4=0, pktrz5=0;


    TextView textView_timer;
    TextView punkt, punkt2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latwy);
        switch1 = (Switch) findViewById(R.id.switch1);
        // licznik =0;


        punkt = (TextView)findViewById(R.id.punkt);
        punkt2 = (TextView)findViewById(R.id.punkt2);






        TextView podramka = findViewById(R.id.podramka);
        TextView pod8 = (TextView) findViewById(R.id.pod8);
        TextView pod4 = (TextView) findViewById(R.id.pod4);
        TextView pod2 = (TextView) findViewById(R.id.pod2);
        TextView pod1 = (TextView) findViewById(R.id.pod1);
        bt1_1 = (Button) findViewById(R.id.bt1_1); bt1_1.setOnClickListener(this);
        bt1_2 = (Button) findViewById(R.id.bt1_2); bt1_2.setOnClickListener(this);
        bt1_3 = (Button) findViewById(R.id.bt1_3); bt1_3.setOnClickListener(this);
        bt1_4 = (Button) findViewById(R.id.bt1_4); bt1_4.setOnClickListener(this);

        bt1_6 = (Button) findViewById(R.id.bt1_6); bt1_6.setOnClickListener(this);
        bt2_1 = (Button) findViewById(R.id.bt2_1); bt2_1.setOnClickListener(this);
        bt2_2 = (Button) findViewById(R.id.bt2_2); bt2_2.setOnClickListener(this);
        bt2_3 = (Button) findViewById(R.id.bt2_3); bt2_3.setOnClickListener(this);
        bt2_4 = (Button) findViewById(R.id.bt2_4); bt2_4.setOnClickListener(this);

        bt2_6 = (Button) findViewById(R.id.bt2_6); bt2_6.setOnClickListener(this);
        bt3_1 = (Button) findViewById(R.id.bt3_1); bt3_1.setOnClickListener(this);
        bt3_2 = (Button) findViewById(R.id.bt3_2); bt3_2.setOnClickListener(this);
        bt3_3 = (Button) findViewById(R.id.bt3_3); bt3_3.setOnClickListener(this);
        bt3_4 = (Button) findViewById(R.id.bt3_4); bt3_4.setOnClickListener(this);

        bt3_6 = (Button) findViewById(R.id.bt3_6); bt3_6.setOnClickListener(this);
        bt4_1 = (Button) findViewById(R.id.bt4_1); bt4_1.setOnClickListener(this);
        bt4_2 = (Button) findViewById(R.id.bt4_2); bt4_2.setOnClickListener(this);
        bt4_3 = (Button) findViewById(R.id.bt4_3); bt4_3.setOnClickListener(this);
        bt4_4 = (Button) findViewById(R.id.bt4_4); bt4_4.setOnClickListener(this);

        bt4_6 = (Button) findViewById(R.id.bt4_6); bt4_6.setOnClickListener(this);
        bt5_1 = (Button) findViewById(R.id.bt5_1); bt5_1.setOnClickListener(this);
        bt5_2 = (Button) findViewById(R.id.bt5_2); bt5_2.setOnClickListener(this);
        bt5_3 = (Button) findViewById(R.id.bt5_3); bt5_3.setOnClickListener(this);
        bt5_4 = (Button) findViewById(R.id.bt5_4); bt5_4.setOnClickListener(this);

        bt5_6 = (Button) findViewById(R.id.bt5_6); bt5_6.setOnClickListener(this);
        Random rand = new Random();
        bt1_6.setText(Integer.toString(rand.nextInt(8)+1)); //MAX 15
        bt2_6.setText(Integer.toString(rand.nextInt(8)+1));
        bt3_6.setText(Integer.toString(rand.nextInt(8)+1));
        bt4_6.setText(Integer.toString(rand.nextInt(8)+1));
        bt5_6.setText(Integer.toString(rand.nextInt(8)+1));

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch1.isChecked())
                {
                    podramka.setVisibility(View.VISIBLE);

                    pod8.setVisibility(View.VISIBLE);
                    pod4.setVisibility(View.VISIBLE);
                    pod2.setVisibility(View.VISIBLE);
                    pod1.setVisibility(View.VISIBLE);
                }
                else
                {
                    podramka.setVisibility(View.GONE);

                    pod8.setVisibility(View.GONE);
                    pod4.setVisibility(View.GONE);
                    pod2.setVisibility(View.GONE);
                    pod1.setVisibility(View.GONE);
                }
            }
        });



        textView_timer = findViewById(R.id.text_view);
        long duration = TimeUnit.SECONDS.toMillis(10);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        , TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                textView_timer.setText(sDuration); //0 - startuje, 2- zrobiony wiec nic, 1- poprzedni rzad wyklikany, 3- poprzedni niewyklikany
                if (rz2==1)
                {
                    bt2_1.setVisibility(View.VISIBLE);
                    bt2_2.setVisibility(View.VISIBLE);
                    bt2_3.setVisibility(View.VISIBLE);
                    bt2_4.setVisibility(View.VISIBLE);

                    bt2_6.setVisibility(View.VISIBLE);
                    rz3=3;
                    if (temp1==false){
                        this.cancel();
                        this.start();}
                    temp1=true;

                }
                if (rz3==1)
                {
                    bt3_1.setVisibility(View.VISIBLE);
                    bt3_2.setVisibility(View.VISIBLE);
                    bt3_3.setVisibility(View.VISIBLE);
                    bt3_4.setVisibility(View.VISIBLE);

                    bt3_6.setVisibility(View.VISIBLE);
                    rz4=3;
                    if (temp2==false){
                        this.cancel();
                        this.start();}
                    temp2=true;

                }
                if (rz4==1)
                {
                    bt4_1.setVisibility(View.VISIBLE);
                    bt4_2.setVisibility(View.VISIBLE);
                    bt4_3.setVisibility(View.VISIBLE);
                    bt4_4.setVisibility(View.VISIBLE);

                    bt4_6.setVisibility(View.VISIBLE);
                    rz5=3;
                    if (temp3==false){
                        this.cancel();
                        this.start();}
                    temp3=true;

                }
                if (rz5==1)
                {
                    bt5_1.setVisibility(View.VISIBLE);
                    bt5_2.setVisibility(View.VISIBLE);
                    bt5_3.setVisibility(View.VISIBLE);
                    bt5_4.setVisibility(View.VISIBLE);

                    bt5_6.setVisibility(View.VISIBLE);
                    if (temp4==false){
                        this.cancel();
                        this.start();}
                    temp4=true;
                    timerstop=true;
                }
                if (bt1_6.getVisibility()==View.VISIBLE & pktrz1<20) pktrz1++;
                if (bt2_6.getVisibility()==View.VISIBLE & pktrz2<20) pktrz2++;
                if (bt3_6.getVisibility()==View.VISIBLE & pktrz3<20) pktrz3++;
                if (bt4_6.getVisibility()==View.VISIBLE & pktrz4<20) pktrz4++;
                if (bt5_6.getVisibility()==View.VISIBLE & pktrz5<20) pktrz5++;
                punkt2.setText(String.valueOf((pktrz2/2)));
            }

            @Override
            public void onFinish() {

                //  textView_timer.setVisibility(View.GONE);
//                Toast.makeText(getApplicationContext()
//                        , "Koniec czasu", Toast.LENGTH_LONG).show();
                if (rz2==0 & rz2!=2) //drugi rzad startuje
                {
                    bt2_1.setVisibility(View.VISIBLE);
                    bt2_2.setVisibility(View.VISIBLE);
                    bt2_3.setVisibility(View.VISIBLE);
                    bt2_4.setVisibility(View.VISIBLE);

                    bt2_6.setVisibility(View.VISIBLE);
                    rz22=true;
                    temp1=true;
                }
                if (rz3==3 & rz3!=2) //drugi rzad startuje
                {
                    bt3_1.setVisibility(View.VISIBLE);
                    bt3_2.setVisibility(View.VISIBLE);
                    bt3_3.setVisibility(View.VISIBLE);
                    bt3_4.setVisibility(View.VISIBLE);

                    bt3_6.setVisibility(View.VISIBLE);
                    rz33=true;
                    temp2=true;
                }
                if (rz4==3 & rz4!=2) //drugi rzad startuje
                {
                    bt4_1.setVisibility(View.VISIBLE);
                    bt4_2.setVisibility(View.VISIBLE);
                    bt4_3.setVisibility(View.VISIBLE);
                    bt4_4.setVisibility(View.VISIBLE);

                    bt4_6.setVisibility(View.VISIBLE);
                    rz44=true;
                    temp3=true;
                }
                if (rz5==3 & rz5!=2) //drugi rzad startuje
                {
                    bt5_1.setVisibility(View.VISIBLE);
                    bt5_2.setVisibility(View.VISIBLE);
                    bt5_3.setVisibility(View.VISIBLE);
                    bt5_4.setVisibility(View.VISIBLE);

                    bt5_6.setVisibility(View.VISIBLE);
                    rz55=true;
                    temp4=true;
                    timerstop=true;
                }
                if (timerstop==true) textView_timer.setVisibility(View.GONE);
                else this.start();
                if (rz22==true &rz3!=2) rz3=3; //trojka gotowa do pojawienia w nastepnym timerze
                if (rz33==true &rz4!=2) rz4=3; //czworka gotowa do pojawienia w nastepnym timerze
                if (rz44==true &rz5!=2) {rz5=3; timerstop=true;} ; //piatka gotowa do pojawienia w nastepnym timerze


            }
        }.start();


    }



    @Override
    public void onClick(View v)
    {

        String currentText11 = bt1_1.getText().toString();
        String currentText12 = bt1_2.getText().toString();
        String currentText13 = bt1_3.getText().toString();
        String currentText14 = bt1_4.getText().toString();

        String currentText16 = bt1_6.getText().toString();

        String currentText21 = bt2_1.getText().toString();
        String currentText22 = bt2_2.getText().toString();
        String currentText23 = bt2_3.getText().toString();
        String currentText24 = bt2_4.getText().toString();

        String currentText26 = bt2_6.getText().toString();

        String currentText31 = bt3_1.getText().toString();
        String currentText32 = bt3_2.getText().toString();
        String currentText33 = bt3_3.getText().toString();
        String currentText34 = bt3_4.getText().toString();

        String currentText36 = bt3_6.getText().toString();

        String currentText41 = bt4_1.getText().toString();
        String currentText42 = bt4_2.getText().toString();
        String currentText43 = bt4_3.getText().toString();
        String currentText44 = bt4_4.getText().toString();

        String currentText46 = bt4_6.getText().toString();

        String currentText51 = bt5_1.getText().toString();
        String currentText52 = bt5_2.getText().toString();
        String currentText53 = bt5_3.getText().toString();
        String currentText54 = bt5_4.getText().toString();

        String currentText56 = bt5_6.getText().toString();
        //   bt1_6.setText(random);
        if (v.getId() == R.id.bt1_1)
            bt1_1.setText(currentText11.equals("0") ? "1" : "0" );
        if (v.getId() == R.id.bt1_2)
            bt1_2.setText(currentText12.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt1_3)
            bt1_3.setText(currentText13.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt1_4)
            bt1_4.setText(currentText14.equals("0") ? "1" : "0");


        if (v.getId() == R.id.bt2_1)
            bt2_1.setText(currentText21.equals("0") ? "1" : "0" );
        if (v.getId() == R.id.bt2_2)
            bt2_2.setText(currentText22.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt2_3)
            bt2_3.setText(currentText23.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt2_4)
            bt2_4.setText(currentText24.equals("0") ? "1" : "0");


        if (v.getId() == R.id.bt3_1)
            bt3_1.setText(currentText31.equals("0") ? "1" : "0" );
        if (v.getId() == R.id.bt3_2)
            bt3_2.setText(currentText32.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt3_3)
            bt3_3.setText(currentText33.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt3_4)
            bt3_4.setText(currentText34.equals("0") ? "1" : "0");


        if (v.getId() == R.id.bt4_1)
            bt4_1.setText(currentText41.equals("0") ? "1" : "0" );
        if (v.getId() == R.id.bt4_2)
            bt4_2.setText(currentText42.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt4_3)
            bt4_3.setText(currentText43.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt4_4)
            bt4_4.setText(currentText44.equals("0") ? "1" : "0");


        if (v.getId() == R.id.bt5_1)
            bt5_1.setText(currentText51.equals("0") ? "1" : "0" );
        if (v.getId() == R.id.bt5_2)
            bt5_2.setText(currentText52.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt5_3)
            bt5_3.setText(currentText53.equals("0") ? "1" : "0");
        if (v.getId() == R.id.bt5_4)
            bt5_4.setText(currentText54.equals("0") ? "1" : "0");

        // String row1 = bt1_1.getText()+ bt1_2.getText()+bt1_3.getText()+bt1_4.getText()+bt1_5.getText();
        String row1 = bt1_1.getText().toString() + bt1_2.getText().toString() + bt1_3.getText().toString() + bt1_4.getText().toString()  ;
        String row2 = bt2_1.getText().toString() + bt2_2.getText().toString() + bt2_3.getText().toString() + bt2_4.getText().toString()  ;
        String row3 = bt3_1.getText().toString() + bt3_2.getText().toString() + bt3_3.getText().toString() + bt3_4.getText().toString()  ;
        String row4 = bt4_1.getText().toString() + bt4_2.getText().toString() + bt4_3.getText().toString() + bt4_4.getText().toString()  ;
        String row5 = bt5_1.getText().toString() + bt5_2.getText().toString() + bt5_3.getText().toString() + bt5_4.getText().toString()  ;
        int dec1= Integer.parseInt(row1,2); //2 - system dwojkowy, 3- system trojkowy itp
        int wynik=Integer.parseInt(bt1_6.getText().toString());
        if (dec1==wynik)
        {
//                Toast.makeText(getApplicationContext()
//                    , "Git jest", Toast.LENGTH_LONG).show();
            bt1_1.setVisibility(View.INVISIBLE);
            bt1_2.setVisibility(View.INVISIBLE);
            bt1_3.setVisibility(View.INVISIBLE);
            bt1_4.setVisibility(View.INVISIBLE);

            bt1_6.setVisibility(View.INVISIBLE);
            rz1=2;
            if (rz2!=2) rz2=1;
            licznik++;
            pkt+= 11-(pktrz1/2);
            bt1_6.setText("0");



        }
        int dec2= Integer.parseInt(row2,2); //2 - system dwojkowy, 3- system trojkowy itp
        int wynik2=Integer.parseInt(bt2_6.getText().toString());
        if (dec2==wynik2)
        {
//            Toast.makeText(getApplicationContext()
//                    , "Git jest", Toast.LENGTH_LONG).show();
            bt2_1.setVisibility(View.INVISIBLE);
            bt2_2.setVisibility(View.INVISIBLE);
            bt2_3.setVisibility(View.INVISIBLE);
            bt2_4.setVisibility(View.INVISIBLE);

            bt2_6.setVisibility(View.INVISIBLE);
            licznik++;
            rz2=2;
            if (rz3!=2) rz3=1;
            pkt+= 11-(pktrz2/2);
            bt2_6.setText("0");
        }
        int dec3= Integer.parseInt(row3,2); //2 - system dwojkowy, 3- system trojkowy itp
        int wynik3=Integer.parseInt(bt3_6.getText().toString());
        if (dec3==wynik3)
        {
//            Toast.makeText(getApplicationContext()
//                    , "Git jest", Toast.LENGTH_LONG).show();
            bt3_1.setVisibility(View.INVISIBLE);
            bt3_2.setVisibility(View.INVISIBLE);
            bt3_3.setVisibility(View.INVISIBLE);
            bt3_4.setVisibility(View.INVISIBLE);

            bt3_6.setVisibility(View.INVISIBLE);
            licznik++;
            rz3=2;
            if (rz4!=2) rz4=1;
            pkt+= 11-(pktrz3/2);
            bt3_6.setText("0");
        }
        int dec4= Integer.parseInt(row4,2); //2 - system dwojkowy, 3- system trojkowy itp
        int wynik4=Integer.parseInt(bt4_6.getText().toString());
        if (dec4==wynik4)
        {
//            Toast.makeText(getApplicationContext()
//                    , "Git jest", Toast.LENGTH_LONG).show();
            bt4_1.setVisibility(View.INVISIBLE);
            bt4_2.setVisibility(View.INVISIBLE);
            bt4_3.setVisibility(View.INVISIBLE);
            bt4_4.setVisibility(View.INVISIBLE);

            bt4_6.setVisibility(View.INVISIBLE);
            licznik++;
            rz4=2;
            if (rz5!=2) rz5=1;
            pkt+= 11-(pktrz4/2);
            bt4_6.setText("0");
        }
        int dec5= Integer.parseInt(row5,2); //2 - system dwojkowy, 3- system trojkowy itp
        int wynik5=Integer.parseInt(bt5_6.getText().toString());
        if (dec5==wynik5)
        {
            // Toast.makeText(getApplicationContext()
            //         , "Git jest", Toast.LENGTH_LONG).show();
            bt5_1.setVisibility(View.INVISIBLE);
            bt5_2.setVisibility(View.INVISIBLE);
            bt5_3.setVisibility(View.INVISIBLE);
            bt5_4.setVisibility(View.INVISIBLE);

            bt5_6.setVisibility(View.INVISIBLE);
            licznik++;
            rz5=2;
            timerstop=true;
            pkt+= 11-(pktrz5/2);
            bt5_6.setText("0");

        }
        punkt.setText(String.valueOf(pkt));
        if (licznik==5)
        {
            Toast.makeText(getApplicationContext()
                    , "Przechodzisz do następnego poziomu!", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(Sredni.this, Sredni2.class);
//            startActivity(intent);
            Intent myIntent = new Intent(Latwy.this, Latwy2.class);
            myIntent.putExtra("Punkt", pkt);
            startActivity(myIntent);
        }





    }




}