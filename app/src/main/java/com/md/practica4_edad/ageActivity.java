package com.md.practica4_edad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ageActivity extends AppCompatActivity {
    public TextView TxtName;
    public TextView TxtAge;
    public ListView ListText;
    ArrayAdapter<String> listAdapter;
    public Double extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        TxtName = (TextView) findViewById(R.id.txtName);
        TxtAge = (TextView) findViewById(R.id.txtAge);
        ListText = (ListView) findViewById(R.id.listEdades);
        Bundle extras = getIntent().getExtras();
        extra = Double.parseDouble(extras.getString("Age"));
        Double[] text = {
                extra*12,
                extra*52.1429,
                extra*365,
                (extra*365)*24,
                (extra*365)*1440,
                (extra*365)*86400
        };
        String[] formatos = {
                "Meses: ",
                "Semanas: ",
                "Dias: ",
                "Horas: ",
                "Minutos: ",
                "Segundos: "
        };
        int size = text.length;
        String[] str = new String[size];
        for (int i = 0; i <size ; i++) {
            str[i] = String.valueOf(Math.round(text[i]));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        for (int i = 0; i < size; i++) {
            str[i] = formatos[i] + str[i];
        }
        TxtName.setText("Nombre: " + extras.getString("Name"));
        TxtAge.setText("Edad: " + extra.toString());
        ListText.setAdapter(adapter);
    }
}