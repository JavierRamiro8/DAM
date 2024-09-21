package com.example.pmdm_2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut8a2_CalculadoraSuma extends AppCompatActivity {
     EditText numero1;
     EditText numero2;
     TextView resultado;
     ProgressBar carga;
     Button sumar;
     public static int numero1Suma=0;

    public static int numero2Suma=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut8a2_calculadora_suma);
        numero1=findViewById(R.id.ut08e2EdNumero1);
        numero2=findViewById(R.id.ut08e2EdNumero2);
        resultado=findViewById(R.id.ut08e2TvResultadoSuma);
        carga=findViewById(R.id.ut08e2Carga);
        sumar=findViewById(R.id.ut8a2BtSuma);
        carga.setVisibility(View.VISIBLE);
        ut8a2_CalculadoraSumaViewModel vm=new ViewModelProvider(this).get(ut8a2_CalculadoraSumaViewModel.class);
        vm.getNumeroSuma().observe(this,integer -> {
            //Actualizas la interfaz en esta parte
            resultado.setText(""+integer);
            carga.setVisibility(View.INVISIBLE);
            resultado.setVisibility(View.VISIBLE);
        });
        sumar.setOnClickListener(view -> {
            numero1Suma=Integer.parseInt(numero1.getText().toString());
            numero2Suma=Integer.parseInt(numero2.getText().toString());
            carga.setVisibility(View.VISIBLE);
            resultado.setVisibility(View.INVISIBLE);
            vm.cargaSuma(numero1Suma,numero2Suma);
        });
    }
}