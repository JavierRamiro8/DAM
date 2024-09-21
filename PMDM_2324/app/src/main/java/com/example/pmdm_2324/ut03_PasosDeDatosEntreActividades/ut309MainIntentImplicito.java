package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.example.pmdm_2324.R;

public class ut309MainIntentImplicito extends AppCompatActivity {
    Button ut309btCancion, ut309btMarcarNumero, ut309btSMS, ut309btEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut309_main_intent_implicito);
        ut309btCancion = findViewById(R.id.ut309btCancion);
        ut309btMarcarNumero = findViewById(R.id.ut309btMarcarNumero);
        ut309btSMS = findViewById(R.id.ut309btSMS);
        ut309btEleccion=findViewById(R.id.ut309btEleccion);

        ut309btCancion.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://youtube.com/watch?v=1C6lxliErIs&si=ACPQ_A52uPPy8FSD");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        ut309btMarcarNumero.setOnClickListener(view -> {
            Uri uri = Uri.parse("tel:666");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        });

        ut309btSMS.setOnClickListener(view -> {
            Uri uri = Uri.parse("smsto:");
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", "Te veo hoy a las 6pm");
            startActivity(intent);
        });

        ut309btEleccion.setOnClickListener(view -> {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode("IES Juan de la Cierva, Calle de la Caoba, Madrid"));
                Intent mapa = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapa.setPackage("com.google.android.apps.maps");
                startActivity(mapa);
        });
    }
}