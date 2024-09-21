package com.example.pmdm_2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut8a3_ParesONones extends AppCompatActivity {
    Button jugar;
    Switch pares, nones;
    ProgressBar carga;
    TextView tvResultadoPartida,tvError;
    Spinner mano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut8a3_pares_onones);
        jugar = findViewById(R.id.ut8a3BtJugar);
        pares = findViewById(R.id.ut8a3_SwPar);
        nones = findViewById(R.id.ut8a3_SwNone);
        carga = findViewById(R.id.ut8a3Carga);
        tvResultadoPartida = findViewById(R.id.ut8a3TvGanarPerder);
        mano = findViewById(R.id.ut8a3SpinnerMano);
        tvError=findViewById(R.id.ut8a3Error);
        ut8a3_ParesONonesViewModel vm = new ViewModelProvider(this).get(ut8a3_ParesONonesViewModel.class);
        vm.getResultadoNum().observe(this, integer -> {
            //Actualizas la interfaz en esta parte
            tvResultadoPartida.setText("" +integer);
            carga.setVisibility(View.INVISIBLE);
            tvResultadoPartida.setVisibility(View.VISIBLE);
        });
        vm.getParONone().observe(this, integer -> {
            //Actualizas la interfaz en esta parte
            tvResultadoPartida.append(" " + vm.getParONone().getValue());
            carga.setVisibility(View.INVISIBLE);
            tvResultadoPartida.setVisibility(View.VISIBLE);
        });
        jugar.setOnClickListener(view -> {
            String eleccion = "";
            if (pares.isChecked() && nones.isChecked()) {
                tvError.setText("Por favor, no marques los dos");
            } else if (!pares.isChecked() && !nones.isChecked()) {
                tvError.setText("Por favor, marca uno de los dos");
            } else if (pares.isChecked()) {
                tvError.setText("");
                nones.setChecked(false);
                eleccion = pares.getText().toString();
                carga.setVisibility(View.VISIBLE);
                tvResultadoPartida.setVisibility(View.INVISIBLE);
                vm.generarResultado(Integer.parseInt(mano.getSelectedItem().toString()), eleccion);
            } else if (nones.isChecked()) {
                tvError.setText("");
                pares.setChecked(false);
                eleccion = nones.getText().toString();
                carga.setVisibility(View.VISIBLE);
                tvResultadoPartida.setVisibility(View.INVISIBLE);
                vm.generarResultado(Integer.parseInt(mano.getSelectedItem().toString()), eleccion);
            }
        });
    }
}