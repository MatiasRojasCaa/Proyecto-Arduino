package com.example.aplicacindepulsos;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class configuracion extends AppCompatActivity {

    public void login(View v){
        Toast.makeText(this, "Buscando Dispositivo...", Toast.LENGTH_SHORT).show();
    }

    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        switch1 = (Switch) findViewById(R.id.switch1);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
    }

    public void verificar(View view){
        if (switch1.isChecked())
            Toast.makeText(this, "Se han activado las notificaciones", Toast.LENGTH_SHORT).show();
        else
                Toast.makeText(this, "Se han desactivado las notificaciones", Toast.LENGTH_SHORT).show();
    }

}