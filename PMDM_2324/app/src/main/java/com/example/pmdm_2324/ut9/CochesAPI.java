package com.example.pmdm_2324.ut9;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CochesAPI {
    @Headers({"X-RapidAPI-Key: 6059c47febmsha84374a61d7abcfp11c6ebjsn74fbf3094e51", "X-RapidAPI-Host: car-api2.p.rapidapi.com"})
    @GET("/api/models")
    public Call<JsonObject> getCoche(@Query("verbose") String verbose,
                                     @Query("year") String year,
                                     @Query("sort") String sort,
                                     @Query("direction") String direction);
}