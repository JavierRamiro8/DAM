package com.example.pmdm_2324.ut9.Prueba;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickAndMortyRepo {
    @GET("/api/character/{id}")
    Call<Personaje> getCharacter(@Path("id") int id);
}