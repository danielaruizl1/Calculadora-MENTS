package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.text.Editable;
import android.widget.EditText;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button inicio;
    EditText mail, pass;
    Boolean cond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.repsuestaemail);
        pass = findViewById(R.id.respuestacontraseña);
        inicio = findViewById(R.id.inicio);

        SharedPreferences historial=getSharedPreferences("Historial", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=historial.edit();
        editor.putString("contador", "-1");
        editor.putString("u0", "-");
        editor.putString("u1", "-");
        editor.putString("u2", "-");
        editor.putString("u3", "-");
        editor.putString("u4", "-");
        editor.putString("u5", "-");
        editor.putString("u6", "-");
        editor.putString("u7", "-");
        editor.putString("u8", "-");
        editor.putString("u9", "-");
        editor.commit();

        SharedPreferences usuario=getSharedPreferences("umbrales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor_u=usuario.edit();
        editor_u.putString("um1", "50");
        editor_u.putString("um2", "110");
        editor.commit();

        findViewById(R.id.inicio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mail.getText().length() > 0 && pass.getText().length() > 0) {
                    Intent testIntent = new Intent(getApplicationContext(), MainActivityDP.class);
                    startActivity(testIntent);
                }
            }
        });
}

}