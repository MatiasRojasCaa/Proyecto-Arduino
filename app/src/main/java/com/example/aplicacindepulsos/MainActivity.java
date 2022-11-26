package com.example.aplicacindepulsos;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {
    ImageButton gotest;
    DatabaseReference dataref;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
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
        }else if (id == R.id.op4) {
        Intent i = new Intent(this, Pulsolimite.class);
        startActivity(i);
        }else if (id == R.id.op3) {
            Intent i = new Intent(this, Pulsoautomatico.class);
            startActivity(i);
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        gotest = (ImageButton) findViewById(R.id.gotest);
        dataref = FirebaseDatabase.getInstance().getReference();


        gotest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = UUID.randomUUID().toString();
                dataref.child("Pulsotest").child(key).child("Pulso Mínimo").setValue("40");
                dataref.child("Pulsotest").child(key).child("Pulso Máximo").setValue("100");
            }});

        }

    }
