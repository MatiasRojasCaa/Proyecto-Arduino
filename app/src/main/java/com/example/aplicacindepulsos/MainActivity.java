package com.example.aplicacindepulsos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        TabLayout tl = (TabLayout) findViewById(R.id.tablayout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        pulso pulse = new pulso();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, pulse).commit();
                        break;
                    case 1:
                        selecthorarioo sh = new selecthorarioo();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, sh).commit();
                        break;
                    case 2:
                        elechorario eh = new elechorario();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, eh).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        pulso pulse = new pulso();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, pulse).commit();
                        break;
                    case 1:
                        selecthorarioo sh = new selecthorarioo();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, sh).commit();
                        break;
                    case 2:
                        elechorario eh = new elechorario();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, eh).commit();
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        pulso pulse = new pulso();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, pulse).commit();
                        break;
                    case 1:
                        selecthorarioo sh = new selecthorarioo();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, sh).commit();
                        break;
                    case 2:
                        elechorario eh = new elechorario();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, eh).commit();
                        break;
                }
            }
        });

    }
}