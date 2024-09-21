package com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.ModelViewPeliculas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class PeliculaModelView extends ViewModel {
    private MutableLiveData<Integer> misDatos;
    private final int DELAY=1000;
    private final int MAX_NUM=10000;
    public LiveData<Integer> getNumeros(){
        if(misDatos==null){
            misDatos=new MutableLiveData<Integer>();
            cargaNumero();
        }
        return misDatos;
    }

    public void cargaNumero() {
        Random random = new Random();
        new Thread(()->{
            try {
                Thread.sleep((long)(Math.random()*DELAY)+DELAY);
                int i=random.nextInt(MAX_NUM);
                misDatos.postValue(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
