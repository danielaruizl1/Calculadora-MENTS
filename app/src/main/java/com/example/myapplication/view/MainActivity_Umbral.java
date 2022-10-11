package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity_Umbral extends AppCompatActivity {

    EditText um1, um2;
    int u1, u2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_umbral);

        um1 = (EditText) findViewById(R.id.et_u1);
        um2 = (EditText) findViewById(R.id.et_u2);
        u1 = Integer.parseInt(um1.getText().toString());
        u2 = Integer.parseInt(um2.getText().toString());


        cargarPreferencias();

        findViewById(R.id.button_regresar3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (((um1.getText().length() > 0) &&
                        (um2.getText().length() > 0) &&
                        (Integer.compare(u1,u2)==-1))){
                    guardarPreferencias();

                    Intent testIntent = new Intent(getApplicationContext(),MainActivityDP.class);
                    startActivity(testIntent);
                }
            }
        });

    }

    private void cargarPreferencias() {

        SharedPreferences umbrales=getSharedPreferences("umbrales", Context.MODE_PRIVATE);

        String u1 = umbrales.getString("um1", "-1");
        String u2 = umbrales.getString("um2", "-1");

        um1.setText(u1);
        um2.setText(u2);
    }

    private void guardarPreferencias() {

        SharedPreferences usuario=getSharedPreferences("umbrales", Context.MODE_PRIVATE);

        String u1 = um1.getText().toString();
        String u2 = um2.getText().toString();

        SharedPreferences.Editor editor=usuario.edit();

        editor.putString("um1", u1);
        editor.putString("um2", u2);

        editor.commit();
    }
}