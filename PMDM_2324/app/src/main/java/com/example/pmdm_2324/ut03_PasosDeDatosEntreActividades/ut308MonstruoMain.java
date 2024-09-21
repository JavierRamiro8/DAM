package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut308MostrarMonstruo.MONSTRUO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm_2324.R;

public class ut308MonstruoMain extends AppCompatActivity {
    Button ut308btEnviar;
    EditText ut308etColor, ut308etNombre, ut308etNumeroExtremidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut308_monstruo_main);
        ut308btEnviar = findViewById(R.id.ut308btEnviar);
        ut308etColor = findViewById(R.id.ut308etColor);
        ut308etNombre = findViewById(R.id.ut308etNombre);
        ut308etNumeroExtremidades = findViewById(R.id.ut308etNumeroExtremidades);
        ut308btEnviar.setOnClickListener(view -> {
            String nombre = ut308etNombre.getText().toString();
            String color = ut308etColor.getText().toString();
            int extremidades = 0;
            if (!ut308etNumeroExtremidades.getText().toString().isEmpty()) {
                extremidades = Integer.parseInt(ut308etNumeroExtremidades.getText().toString());
            } else {
                ut308etNumeroExtremidades.setError("Introduce un número de extremidades");
            }

            if (!nombre.isEmpty() && !color.isEmpty() && extremidades > 0) {
                Monstruo monstruoEnviado = new Monstruo(nombre, extremidades, color);
                Intent i = new Intent(this, ut308MostrarMonstruo.class);
                i.putExtra(MONSTRUO, monstruoEnviado);
                startActivity(i);
            } else {
                if (nombre.isEmpty()) {
                    ut308etNombre.setError("Introduce un Nombre");
                }
                if (color.isEmpty()) {
                    ut308etColor.setError("Introduce un color");
                }
                if (extremidades <= 0) {
                    ut308etNumeroExtremidades.setError("El número de extremidades debe ser mayor que 0");
                }
            }
        });
    }
}
