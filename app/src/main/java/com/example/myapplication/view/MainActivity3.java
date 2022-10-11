package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle datos = getIntent().getExtras();
        int num1 = datos.getInt("sum");

        TextView textview3 = findViewById(R.id.resultado);
        textview3.setText(String.valueOf(num1));

        TextView textview4 = findViewById(R.id.resultado2);

        SharedPreferences umbrales=getSharedPreferences("umbrales", Context.MODE_PRIVATE);
        int u1 = Integer.parseInt(umbrales.getString("u1", "-1"));
        int u2 = Integer.parseInt(umbrales.getString("u2", "-1"));

        String menor = "El valor es menor que el umbral inferior, \nEntonces se sugiere que no vaya a cirugia";
        String mayor = "El valor es mayor que el umbral superior, \nEntonces se sugiere que vaya a cirugia";
        String medio = "El valor Se encuentra entre umbrales, \nEntonces Se deja a consideración del médico";

        if (num1 < u1){
            textview4.setText(menor);
        }
        else if (num1 > u2){
            textview4.setText(mayor);
        }
        else{
            textview4.setText(medio);
        }

        findViewById(R.id.regresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarScore();
                Intent testIntent = new Intent(getApplicationContext(),MainActivityH.class);
                startActivity(testIntent);
            }
        });
    }
    private void guardarScore() {

        SharedPreferences usuario=getSharedPreferences("user", Context.MODE_PRIVATE);

        TextView textview3 = findViewById(R.id.resultado);

        SharedPreferences.Editor editor=usuario.edit();

        editor.putString("score", textview3.getText().toString());

        editor.commit();



    }
}