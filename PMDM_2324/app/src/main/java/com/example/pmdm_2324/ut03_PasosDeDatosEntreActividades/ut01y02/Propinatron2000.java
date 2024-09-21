package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut01y02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class Propinatron2000 extends AppCompatActivity {
Button boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton0,botonDel,botonC,botonAceptar;
TextView tvSalidaNumeros,tvPropina;
RadioButton radioMal,radioBien,radioExcelente;
View.OnClickListener manejador,manejadorBorrarSolo1,manejadorBorrarTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propinatron2000);
        boton1=findViewById(R.id.ut203bt1);
        boton2=findViewById(R.id.ut203bt2);
        boton3=findViewById(R.id.ut203bt3);
        boton4=findViewById(R.id.ut203bt4);
        boton5=findViewById(R.id.ut203bt5);
        boton6=findViewById(R.id.ut203bt6);
        boton7=findViewById(R.id.ut203bt7);
        boton8=findViewById(R.id.ut203bt8);
        boton9=findViewById(R.id.ut203bt9);
        boton0=findViewById(R.id.ut203bt0);
        botonDel=findViewById(R.id.ut203btDel);
        botonC=findViewById(R.id.ut203btC);
        botonAceptar=findViewById(R.id.ut203btAceptar);
        tvSalidaNumeros=findViewById(R.id.ut203tvResultado);
        radioMal=findViewById(R.id.ut203rdMal);
        radioBien=findViewById(R.id.ut203rdBien);
        radioExcelente=findViewById(R.id.ut203rdExcelente);
        tvPropina=findViewById(R.id.ut203tvPropina);

        manejador = (View botonPulsado) -> {
            Button seleccion = (Button) botonPulsado;
            tvSalidaNumeros.append(seleccion.getText());
        };
        manejadorBorrarSolo1=(View borrarSolo1)->{
            int resto=1;
            Button seleccionado = (Button) borrarSolo1;
            String cadenaTv= tvSalidaNumeros.getText().toString();
            cadenaTv=cadenaTv.substring(0,cadenaTv.length()-resto);
            tvSalidaNumeros.setText(cadenaTv);
        };
        manejadorBorrarTodo=(View borrar)->{
            Button seleccionado = (Button) borrar;
            tvSalidaNumeros.setText("");
            tvPropina.setText("");
        };
        botonAceptar.setOnClickListener((View v)->{
            double resultado;
            int divisionPorcentaje=100;
            if(radioMal.isChecked()){
                tvSalidaNumeros.setText(tvSalidaNumeros.getText());
                tvPropina.setText("");
            }else if(radioBien.isChecked()){
                double porcentajeBien=10;
                double numero=Integer.parseInt(tvSalidaNumeros.getText().toString());
                 resultado=(numero*porcentajeBien)/divisionPorcentaje+numero;
                tvPropina.setText(String.valueOf(resultado)+"€ de propina");
            }else{
                double porcentajeExcelente=20;
                double numero=Integer.parseInt(tvSalidaNumeros.getText().toString());
                resultado=(numero*porcentajeExcelente)/divisionPorcentaje+numero;
                tvPropina.setText(String.valueOf(resultado)+"€ de propina");
            }
        });
        boton1.setOnClickListener(manejador);
        boton2.setOnClickListener(manejador);
        boton3.setOnClickListener(manejador);
        boton4.setOnClickListener(manejador);
        boton5.setOnClickListener(manejador);
        boton6.setOnClickListener(manejador);
        boton7.setOnClickListener(manejador);
        boton8.setOnClickListener(manejador);
        boton9.setOnClickListener(manejador);
        boton0.setOnClickListener(manejador);
        botonDel.setOnClickListener(manejadorBorrarSolo1);
        botonC.setOnClickListener(manejadorBorrarTodo);

    }
}