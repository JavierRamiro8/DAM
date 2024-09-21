package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut01y02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmdm_2324.R;

import java.util.Random;

public class PiedraPapelTijera extends AppCompatActivity {
    ImageButton piedra, papel, tijeras;
    Button reiniciar;
    TextView contadorJugador, contadorMaquina, resultadoMaquina, resultadoPartida;

    View.OnClickListener manejador;
    int victoriasJugador = 0;
    int victoriasMaquina = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piedra_papel_tijera);
        piedra = findViewById(R.id.ut207btnnPiedra);
        papel = findViewById(R.id.ut207btnnPapel);
        tijeras = findViewById(R.id.ut207btnnTijeras);
        reiniciar = findViewById(R.id.ut207btnnReiniciar);
        contadorJugador = findViewById(R.id.ut207LbContadorJugador);
        contadorMaquina = findViewById(R.id.ut207LbContadorMaquina);
        resultadoMaquina = findViewById(R.id.ut207LbResultadoMaquina);
        resultadoPartida = findViewById(R.id.ut207LbResultado);

        manejador = (View botonPulsado) -> {
            if (victoriasJugador < 3 && victoriasMaquina < 3) {
                String tipoSeleccionado;
                ImageButton seleccionado = (ImageButton) botonPulsado;
                String eleccionMaquina = obtenerEleccionMaquina();
                String eleccionJugador = obtenerEleccionJugador(seleccionado);

                resultadoMaquina.setText("La máquina ha elegido " + eleccionMaquina);
                if (eleccionMaquina.equals(eleccionJugador)) {
                    resultadoPartida.setText("Empate");
                } else if (hasGanado(eleccionJugador, eleccionMaquina)) {
                    resultadoPartida.setText("Has Ganado");
                    victoriasJugador++;
                } else {
                    resultadoPartida.setText("Has Perdido");
                    victoriasMaquina++;
                }

                contadorJugador.setText(String.valueOf(victoriasJugador));
                contadorMaquina.setText(String.valueOf(victoriasMaquina));

                if (victoriasJugador == 3 || victoriasMaquina == 3) {
                    if (victoriasJugador == 3) {
                        resultadoPartida.setText("¡Has ganado el juego!");
                    } else {
                        resultadoPartida.setText("¡La máquina ha ganado el juego!");
                    }
                    piedra.setEnabled(false);
                    papel.setEnabled(false);
                    tijeras.setEnabled(false);
                }
            }
        };

        reiniciar.setOnClickListener((View v) -> {
            victoriasJugador = 0;
            victoriasMaquina = 0;
            contadorJugador.setText("0");
            contadorMaquina.setText("0");
            resultadoMaquina.setText("");
            resultadoPartida.setText("");
            piedra.setEnabled(true);
            papel.setEnabled(true);
            tijeras.setEnabled(true);
        });

        piedra.setOnClickListener(manejador);
        papel.setOnClickListener(manejador);
        tijeras.setOnClickListener(manejador);
    }



    private String obtenerEleccionMaquina() {
        String[] opciones = {"Piedra", "Papel", "Tijeras"};
        int indice = new Random().nextInt(opciones.length);
        return opciones[indice];
    }

    private String obtenerEleccionJugador(ImageButton seleccionado) {
        if (seleccionado == piedra) {
            return "Piedra";
        } else if (seleccionado == papel) {
            return "Papel";
        } else if (seleccionado == tijeras) {
            return "Tijeras";
        }
        return "";
    }

    private boolean hasGanado(String eleccionJugador, String eleccionMaquina) {
        return (eleccionJugador.equals("Piedra") && eleccionMaquina.equals("Tijeras"))
                || (eleccionJugador.equals("Papel") && eleccionMaquina.equals("Piedra"))
                || (eleccionJugador.equals("Tijeras") && eleccionMaquina.equals("Papel"));
    }
}
