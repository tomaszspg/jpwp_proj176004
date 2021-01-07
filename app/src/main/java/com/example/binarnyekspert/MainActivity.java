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

        Button sredni = findViewById(R.id.sredni);
        Button latwy = findViewById(R.id.latwy);
        Button trudny = findViewById(R.id.trudny);
        Button pomoc = findViewById(R.id.pomoc);
        Button ranking = findViewById(R.id.ranking);

        sredni.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, Sredni3.class);
            startActivity(intent1);
        });
        latwy.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Latwy3.class);
            startActivity(intent2);
        });
        trudny.setOnClickListener(v -> {
            Intent intent5 = new Intent(MainActivity.this, Trudny.class);
            startActivity(intent5);
        });
        pomoc.setOnClickListener(v -> {
            Intent intent3 = new Intent(MainActivity.this, Pomoc.class);
            startActivity(intent3);
        });
        ranking.setOnClickListener(v -> {
            Intent intent4 = new Intent(MainActivity.this, Ranking.class);
            startActivity(intent4);
        });



    }


    public void onClick(View view) {
    }
}

