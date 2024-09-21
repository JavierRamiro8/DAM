package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pmdm_2324.R;

public class ut307SelectorPersonajes extends AppCompatActivity {
ImageButton ut307ImgPersonaje1,ut307ImgPersonaje2,ut307ImgPersonaje3;
Button ut307btCancelar,ut307btLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut307_selector_personajes);
        ut307ImgPersonaje1=findViewById(R.id.ut307ImgPersonaje1);
        ut307ImgPersonaje2=findViewById(R.id.ut307ImgPersonaje2);
        ut307ImgPersonaje3=findViewById(R.id.ut307ImgPersonaje3);
        ut307btCancelar=findViewById(R.id.ut307btCancelar);
        ut307btLimpiar=findViewById(R.id.ut307btLimpiar);
        Intent data= new Intent();
        ut307ImgPersonaje1.setOnClickListener(View ->{
            data.putExtra("PERSONAJE1",R.drawable.metalslugpersonaje1);
            setResult(RESULT_OK,data);
            finish();
        });
        ut307ImgPersonaje2.setOnClickListener(View ->{
            data.putExtra("PERSONAJE2",R.drawable.metalslugpersonaje2);
            setResult(RESULT_OK,data);
            finish();
        });
        ut307ImgPersonaje3.setOnClickListener(View ->{
            data.putExtra("PERSONAJE3",R.drawable.metalslugpersonaje3);
            setResult(RESULT_OK,data);
            finish();
        });
        ut307btCancelar.setOnClickListener(View ->{
            setResult(RESULT_CANCELED);
            finish();
        });
        ut307btLimpiar.setOnClickListener(View ->{
            setResult(RESULT_FIRST_USER);
            finish();
        });
    }
}