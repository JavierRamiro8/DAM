package com.example.pmdm_2324.ut06_RecycleView;

import java.util.ArrayList;
import java.util.Arrays;

public class Ut06Ejercicio1Dulces {
    public String nombreDulce;
    public String frutoSeco;
    public int calorias;
    public String dulceNavidenio;

    private static final int TAMANIOMAXIMO=6;
    private static ArrayList<String> arrayNombreDulce=new ArrayList<>(Arrays.asList(new String[]{"Polvoron","Mantecado","Turrón","Trufas","Roscon","Panettone"}));
    private static ArrayList<String> arrayFrutoSeco=new ArrayList<>(Arrays.asList(new String[]{"Si","No","Si","No","Si","Si"}));
    private static ArrayList<Integer> arrayCalorias=new ArrayList<>(Arrays.asList(new Integer[]{60,90,190,50,300,400}));

    public static Ut06Ejercicio1Dulces generarDulces(int i){
        Ut06Ejercicio1Dulces dulce= new Ut06Ejercicio1Dulces();
            dulce.nombreDulce=arrayNombreDulce.get(i);
            dulce.frutoSeco=arrayFrutoSeco.get(i);
            dulce.calorias=arrayCalorias.get(i);
        return dulce;
    }
    public static Ut06Ejercicio1Dulces[] generarDulcesNavidenios() {
        Ut06Ejercicio1Dulces[] listaDulces = new Ut06Ejercicio1Dulces[TAMANIOMAXIMO];
        for (int i = 0; i < TAMANIOMAXIMO; i++) {
            listaDulces[i] = Ut06Ejercicio1Dulces.generarDulces(i); // Crear una nueva instancia en cada iteración
        }
        return listaDulces;
    }


}
