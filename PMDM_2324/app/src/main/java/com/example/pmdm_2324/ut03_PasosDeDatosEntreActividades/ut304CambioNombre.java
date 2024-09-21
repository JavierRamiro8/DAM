package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

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

public class ut304CambioNombre extends AppCompatActivity {
    TextView tvNombre,tvError;
    Button btAceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut304_cambio_nombre);
        tvNombre=findViewById(R.id.ut304tvNombre);
        tvError=findViewById(R.id.ut304tvError);
        btAceptar=findViewById(R.id.ut304btCambioNombre);
        btAceptar.setOnClickListener(View ->{
            Intent i= new Intent(this, ut304AnonimoCambioNombre.class);
            launcher.launch(i);
        });
    }
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        tvNombre.setText(data.getStringExtra(ut304AnonimoCambioNombre.NOMBRE));
                        tvError.setText("Se ha actualizado el nombre");
                    }else if(result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setText("El usuario canceló la operación");
                        tvError.setTextColor(Color.RED);
                    } else{
                        tvNombre.setText("Anonimo");
                        tvError.setText("El usuario ha limpiado el nombre que se introdujo anteriormente");
                        tvError.setTextColor(Color.RED);
                    }
                }
            }
    );
}