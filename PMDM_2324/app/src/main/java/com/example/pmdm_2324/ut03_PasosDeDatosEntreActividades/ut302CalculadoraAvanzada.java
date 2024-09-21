package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut302CalculadoraAvanzada extends AppCompatActivity {
    EditText primerNumero, segundoNumero;
    TextView radioNoSeleccionado;
    RadioButton sumar, restar, multiplicar, dividir;
    Button botonCalcular;
    public static final String PRIMERNUMERO="PRIMERNUMERO";
    public static final String SEGUNDONUMERO="SEGUNDONUMERO";
    public static final String OPERACION="OPERACION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_ut302_calculadora_avanzadahorizontal);
        } else {
            setContentView(R.layout.activity_ut302_calculadora_avanzada);
        }

        radioNoSeleccionado = findViewById(R.id.u302tvErrorRadioNoSeleccionado);
        primerNumero = findViewById(R.id.u302etPrimerNumero);
        segundoNumero = findViewById(R.id.u302etSegundoNumero);
        sumar = findViewById(R.id.u302rdSumar);
        restar = findViewById(R.id.u302rdRestar);
        multiplicar = findViewById(R.id.u302rdMultiplicar);
        dividir = findViewById(R.id.u302rdDividir);
        botonCalcular = findViewById(R.id.u302btCalcular);

        botonCalcular.setOnClickListener(view -> {
            Intent i = new Intent(this, ut302CalculadoraResultado.class);
            double resultado = 0;

            boolean camposVacios = false;

            if (primerNumero.getText().toString().isEmpty()) {
                primerNumero.setError("No se puede dejar vacío");
                camposVacios = true;
            }
            if (segundoNumero.getText().toString().isEmpty()) {
                segundoNumero.setError("No se puede dejar vacío");
                camposVacios = true;
            }
            if(sumar.isChecked() || restar.isChecked() || multiplicar.isChecked() || dividir.isChecked()){
                if (sumar.isChecked()) {
                    i.putExtra(OPERACION, sumar.getText().toString());
                    radioNoSeleccionado.setText("");
                } else if (restar.isChecked()) {
                    i.putExtra(OPERACION, restar.getText().toString());
                    radioNoSeleccionado.setText("");
                } else if (multiplicar.isChecked()) {
                    i.putExtra(OPERACION, multiplicar.getText().toString());
                    radioNoSeleccionado.setText("");
                } else if (dividir.isChecked()) {
                    i.putExtra(OPERACION, dividir.getText().toString());
                    radioNoSeleccionado.setText("");
                }
                if (camposVacios) {
                    radioNoSeleccionado.setText("Compprueba los numeros que estan vacios");
                }else if(dividir.isChecked() && segundoNumero.getText().toString().equals("0")){
                    radioNoSeleccionado.setText("No se puede hacer la division con cualquien numero entre 0");
                }else{
                    i.putExtra(PRIMERNUMERO, primerNumero.getText().toString());
                    i.putExtra(SEGUNDONUMERO, segundoNumero.getText().toString());
                    startActivity(i);
                }
            }else{
                radioNoSeleccionado.setText("Tienes que seleccionar una operacion");
            }
        });

    }
}

