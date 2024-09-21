package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut01y02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.pmdm_2324.R;

public class ut2_ej01_CajaRadioCheckTextoBoton extends AppCompatActivity {


    TextView ut2_01_txtVerColor;
    TextView ut201txtToggle;
    SeekBar ut201skbrR;
    ToggleButton ut201tgbt;
    Button ut201btnColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut2_ej01_cajaraidochecktextoboton);
        ut201btnColor=findViewById(R.id.ut201btnColor);

        ut201skbrR=findViewById(R.id.ut201skbrR);

        ut201tgbt=findViewById(R.id.ut201tgbt);

        ut201txtToggle=findViewById(R.id.ut201txtToggle);

        ut201btnColor.setOnClickListener((View v)->{

            ut2_01_txtVerColor=findViewById(R.id.ut2_01_txtVerColor);

            int numeroProgreso=ut201skbrR.getProgress();

            String Progreso=String.valueOf(numeroProgreso);

            ut2_01_txtVerColor.setText(Progreso);

            boolean estadoToggle=ut201tgbt.isChecked();
            if(estadoToggle=false){
                ut201txtToggle.setText("activado");
            }else{
                ut201txtToggle.setText("desactivado");

            }
        });

    }
}