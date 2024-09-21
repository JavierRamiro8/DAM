package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2324.R;

public class u3MainaplicacionQueLanza extends AppCompatActivity {
Button ut3PruebaLanzar;
EditText editTextPrueba;
EditText u3PruebaLanzableeditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut3_mainaplicacion_que_lanza);
        ut3PruebaLanzar=findViewById(R.id.ut3PruebaLanzar);
        editTextPrueba=findViewById(R.id.u3PruebaLanzableeditText);
        u3PruebaLanzableeditText=findViewById(R.id.u3PruebaLanzableeditText);
        ut3PruebaLanzar.setOnClickListener(View ->{
            Intent i=new Intent(this,u3AplicacionLanzada.class);
            String INFO_NOMBRE=editTextPrueba.getText().toString();
            startActivity(i);
        });
    }
}