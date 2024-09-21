package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ut306MainTextoContadorLetras extends AppCompatActivity {
    EditText ut306IntroducirTexto;
    TextView ut306MostrarResultado;
    Button ut306btAnalizar;
    private static final int UT306_CONVERSOR_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut306_main_texto_contador_letras);
        ut306btAnalizar = findViewById(R.id.ut306btAnalizar);
        ut306MostrarResultado = findViewById(R.id.ut306MostrarResultado);
        ut306IntroducirTexto = findViewById(R.id.ut306IntroducirTexto);

        ut306btAnalizar.setOnClickListener(view -> {
            String frase = ut306IntroducirTexto.getText().toString();
            Intent i = new Intent(this, ut306ConversorTextoLetras.class);
            i.putExtra(ut306ConversorTextoLetras.FRASE, frase);
            launcher.launch(i);
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        List<Map.Entry<Character, Integer>> letrasCantidadList = new ArrayList<>();

                        for (char letra = 'a'; letra <= 'z'; letra++) {
                            int cantidad = data.getIntExtra(ut306ConversorTextoLetras.LETRAS_MAS_REPETIDAS + letra, 0);
                            if (cantidad > 0) {
                                letrasCantidadList.add(new AbstractMap.SimpleEntry<>(letra, cantidad));
                            }
                        }

                        // Ordenar la lista en función de la cantidad
                        letrasCantidadList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

                        // Crear una cadena de texto ordenada
                        StringBuilder resultado = new StringBuilder();
                        for (Map.Entry<Character, Integer> entry : letrasCantidadList) {
                            resultado.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                        }

                        ut306MostrarResultado.setText(resultado.toString());
                    }
                }
            });

}
