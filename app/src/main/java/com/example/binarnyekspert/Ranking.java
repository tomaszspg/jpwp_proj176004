package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/** Klasa wyświetlająca rekordy punktacji zebranych z gier na wszystkich poziomach i systemach liczbowych  */
public class Ranking extends AppCompatActivity implements View.OnClickListener {
    TextView l1,l2,l3,s1,s2,s3,t1,t2,t3,l31,l32,l33,s31,s32,s33,t31,t32,t33;
    Switch reset;
    Button resetbtn;
    int pktl1, pktl2, pktl3, pkts1, pkts2, pkts3, pktt1, pktt2, pktt3;
    int pktl31, pktl32, pktl33, pkts31, pkts32, pkts33, pktt31, pktt32, pktt33;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        reset = (Switch) findViewById(R.id.reset);
        resetbtn = (Button) findViewById(R.id.resetbtn); resetbtn.setOnClickListener(this);

        Button powrot = findViewById(R.id.powrot);
        l1 = (TextView)findViewById(R.id.l1);
        l2 = (TextView)findViewById(R.id.l2);
        l3 = (TextView)findViewById(R.id.l3);

        s1 = (TextView)findViewById(R.id.s1);
        s2 = (TextView)findViewById(R.id.s2);
        s3 = (TextView)findViewById(R.id.s3);

        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);

        l31 = (TextView)findViewById(R.id.l31);
        l32 = (TextView)findViewById(R.id.l32);
        l33 = (TextView)findViewById(R.id.l33);

        s31 = (TextView)findViewById(R.id.s31);
        s32 = (TextView)findViewById(R.id.s32);
        s33 = (TextView)findViewById(R.id.s33);

        t31 = (TextView)findViewById(R.id.t31);
        t32 = (TextView)findViewById(R.id.t32);
        t33 = (TextView)findViewById(R.id.t33);

/** powrót do menu  */
        powrot.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        });
        SharedPreferences sp = getSharedPreferences("ranking", Activity.MODE_PRIVATE);
        /** pobranie wartości z SharedPreferences  */
        pktl1 = sp.getInt("pktl1", 0);
        pktl2 = sp.getInt("pktl2", 0);
        pktl3 = sp.getInt("pktl3", 0);
        pkts1 = sp.getInt("pkts1", 0);
        pkts2 = sp.getInt("pkts2", 0);
        pkts3 = sp.getInt("pkts3", 0);
        pktt1 = sp.getInt("pktt1", 0);
        pktt2 = sp.getInt("pktt2", 0);
        pktt3 = sp.getInt("pktt3", 0);
        pktl31 = sp.getInt("pktl31", 0);
        pktl32 = sp.getInt("pktl32", 0);
        pktl33 = sp.getInt("pktl33", 0);
        pkts31 = sp.getInt("pkts31", 0);
        pkts32 = sp.getInt("pkts32", 0);
        pkts33 = sp.getInt("pkts33", 0);
        pktt31 = sp.getInt("pktt31", 0);
        pktt32 = sp.getInt("pktt32", 0);
        pktt33 = sp.getInt("pktt33", 0);
        /** wyświetlenie pobranych wartości na ekranie  */
        l1.setText(String.valueOf(pktl1));
        l2.setText(String.valueOf(pktl2));
        l3.setText(String.valueOf(pktl3));
        s1.setText(String.valueOf(pkts1));
        s2.setText(String.valueOf(pkts2));
        s3.setText(String.valueOf(pkts3));
        t1.setText(String.valueOf(pktt1));
        t2.setText(String.valueOf(pktt2));
        t3.setText(String.valueOf(pktt3));

        l31.setText(String.valueOf(pktl31));
        l32.setText(String.valueOf(pktl32));
        l33.setText(String.valueOf(pktl33));
        s31.setText(String.valueOf(pkts31));
        s32.setText(String.valueOf(pkts32));
        s33.setText(String.valueOf(pkts33));
        t31.setText(String.valueOf(pktt31));
        t32.setText(String.valueOf(pktt32));
        t33.setText(String.valueOf(pktt33));

        reset.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /** funkcja wyświetlająca przycisk służący do resetowania rekordów  */
            public void onCheckedChanged(CompoundButton reset, boolean isChecked) {
                if (reset.isChecked())
                {
                    resetbtn.setVisibility(View.VISIBLE);

                }
                else
                {
                    resetbtn.setVisibility(View.INVISIBLE);


                }
            }
        });





    }


    /** funkcja resetująca rekordy po wciśnięciu guzika  */
    public void onClick(View v) {
        if (v.getId() == R.id.resetbtn)
        {
            SharedPreferences sp = getSharedPreferences("ranking", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            l1.setText("0");
            l2.setText("0");
            l3.setText("0");
            pktl1=0; editor.putInt("pktl1", pktl1);
            pktl2=0; editor.putInt("pktl2", pktl2);
            pktl3=0; editor.putInt("pktl3", pktl3);

            s1.setText("0");
            s2.setText("0");
            s3.setText("0");
            pkts1=0; editor.putInt("pkts1", pkts1);
            pkts2=0; editor.putInt("pkts2", pkts2);
            pkts3=0; editor.putInt("pkts3", pkts3);

            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
            pktt1=0; editor.putInt("pktt1", pktt1);
            pktt2=0; editor.putInt("pktt2", pktt2);
            pktt3=0; editor.putInt("pktt3", pktt3);

            l31.setText("0");
            l32.setText("0");
            l33.setText("0");
            pktl31=0; editor.putInt("pktl31", pktl31);
            pktl32=0; editor.putInt("pktl32", pktl32);
            pktl33=0; editor.putInt("pktl33", pktl33);

            s31.setText("0");
            s32.setText("0");
            s33.setText("0");
            pkts31=0; editor.putInt("pkts31", pkts31);
            pkts32=0; editor.putInt("pkts32", pkts32);
            pkts33=0; editor.putInt("pkts33", pkts33);

            t31.setText("0");
            t32.setText("0");
            t33.setText("0");
            pktt31=0; editor.putInt("pktt31", pktt31);
            pktt32=0; editor.putInt("pktt32", pktt32);
            pktt33=0; editor.putInt("pktt33", pktt33);




            editor.commit();
        }
    }

}

