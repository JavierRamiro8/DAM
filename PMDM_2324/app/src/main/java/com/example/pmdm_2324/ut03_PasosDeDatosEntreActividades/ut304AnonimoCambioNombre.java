package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2324.R;

public class ut304AnonimoCambioNombre extends AppCompatActivity {

    public static final String NOMBRE ="UNNOMBRERANDOM";
    EditText tvCambioNombre;
    Button aceptar,cancelar,limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut304_anonimo_cambio_nombre);
        tvCambioNombre=findViewById(R.id.ut304etCambioNombre);
        aceptar=findViewById(R.id.ut304btAceptar);
        cancelar=findViewById(R.id.ut304btCancelar);
        limpiar=findViewById(R.id.ut304btLimpiar);
        aceptar.setOnClickListener(View ->{
            Intent data= new Intent();
            data.putExtra(NOMBRE,tvCambioNombre.getText().toString());
            setResult(Activity.RESULT_OK,data);
            finish();
        });
        cancelar.setOnClickListener(View ->{
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
        limpiar.setOnClickListener(View ->{
            setResult(Activity.RESULT_FIRST_USER);
            finish();
        });
    }
}