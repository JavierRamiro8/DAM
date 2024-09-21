package com.example.pmdm_2324.ut06_RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmdm_2324.R;

import java.util.ArrayList;

public class UT06Ejercicio1Navidad extends AppCompatActivity {
    RecyclerView recycler;

    Ut06Ejercicio1NavidadAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut06_ejercicio1_navidad);
        recycler = findViewById(R.id.ut06ListaDulcesNavidenios);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        // Crear y configurar el adaptador
        adapter = new Ut06Ejercicio1NavidadAdapter(Ut06Ejercicio1Dulces.generarDulcesNavidenios());
        recycler.setAdapter(adapter);
    }
}