package com.example.pmdm_2324.ejerciciosBasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2324.R;

public class EjemploBAsicoIdaYVueltaLanzada extends AppCompatActivity {
    Button btEnviarNumero,btCancelar;
    EditText etNumero;
    public static final String CLAVE_NUMERO ="NOMBREKEYRANDOM" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut3prueba_basico_ida_yvuelta_lanzada);
        btEnviarNumero=findViewById(R.id.btPracticaEnviarNumero);
        btCancelar=findViewById(R.id.btPracticaCancelarNumero);
        etNumero=findViewById(R.id.etPracticaIntroducirNumero);

        btEnviarNumero.setOnClickListener(View->{
            Intent data= new Intent();
            data.putExtra(CLAVE_NUMERO,etNumero.getText().toString());
            setResult(Activity.RESULT_OK,data);
            finish();
        });
        btCancelar.setOnClickListener(View->{
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
    }
}