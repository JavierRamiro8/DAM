package com.example.pmdm_2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut8a1NumeroAleatorioPrimo extends AppCompatActivity {
TextView tvNumero;
Button btGenerar;
ProgressBar pBCargando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut8_a1_numero_aleatorio_primo);
       tvNumero=findViewById(R.id.ut08a1TvNumero);
       btGenerar=findViewById(R.id.ut8a1BtLogin);
       pBCargando=findViewById(R.id.ut08a1Carga);

        ut8a1_numeroAleatorioViewModel vm=new ViewModelProvider(this).get(ut8a1_numeroAleatorioViewModel.class);
        vm.getNumeros().observe(this,integer -> {
            //Actualizas la interfaz en esta parte
            tvNumero.setText(""+integer);
            pBCargando.setVisibility(View.INVISIBLE);
            tvNumero.setVisibility(View.VISIBLE);
            btGenerar.setEnabled(true);
        });
        btGenerar.setOnClickListener(v -> {
            pBCargando.setVisibility(View.VISIBLE);
            tvNumero.setVisibility(View.INVISIBLE);
            btGenerar.setEnabled(false);
            vm.cargaNumero();
        });
    }
}