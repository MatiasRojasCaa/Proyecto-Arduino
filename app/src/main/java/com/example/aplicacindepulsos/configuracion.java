package com.example.aplicacindepulsos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class configuracion extends AppCompatActivity {

    public void login(View v){
        Toast.makeText(this, "Buscando Dispositivo...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.op1) {
            Intent i = new Intent(this, Calendario.class);
            startActivity(i);
        }else if (id == R.id.op2) {
            Intent i = new Intent(this, configuracion.class);
            startActivity(i);
        }
        return false;
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