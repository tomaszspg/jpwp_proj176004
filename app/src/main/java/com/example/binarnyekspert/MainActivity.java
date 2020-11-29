package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button guzik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guzik = (Button) findViewById(R.id.guzik);
        guzik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel();
            }
        });


    }
    @Override
    public void onClick(View v) {
        openLevel();
    }
    public void openLevel(){
        Intent intent = new Intent(this, Level.class);
        startActivity(intent);
    }

}

