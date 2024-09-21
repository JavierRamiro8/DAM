package com.example.pmdm_2324.ejerciciosBasicos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class EjemploBasicoIdaYVueltaLanza extends AppCompatActivity {
Button botonObtenerNumero;
TextView tvNumero;
TextView tvCancelado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut3prueba_basico_ida_yvuelta_lanza);
        botonObtenerNumero=findViewById(R.id.btPracticaObtenerNumero);
        tvNumero=findViewById(R.id.tvPracticaNumero);
        tvCancelado=findViewById(R.id.tvPracticaSalidaCancelada);

        botonObtenerNumero.setOnClickListener(View ->{
            Intent i= new Intent(this,EjemploBAsicoIdaYVueltaLanzada.class);
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
                        tvNumero.setText(data.getStringExtra(EjemploBAsicoIdaYVueltaLanzada.CLAVE_NUMERO));
                        tvCancelado.setText("");
                    }else if(result.getResultCode() == Activity.RESULT_CANCELED){
                        tvCancelado.setText("El usuario cancelo la operación");
                        tvCancelado.setTextColor(Color.RED);
                    }else{
                        tvCancelado.setText("No tenemos codigo");
                        tvCancelado.setTextColor(Color.RED);
                    }
                }
            }
    );
}