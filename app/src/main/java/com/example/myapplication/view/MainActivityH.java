package com.example.myapplication.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;


public class MainActivityH extends AppCompatActivity {

    ListView l;
    int contador = 0;
    String[] users = new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_h);

        if (contador == 0) {
            users[0] = "";
            users[1] = "";
            users[2] = "";
            users[3] = "";
            users[4] = "";
            cargarHistorial(contador, users);
            contador = guardarNumPaciente(contador);
        }
        else {
        cargarHistorial(contador, users);
        contador = guardarNumPaciente(contador);
        }



        findViewById(R.id.regresar2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), MainActivityDP.class);
                startActivity(backIntent);
            }
        });
    }
    private void cargarHistorial(int i, String paciente[]) {
        SharedPreferences usuario=getSharedPreferences
                ("user",MODE_PRIVATE);

        System.out.println(i);
        l = findViewById(R.id.lv);

        String cedula = usuario.getString("cedula", "xd");
        String name = usuario.getString("nombre","xd");
        String score = "Puntaje: ".concat(usuario.getString("score","xd"));
        String todo = "Paciente: ".concat(name).concat("-").concat(cedula)
                .concat(", ").concat(score);


        paciente[i] = todo;

        l = findViewById(R.id.lv);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>
                (this,
                        android.support.constraint.R.layout.support_simple_spinner_dropdown_item,
                        paciente);
        l.setAdapter(arr);
    }

    private int guardarNumPaciente(int c) {

        SharedPreferences usuario=getSharedPreferences("num_users", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=usuario.edit();

        editor.putString("nombre", String.valueOf(c+1));
        editor.commit();
        return c+1;
    }

}