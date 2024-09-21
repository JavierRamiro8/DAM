package com.example.pmdm_2324.ut9.Prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ut9a1Personajes extends AppCompatActivity {
EditText id;
Button get;
TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut9a1_personajes);
        id=findViewById(R.id.ut9a1PtIntroducir);
        get=findViewById(R.id.ut9a1BtAceptar);
        info=findViewById(R.id.ut9a1TvResultado);
        get.setOnClickListener(v -> {
            ServiceRickAndMorty ser=ServiceRickAndMorty.getInstancia();
            Call<Personaje> llamada=ser.getRepo().getCharacter(Integer.parseInt(id.getText().toString()));
            llamada.enqueue(new Callback<Personaje>() {
                @Override
                public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                    Personaje p=response.body();
                    info.setText(p.name);
                }

                @Override
                public void onFailure(Call<Personaje> call, Throwable t) {
                String nuncaToast="Debug";
                }
            });
        });
    }
}