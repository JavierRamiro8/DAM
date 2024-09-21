package com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepoPeliculas {
    @GET("/api/peliculas_related/{id}/")
    public Call<JsonObject> getPelicula(@Path("id") int id);
}
