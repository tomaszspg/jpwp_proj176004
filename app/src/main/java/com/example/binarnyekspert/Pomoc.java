package com.example.binarnyekspert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class Pomoc extends AppCompatActivity implements View.OnClickListener {
    TextView tekst;
    Button powrot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomoc);
        TextView tekst= (TextView) findViewById(R.id.tekst);
        Button powrot = findViewById(R.id.powrot);
        tekst.setMovementMethod(new ScrollingMovementMethod());
        tekst.setText(Html.fromHtml("<p style=\"text-align: center;\"><strong>Systemy liczbowe</strong></p>\n" +
                "<p><strong>1. Dziesiętny (Decymalny)</strong></p>\n" +
                "<p>Dla przeciętnego użytkownika komputer&oacute;w i nie tylko, najważniejszym i najbardziej znanym jest system dziesiętny. W tym systemie każdy od dziecka uczy się liczyć.</p>\n" +
                "<p>W systemie decymalnym (dziesiętnym) do zapisu liczb stosuje się 10 cyfr: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10. Liczby zapisuje się jako ciąg cyfr, z kt&oacute;rych każda jest mnożnikiem kolejnej potęgi liczby 10.</p>\n" +
                "<p>Przykład:</p>\n" +
                "<p>424<sub>(10)</sub> = 4*10<sup>2</sup> + 2*10<sup>1</sup> + 4*10<sup>0</sup>= 400 + 20 + 4</p>\n" +
                "<p><strong>2. Dw&oacute;jkowy (Binarny)</strong></p>\n" +
                "<p>Urządzenia cyfrowe wykorzystują dw&oacute;jkowy system liczbowy, kt&oacute;rego podstawą jest cyfra 2. Liczby zapisuje się używając dw&oacute;ch cyfr arabskich 0 oraz 1.</p>\n" +
                "<p>W systemie dw&oacute;jkowym do zapisu liczb stosuje się 2 cyfry: 0 oraz 1. Liczby zapisuje się jako ciąg cyfr, z kt&oacute;rych każda jest mnożnikiem kolejnej potęgi liczby 2.</p>\n" +
                "<p>Przykład:</p>\n" +
                "<p>101011<sub>(2)</sub>&nbsp;= 2<sup>5</sup>&nbsp;+ 2<sup>3</sup>&nbsp;+ 2<sup>1</sup>&nbsp;+ 2<sup>0</sup>&nbsp;=</p>\n" +
                "<p>32 + 8 + 2 + 1 = 43<sub>(10)</sub></p>\n" +
                "<p><strong>3. Tr&oacute;jkowy</strong></p>\n" +
                "<p>Jest to pozycyjny system liczbowy, w kt&oacute;rym podstawą jest liczba 3. Do zapisu liczb są potrzebne 3 cyfry: 0, 1 i 2. Cyfry tr&oacute;jkowe często nazywa się tritami na podobieństwo bit&oacute;w w systemie binarnym.</p>\n" +
                "<p>Przykład: 1012<sub>(3)</sub> = 1*3<sup>3</sup>+0*3<sup>2</sup>+1*3<sup>1</sup>+2*3<sup>0</sup> = 27+5 = 32<sub>(10)</sub></p>"));


        powrot.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        });


    }


    public void onClick(View v) {
        if (v.getId() == R.id.resetbtn) {

        }

    }
}

