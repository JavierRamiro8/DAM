package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pmdm_2324.R;

public class ut307SelectorArmas extends AppCompatActivity {
    static final String ARMA ="ARMA";
    ImageButton ut307ImgArma1,ut307ImgArma2,ut307ImgArma3;
    Button ut307ImgArmaCancelar,ut307ImgArmaLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut307_selector_armas);
        ut307ImgArma1=findViewById(R.id.ut307ImgArma1);
        ut307ImgArma2=findViewById(R.id.ut307ImgArma2);
        ut307ImgArma3=findViewById(R.id.ut307ImgArma3);
        ut307ImgArmaCancelar=findViewById(R.id.ut307ImgArmaCancelar);
        ut307ImgArmaLimpiar=findViewById(R.id.ut307ImgArmaLimpiar);

        Intent data= new Intent();
        ut307ImgArma1.setOnClickListener(View ->{
            data.putExtra(ARMA,R.drawable.pistola4);
            setResult(RESULT_OK,data);
            finish();
        });
        ut307ImgArma2.setOnClickListener(View ->{
            data.putExtra(ARMA,R.drawable.fusil);
            setResult(RESULT_OK,data);
            finish();
        });
        ut307ImgArma3.setOnClickListener(View ->{
            data.putExtra(ARMA,R.drawable.escopeta);
            setResult(RESULT_OK,data);
            finish();
        });
        ut307ImgArmaCancelar.setOnClickListener(View ->{
            setResult(RESULT_CANCELED);
            finish();
        });
        ut307ImgArmaLimpiar.setOnClickListener(View ->{
            setResult(RESULT_FIRST_USER);
            finish();
        });
    }
}