package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button guzik = findViewById(R.id.guzik);
        Button guzik2 = findViewById(R.id.guzik2);

        guzik.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, Level.class);
            startActivity(intent1);
        });
        guzik2.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Level2.class);
            startActivity(intent2);
        });


    }


    public void onClick(View view) {
    }
}

