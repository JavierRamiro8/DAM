package com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicePeliculas {
    private static ServicePeliculas peliculas;
    private static RepoPeliculas API;

        private ServicePeliculas(){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://192.168.0.21:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            API=retrofit.create(RepoPeliculas.class);
        }
    public static RepoPeliculas getAPI(){return API;}

    public static ServicePeliculas getPeliculas(){
        if (peliculas ==null){
            peliculas =new ServicePeliculas();
        }
        return peliculas;
    }
}
