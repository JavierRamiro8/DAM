package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut305SiguienteNumero.NUMERO1;
import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut305SiguienteNumero.NUMERO2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut305MainFibonacci extends AppCompatActivity {
    TextView ut305TvN1,ut305TvN2;
    Button ut305btSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut305_main_fibonacci);
        ut305TvN1=findViewById(R.id.ut305TvN1);
        ut305TvN2=findViewById(R.id.ut305TvN2);
        ut305btSiguiente=findViewById(R.id.ut305btSiguiente);
        ut305btSiguiente.setOnClickListener(View -> {
        Intent i=new Intent(this,ut305SiguienteNumero.class);
        String numero1=ut305TvN1.getText().toString();
        String numero2=ut305TvN2.getText().toString();
        i.putExtra(NUMERO1,numero1);
        i.putExtra(NUMERO2,numero2);
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
                        String resultadon1=data.getStringExtra(NUMERO1);
                        String resultadon2=data.getStringExtra(NUMERO2);
                        ut305TvN1.setText(resultadon1);
                        ut305TvN2.setText(resultadon2);
                    }
                }
            }
    );
}