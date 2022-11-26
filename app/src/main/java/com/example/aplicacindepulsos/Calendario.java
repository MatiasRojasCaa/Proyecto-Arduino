package com.example.aplicacindepulsos;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aplicacindepulsos.Modelos.pulsotest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Calendario extends AppCompatActivity {
    ArrayList<pulsotest> pulsotests;
    ArrayAdapter<pulsotest> adaptadorpulso;
    FirebaseDatabase database;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }
    ListView lvperfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        lvperfil = (ListView) findViewById(R.id.lvperfil);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        pulsotests = new ArrayList<pulsotest>();
        cargarBD();

    }
    private void cargarBD() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference pulsoRef = database.getReference("Pulsotest");
        ValueEventListener pulsoListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d : snapshot.getChildren()) {
                    String pulmin = d.child("Pulso Mínimo").getValue().toString();
                    String pulmax = d.child("Pulso Máximo").getValue().toString();
                    pulsotest a = new pulsotest(pulmin, pulmax);
                    pulsotests.add(a);

                    adaptadorpulso = new ArrayAdapter<pulsotest>(getApplicationContext(), android.R.layout.simple_list_item_1, pulsotests);
                    lvperfil.setAdapter(adaptadorpulso);
                    lvperfil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            pulsotest a = (pulsotest) adapterView.getItemAtPosition(i);
                            Intent intencion = new Intent(getApplicationContext(),MainActivity.class);
                            Gson gson = new Gson();
                            String pulsotest = gson.toJson(a);
                            intencion.putExtra("pulsotest",pulsotest);
                            startActivity(intencion);
                        }
                    });
                }}

            @Override
            public void onCancelled (@NonNull DatabaseError error){
                System.out.println("error");
            }
        };
        pulsoRef.addValueEventListener(pulsoListener);
    }

}