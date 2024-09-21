package com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI.Actores;
import com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI.Peliculas;
import com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI.ServicePeliculas;
import com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.ModelViewPeliculas.PeliculaModelView;
import com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.RecyclePeliculas.AdapterPeliculas;
import com.example.pmdm_2324.R;
import com.example.pmdm_2324.ut08.ut8a1_numeroAleatorioViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActividadConsumirAPIPeliculas extends AppCompatActivity {
    RecyclerView recyclePeliculas;
    Button generar;
    EditText introducirID;
    ProgressBar peliculaRuleta;
    private AdapterPeliculas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_consumir_apipeliculas);
        recyclePeliculas = findViewById(R.id.recyclePeliculas);
        generar = findViewById(R.id.botonGenRecycle);
        introducirID = findViewById(R.id.introducirID);
        peliculaRuleta = findViewById(R.id.PeliculaRuleta);
        PeliculaModelView mvvm = new ViewModelProvider(this).get(PeliculaModelView.class);
        generar.setOnClickListener(v -> {
            mvvm.getNumeros().observe(this, integer -> {
                peliculaRuleta.setVisibility(View.INVISIBLE);
                recyclePeliculas.setVisibility(View.VISIBLE);
            });
            peliculaRuleta.setVisibility(View.VISIBLE);
            recyclePeliculas.setVisibility(View.INVISIBLE);

                int id = Integer.valueOf(introducirID.getText().toString());
                ServicePeliculas sc = ServicePeliculas.getPeliculas();
                Call<JsonObject> llamada = sc.getAPI().getPelicula(id);
                llamada.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject getAllPeliculas = response.body();
                            List<Peliculas> listaPeliculas = parseJson(getAllPeliculas);
                            if(adapter==null){
                                adapter = new AdapterPeliculas(listaPeliculas);
                            }
                            recyclePeliculas.setAdapter(adapter);
                            recyclePeliculas.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                            adapter.add(listaPeliculas);
                            mvvm.cargaNumero();
                            adapter.setOnItemClickListener(peliculas -> {
                                generar.setText("HOLAAAAAAAAA");
                            });
                        }
                    }
                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.e("ERROR", "Error, no se pudo hacer la llamada a la API");
                    }
            });
        });
    }

    private List<Peliculas> parseJson(JsonObject jsonObject) {
        List<Peliculas> listaPeliculas = new ArrayList<>();
        String nombre = jsonObject.get("nombre").getAsString();
        String descripcion = jsonObject.get("descripcion").getAsString();
        String estrellas=jsonObject.get("estrellas").getAsString();
        JsonArray actores = jsonObject.get("actores").getAsJsonArray();

        String nombreActor="";
        StringBuilder nombreActores=new StringBuilder();

        for(int i=0;i<actores.size();i++){
            JsonObject actorObject = actores.get(i).getAsJsonObject();
            nombreActor=actorObject.get("nombre").getAsString();
            nombreActores.append(nombreActor+"\n");
        }

        String urlActor="";
        StringBuilder urlActores=new StringBuilder();

        for(int i=0;i<actores.size();i++){
            JsonObject actorObject = actores.get(i).getAsJsonObject();
            urlActor=actorObject.get("url").getAsString();
            urlActores.append(urlActor+"\n");
        }
        urlActores.append("\n");

        String urlPelicula="";
        StringBuilder urlPeliculas=new StringBuilder();

        for(int i=0;i<actores.size();i++){
            JsonObject actorObject = actores.get(i).getAsJsonObject();
            urlPelicula=actorObject.get("pelicula").getAsString();
            urlPeliculas.append(urlPelicula+"\n");
        }
        Actores newActor=new Actores(nombreActores.toString(),urlActores.toString(),urlPeliculas.toString());
        Peliculas pelicula = new Peliculas(nombre, descripcion,estrellas,newActor);
        listaPeliculas.add(pelicula);
        return listaPeliculas;
    }
}
