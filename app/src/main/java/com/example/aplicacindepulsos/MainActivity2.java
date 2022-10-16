package com.example.aplicacindepulsos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    public void login(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


    private AppBarConfiguration appBarConfiguration;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=(ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList=new ArrayList();

        arrayList.add("Usuario1");
        arrayList.add("Usuario2");
        arrayList.add("Usuario3");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(MainActivity2.this,MainActivity.class));
                }else{
                    startActivity(new Intent(MainActivity2.this,MainActivity.class));
                }
            }
        });

    }
}