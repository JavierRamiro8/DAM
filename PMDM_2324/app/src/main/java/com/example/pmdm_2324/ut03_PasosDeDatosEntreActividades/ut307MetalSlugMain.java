package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut307SelectorArmas.ARMA;
import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut307SelectorPersonajesJugador1.PERSONAJE1;
import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut307SelectorPersonajesJugador2.PERSONAJE2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import com.example.pmdm_2324.R;

public class ut307MetalSlugMain extends AppCompatActivity {

    ImageButton ut307ImgPersonajeOcultoP1, ut307ImgPersonajeOcultoP2, ut307ImgArmaOcultaP1, ut307ImgArmaOcultaP2;
    int personajeSeleccionadoP1 = -1;
    int personajeSeleccionadoP2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut307_metal_slug_main);
        ut307ImgPersonajeOcultoP1 = findViewById(R.id.ut307ImgPersonajeOcultoP1);
        ut307ImgPersonajeOcultoP2 = findViewById(R.id.ut307ImgPersonajeOcultoP2);
        ut307ImgArmaOcultaP1 = findViewById(R.id.ut307ImgArmaOcultaP1);
        ut307ImgArmaOcultaP2 = findViewById(R.id.ut307ImgArmaOcultaP2);

        ut307ImgPersonajeOcultoP1.setOnClickListener(View -> {
            Intent i = new Intent(this, ut307SelectorPersonajesJugador1.class);
            i.putExtra("PERSONAJESELECCIONADO", personajeSeleccionadoP2);
            lanzadorPersonajes1.launch(i);
        });
        ut307ImgPersonajeOcultoP2.setOnClickListener(View -> {
            Intent i = new Intent(this, ut307SelectorPersonajesJugador2.class);
            i.putExtra("PERSONAJESELECCIONADO", personajeSeleccionadoP1);
            lanzadorPersonajes2.launch(i);
        });
        ut307ImgArmaOcultaP1.setOnClickListener(View -> {
            Intent i = new Intent(this, ut307SelectorArmas.class);
            lanzadorArmas1.launch(i);
        });
        ut307ImgArmaOcultaP2.setOnClickListener(View -> {
            Intent i = new Intent(this, ut307SelectorArmas.class);
            lanzadorArmas2.launch(i);
        });
    }

    ActivityResultLauncher<Intent> lanzadorPersonajes1 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        int imagenEscogida = data.getIntExtra(PERSONAJE1, 0);
                        ut307ImgPersonajeOcultoP1.setImageResource(imagenEscogida);
                        personajeSeleccionadoP1 = imagenEscogida;
                    } else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ut307ImgPersonajeOcultoP1.setImageResource(R.drawable.personajeoculto);
                        personajeSeleccionadoP1 = -1;
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> lanzadorPersonajes2 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        int imagenEscogida = data.getIntExtra(PERSONAJE2, 0);
                        ut307ImgPersonajeOcultoP2.setImageResource(imagenEscogida);
                        personajeSeleccionadoP2 = imagenEscogida;
                    } else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ut307ImgPersonajeOcultoP2.setImageResource(R.drawable.personajeoculto);
                        personajeSeleccionadoP2 = -1;
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> lanzadorArmas1 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    int imagenEscogida=0;
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        imagenEscogida = data.getIntExtra(ARMA, 0);
                        ut307ImgArmaOcultaP1.setImageResource(imagenEscogida);
                    } else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ut307ImgArmaOcultaP1.setImageResource(R.drawable.siluetapistola);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> lanzadorArmas2 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                     int imagenEscogida=0;
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        imagenEscogida = data.getIntExtra(ARMA, 0);
                        ut307ImgArmaOcultaP2.setImageResource(imagenEscogida);
                    } else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ut307ImgArmaOcultaP2.setImageResource(R.drawable.siluetapistola);
                    }
                }
            }
    );
}



