package com.example.pmdm_2324.ut05;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.example.pmdm_2324.R;

public class EjemploPermisosAvanzados extends AppCompatActivity {
    Button boton;
    ActivityResultLauncher<String> requestPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_permisos_avanzados);
        boton = findViewById(R.id.permisosAvanzadosBtn);

        // Configurar el ActivityResultLauncher en el onCreate
        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                // Permiso concedido, realizar la acción
                llamar();
            } else {
                // Permiso denegado, mostrar mensaje al usuario
                Toast.makeText(this, "Necesitamos permiso para realizar la llamada", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el OnClickListener del botón
        boton.setOnClickListener(v -> {
            // Verificar si ya se tiene el permiso
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.INTERNET) ==
                    PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, realizar la acción
                llamar();
            } else {
                // Solicitar permiso al usuario
                requestPermissionLauncher.launch(Manifest.permission.INTERNET);
            }
        });
    }

    private void llamar() {
        Uri uri=Uri.parse("https://www.myprotein.es/?affil=mpppc&affil=mpppc_campaign=71700000079726222&adtype=&product_id=&gad_source=1&gclid=Cj0KCQiAtaOtBhCwARIsAN_x-3K4VHneWM3r6cflrr4yEsgz9fP02THEPqFG-lgtdreM370PDHHyMN8aAuCrEALw_wcB&gclsrc=aw.ds");
        Intent phoneIntent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(phoneIntent);
    }
}

