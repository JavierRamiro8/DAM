package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.pmdm_2324.R;

import java.util.LinkedHashMap;

public class ut306ConversorTextoLetras extends AppCompatActivity {
    Button ut306FinalizarAnalisis;
    public static final String FRASE = "FRASE";
    public static final String LETRAS_MAS_REPETIDAS = "LETRAS_MAS_REPETIDAS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut306_conversor_texto_letras);
        ut306FinalizarAnalisis = findViewById(R.id.ut306FinalizarAnalisis);

        ut306FinalizarAnalisis.setOnClickListener(view -> {
            Intent i = getIntent();
            String frase = getIntent().getStringExtra(FRASE);
            LinkedHashMap<Character, Integer> letrasMasRepetidas = new LinkedHashMap<>();
            frase = frase.replaceAll(" ", "").toLowerCase();

            for (char letra : frase.toCharArray()) {
                if (Character.isLetter(letra)) {
                    letrasMasRepetidas.put(letra, letrasMasRepetidas.getOrDefault(letra, 0) + 1);
                }
            }

            // Crea el intent con las letras y la cantidad de veces que aparecen
            Intent resultIntent = new Intent();
            for (char letra : letrasMasRepetidas.keySet()) {
                int cantidad = letrasMasRepetidas.get(letra);
                resultIntent.putExtra(LETRAS_MAS_REPETIDAS + letra, cantidad);
            }

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}


