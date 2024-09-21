package com.example.pmdm_2324.ut9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ut9a2Coches extends AppCompatActivity {
    EditText introducirModelo;
    Button buscar;
    TextView mostrarResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut9a2_coches);
        introducirModelo = findViewById(R.id.ut902EtIntroducirModelo);
        buscar = findViewById(R.id.ut902BtAceptar);
        mostrarResultado = findViewById(R.id.ut902TvResultado);
        buscar.setOnClickListener(view -> {
            ServiceCoches sc = ServiceCoches.getCoches();
            Call<JsonObject> llamada = sc.getAPI().getCoche("yes", "2020", "id", "asc");
            llamada.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.isSuccessful()) {
                        mostrarResultado.setText("");
                        JsonObject jsonResponse = response.body();
                        JsonArray data = jsonResponse.getAsJsonArray("data");
                        for (JsonElement item : data) {
                            JsonObject itemObject = item.getAsJsonObject();
                            String modelName = itemObject.get("name").getAsString();
                            JsonObject makeObject = itemObject.getAsJsonObject("make");
                            String makeName = makeObject.get("name").getAsString();
                            if (makeName.toLowerCase().equals(introducirModelo.getText().toString().toLowerCase())) {
                                mostrarResultado.append(modelName + "\n");
                            }
                        }
                    }
                }
                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    mostrarResultado.setText("ERROR");
                }
            });
        });
    }
}