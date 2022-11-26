package com.example.aplicacindepulsos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacindepulsos.Modelos.pulsoauto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pulsoautomatico extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference dataref;
    EditText hpulmin;
    EditText hpulmax;
    EditText cantregistros;
    Button checkhorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsoautomatico);
        hpulmin = (EditText) findViewById(R.id.hpulmin);
        hpulmax = (EditText) findViewById(R.id.hpulmax);
        cantregistros = (EditText) findViewById(R.id.cantregistros);
        checkhorario = (Button) findViewById(R.id.checkhorario);
        checkhorario.setOnClickListener(v -> insertar());
    }
    public void insertar() {
        String hpulsomin = hpulmin.getText().toString();
        String hpulsomax = hpulmax.getText().toString();
        String totalregistros = cantregistros.getText().toString();
        pulsoauto a = new pulsoauto(hpulsomin, hpulsomax, totalregistros);

        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("pulsoauto");
        myRef.setValue(a);
    }
}