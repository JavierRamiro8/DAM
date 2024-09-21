package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut305SiguienteNumero extends AppCompatActivity {

    public static final String NUMERO1 = "NUMERO1";
    public static final String NUMERO2 = "NUMERO2";
    public static final String RESULTADO = "RESULTADO";

    TextView ut305tvResultado;

    Button ut305btCalcularFibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut305_siguiente_numero);
        ut305btCalcularFibo=findViewById(R.id.ut305btCalcularFibo);
        ut305tvResultado=findViewById(R.id.ut305tvResultado);
        Intent i= new Intent();
        int numero1;
        int numero2;
        int resultado;
        String n1=getIntent().getStringExtra(NUMERO1);
        String n2=getIntent().getStringExtra(NUMERO2);

        numero1=Integer.parseInt(n1);
        numero2=Integer.parseInt(n2);
        resultado=numero1+numero2;
        numero1=numero2;
        numero2=resultado;
        ut305tvResultado.setText("El resultado es: "+resultado);
        i.putExtra(NUMERO1,String.valueOf(numero1));
        i.putExtra(NUMERO2,String.valueOf(numero2));
        ut305btCalcularFibo.setOnClickListener(View ->{
            setResult(Activity.RESULT_OK,i);
            finish();

        });
    }
}