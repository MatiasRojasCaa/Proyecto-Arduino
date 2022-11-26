package com.example.aplicacindepulsos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacindepulsos.Modelos.Perfil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {
    FirebaseDatabase database;
    ListView lvperfil;
    ArrayList<Perfil> perfiles;
    ArrayAdapter<Perfil> adaptadorPerfil;
    Button btncrear;
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etNombre = (EditText) findViewById(R.id.etNombre);
        lvperfil = (ListView) findViewById(R.id.lvperfil);
        btncrear = (Button) findViewById(R.id.btncrear);
        btncrear.setOnClickListener(v -> insertar());
        perfiles = new ArrayList<Perfil>();
        cargarBD();
    }


    public void insertar() {
        String nombre = etNombre.getText().toString();
        String key = UUID.randomUUID().toString();
        Perfil a = new Perfil(nombre);

        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Perfil");
        myRef.child(key).setValue(a);
    }

    private void cargarBD() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference perfilRef = database.getReference("Perfil");
        ValueEventListener perfilListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d : snapshot.getChildren()) {
                    perfiles.clear();
                    String nombre = d.child("nombre").getValue().toString();
                    Perfil a = new Perfil(nombre);
                    perfiles.add(a);

                    adaptadorPerfil = new ArrayAdapter<Perfil>(getApplicationContext(), android.R.layout.simple_list_item_1, perfiles);
                    lvperfil.setAdapter(adaptadorPerfil);
                    lvperfil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Perfil a = (Perfil) adapterView.getItemAtPosition(i);
                            Intent intencion = new Intent(getApplicationContext(),MainActivity.class);
                            Gson gson = new Gson();
                            String perfil = gson.toJson(a);
                            intencion.putExtra("perfil",perfil);
                            startActivity(intencion);
                        }
                    });
                }}

                @Override
                public void onCancelled (@NonNull DatabaseError error){
                    System.out.println("error");
                }
            };
        perfilRef.addValueEventListener(perfilListener);
        }
}

