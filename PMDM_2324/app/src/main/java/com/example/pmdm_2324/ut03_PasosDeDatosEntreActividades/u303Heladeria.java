package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u303Heladeria extends AppCompatActivity {

    EditText numVainilla,numChocolate,numFresa;
    Button aceptar;

    TextView error;

    Spinner tipos;

    public static final String VAINILLA="VAINILLA";
    public static final String CHOCOLATE="CHOCOLATE";
    public static final String FRESA="FRESA";
    public static final String TIPOTARRINA="TIPOTARRINA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut303_heladeria);
        numVainilla= findViewById(R.id.ut303numVainilla);
        numFresa= findViewById(R.id.ut303numFresa);
        numChocolate= findViewById(R.id.ut303numChocolate);
        aceptar=findViewById(R.id.u303btAceptar);
        tipos=findViewById(R.id.u303TiposHelados);
        error=findViewById(R.id.u303tvErrores);
        aceptar.setOnClickListener(view -> {
            Intent i=new Intent(this, u303ResultadoHeladeria.class);
            if(numChocolate.getText().toString().isEmpty() && numVainilla.getText().toString().isEmpty() && numFresa.getText().toString().isEmpty()){
                error.setText("Elige al menos una bola de helado");
            }else{
                if(!numChocolate.getText().toString().isEmpty()){
                    i.putExtra(CHOCOLATE,numChocolate.getText().toString());
                }
                if(!numVainilla.getText().toString().isEmpty()){
                    i.putExtra(VAINILLA,numVainilla.getText().toString());
                }
                 if(!numFresa.getText().toString().isEmpty()){
                    i.putExtra(FRESA,numFresa.getText().toString());
                }
                i.putExtra(TIPOTARRINA,tipos.getSelectedItem().toString());
                startActivity(i);
            }
        });
    }
}