package com.example.aplicacindepulsos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacindepulsos.Modelos.Limitpulso;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pulsolimite extends AppCompatActivity {

    public EditText etpulsomax;
    public EditText etpulsomin;
    public TextView textpulsomin;
    public TextView textpulsomax;
    public Button regispulso;
    FirebaseDatabase database;
    DatabaseReference dataref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsolimite);

        etpulsomax = (EditText) findViewById(R.id.etpulsomax);
        etpulsomin = (EditText) findViewById(R.id.etpulsomin);
        textpulsomax = (TextView) findViewById(R.id.textpulsomax);
        textpulsomin = (TextView) findViewById(R.id.textpulsomin);
        regispulso = (Button) findViewById(R.id.regispulso);
        regispulso.setOnClickListener(v -> insertar());
        dataref = FirebaseDatabase.getInstance().getReference();
        cargarbd();

    }

    public void insertar() {
        String pulsomin = etpulsomin.getText().toString();
        String pulsomax = etpulsomax.getText().toString();
        Limitpulso a = new Limitpulso(pulsomax, pulsomin);

        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Limitpulso");
        myRef.setValue(a);
    }

    public void cargarbd(){
        dataref.child("Limitpulso");
        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d : snapshot.getChildren()) {
                    try {
                        String etpulsomin = d.child("etpulsomin").getValue().toString();
                        String etpulsomax = d.child("etpulsomax").getValue().toString();
                        textpulsomin.setText("Pulso Mínimo: " + etpulsomin);
                        textpulsomax.setText("Pulso Maximo: " + etpulsomax);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}