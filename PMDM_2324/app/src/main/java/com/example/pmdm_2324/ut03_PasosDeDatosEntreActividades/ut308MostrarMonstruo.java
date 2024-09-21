package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut308MostrarMonstruo extends AppCompatActivity {
    public static final String MONSTRUO="MONSTRUO";
    TextView ut308MostrarMonstruo,ut308MostrarNombreMonstruo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut308_mostrar_monstruo);
        ut308MostrarMonstruo=findViewById(R.id.ut308MostrarMonstruo);
        ut308MostrarNombreMonstruo=findViewById(R.id.ut308MostrarNombreMonstruo);
        Intent data=getIntent();
        if (data.hasExtra(MONSTRUO)) {
            Monstruo monstruoRecibido = (Monstruo) data.getSerializableExtra(MONSTRUO);
            ut308MostrarMonstruo.setTextColor(Color.parseColor(monstruoRecibido.getColor()));
            ut308MostrarMonstruo.append(monstruoRecibido.toString());
        } else {
            ut308MostrarMonstruo.setText("No se recibió un monstruo válido");
        }
    }
}