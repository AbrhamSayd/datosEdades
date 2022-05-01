package com.md.practica4_edad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public EditText TxtName;
public EditText TxtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtName = (EditText)findViewById(R.id.EtxtName);
        TxtAge = (EditText)findViewById(R.id.EtxtAge);

    }
    public void sendOnClick(View view){
        String name = String.valueOf(TxtName.getText());
        String age = String.valueOf(TxtAge.getText());
        Boolean ageEmpty = false;
        Boolean nameEmpty = false;
        if (age.equals("")) {
             ageEmpty = true;
        }
        if (name.equals("")) {
             nameEmpty = true;
        }
        if (nameEmpty || ageEmpty){
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Valores faltantes")
                    .setMessage("Porfavor introduzca todos los campos")
                    .setPositiveButton("Entendido",null);
            builder.show();
        } else{
            Intent intent = new Intent(this, ageActivity.class);
            intent.putExtra("Name", name);
            intent.putExtra("Age", age);
            startActivity(intent);
        }
        
    }
}