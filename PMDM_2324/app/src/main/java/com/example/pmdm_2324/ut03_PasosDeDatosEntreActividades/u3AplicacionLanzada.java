package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3AplicacionLanzada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut3_aplicacion_lanzada);

        Bundle info=getIntent().getExtras();
        //String sInfo=info.getString(u3MainaplicacionQueLanza.INFO_NOMBRE);
        TextView tv=findViewById(R.id.ut3TvSalidaPrueba);
       // tv.setText(tv.getText() + sInfo);
    }
}