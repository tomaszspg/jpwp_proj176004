package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
//WAŻNE: z poziomów szczegółowo zakomentowane zostało activity Latwy, gryż w innych aktywnościach w większości kod jest powtarzany

/**
 * Główna klasa aplikacji, uruchamia się na początku i zawiera przyciski przenoszące do poziomów oraz do aktywności ranking i pomoc
 * @author Tomasz Sochacki
 * */

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
        Button latwy3 = findViewById(R.id.latwy3);
        Button sredni3 = findViewById(R.id.sredni3);
        Button trudny3 = findViewById(R.id.trudny3);

        sredni.setOnClickListener(v -> {  //tworzenie intentów pozwalających na przeniesienie się do kolejnych aktywności po kliknięciu w przycisk
            Intent intent1 = new Intent(MainActivity.this, Sredni.class);
            startActivity(intent1);
        });
        latwy.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Latwy.class);
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
        latwy3.setOnClickListener(v -> {
            Intent intent5 = new Intent(MainActivity.this, Latwy3_1.class);
            startActivity(intent5);
        });
        sredni3.setOnClickListener(v -> {
            Intent intent6 = new Intent(MainActivity.this, Sredni3_1.class);
            startActivity(intent6);
        });
        trudny3.setOnClickListener(v -> {
            Intent intent7 = new Intent(MainActivity.this, Trudny3_1.class);
            startActivity(intent7);
        });



    }


    public void onClick(View view) {
    }
}

