package com.example.pmdm_2324.ut9;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCoches {
    private static ServiceCoches coches;
    private static CochesAPI API;

    private ServiceCoches(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://car-api2.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API=retrofit.create(CochesAPI.class);
    }
    public static CochesAPI getAPI(){return API;}

    public static ServiceCoches getCoches(){
        if (coches==null){
            coches=new ServiceCoches();
        }
        return coches;
    }
}
