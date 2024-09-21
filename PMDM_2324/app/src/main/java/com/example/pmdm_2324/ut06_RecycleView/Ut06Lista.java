package com.example.pmdm_2324.ut06_RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_2324.R;

public class Ut06Lista extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Button add;
    Ut06PartidoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut06_partidos);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut03ListaContenedor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new Ut06PartidoAdapter(Ut06Partidos.generatePartidos(Ut06Partidos.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.ut03idListaAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(Ut06Partidos.generatePartidos(Ut06Partidos.PARTIDOS_INICIALES));
            }
        });

        //adapter.notifyDataSetChanged();
    }
}
