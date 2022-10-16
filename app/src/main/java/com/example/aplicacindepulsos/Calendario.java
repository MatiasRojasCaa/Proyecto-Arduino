package com.example.aplicacindepulsos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.view.Menu;


import java.util.ArrayList;

public class Calendario extends AppCompatActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        listView=(ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList=new ArrayList();

        arrayList.add("Pulso Minimo 67" + "  /  " + "Pulso Maximo 86");
        arrayList.add("Pulso Minimo 68" + "  /  " + "Pulso Maximo 87");
        arrayList.add("Pulso Minimo 69" + "  /  " + "Pulso Maximo 88");
        arrayList.add("Pulso Minimo 70" + "  /  " + "Pulso Maximo 89");
        arrayList.add("Pulso Minimo 71" + "  /  " + "Pulso Maximo 90");
        arrayList.add("Pulso Minimo 72" + "  /  " + "Pulso Maximo 91");
        arrayList.add("Pulso Minimo 73" + "  /  " + "Pulso Maximo 92");
        arrayList.add("Pulso Minimo 74" + "  /  " + "Pulso Maximo 93");
        arrayList.add("Pulso Minimo 75" + "  /  " + "Pulso Maximo 94");
        arrayList.add("Pulso Minimo 76" + "  /  " + "Pulso Maximo 95");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);


    }
}