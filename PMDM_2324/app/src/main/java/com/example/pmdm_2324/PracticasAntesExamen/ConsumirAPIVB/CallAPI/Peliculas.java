package com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI;

public class Peliculas {
    public String nombre;
    public String descripcion;
    public String estrellas;
    public String nombreActor;

    public Actores actores;

    public Peliculas(String nombre, String descripcion, String estrellas, Actores newActor) {
        this.estrellas=estrellas;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.actores=newActor;
    }
}
