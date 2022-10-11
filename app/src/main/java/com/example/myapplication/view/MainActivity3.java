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