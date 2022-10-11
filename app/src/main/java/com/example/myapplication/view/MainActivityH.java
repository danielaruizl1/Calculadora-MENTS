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
import android.widget.TextView;

import java.util.Objects;


public class MainActivityH extends AppCompatActivity {

    ListView l;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_h);


        SharedPreferences historial=getSharedPreferences("Historial", Context.MODE_PRIVATE);
        String c = historial.getString("contador", "-1");


        if (Objects.equals(c, "-1")){
            contador = 0;
        }
        else{
        contador= Integer.parseInt(c);
        }

        cargarHistorial(contador);

        String[] users = new String[10];
        users[0] = historial.getString("u0", "-1");
        users[1] = historial.getString("u1", "-1");
        users[2] = historial.getString("u2", "-1");
        users[3] = historial.getString("u3", "-1");
        users[4] = historial.getString("u4", "-1");
        users[5] = historial.getString("u5", "-1");
        users[6] = historial.getString("u6", "-1");
        users[7] = historial.getString("u7", "-1");
        users[8] = historial.getString("u8", "-1");
        users[9] = historial.getString("u9", "-1");

        guardarUsuarios(contador, users);





        findViewById(R.id.regresar2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), MainActivityDP.class);
                startActivity(backIntent);
            }
        });
    }
    private void cargarHistorial(int i) {

        SharedPreferences usuario=getSharedPreferences
                ("user",MODE_PRIVATE);

        String cedula = usuario.getString("cedula", "xd");
        String name = usuario.getString("nombre","xd");
        String score = "Puntaje: ".concat(usuario.getString("score","xd"));
        String todo = "Paciente: ".concat(name).concat("-").concat(cedula)
                .concat(", ").concat(score);


        SharedPreferences historial=getSharedPreferences("Historial", Context.MODE_PRIVATE);
        if (i>0) {
            String anterior = historial.getString("u".concat(String.valueOf(i - 1)), "xd");
            if (!Objects.equals(anterior, todo)){
                SharedPreferences.Editor editor=historial.edit();
                editor.putString("u".concat(String.valueOf(i)), todo);
                editor.putString("contador", String.valueOf(i+1));
                editor.commit();
            }
        }else{
            SharedPreferences.Editor editor=historial.edit();
            editor.putString("u".concat(String.valueOf(i)), todo);
            editor.putString("contador", String.valueOf(i+1));
            editor.commit();
        }
        
    }

    private void guardarUsuarios(int i, String[] pacientes) {

        l = findViewById(R.id.lv);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>
                (this,
                        android.support.constraint.R.layout.support_simple_spinner_dropdown_item,
                        pacientes);
        l.setAdapter(arr);
    }

}