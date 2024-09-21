package com.example.pmdm_2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class ut8a2_CalculadoraSumaViewModel extends ViewModel {
    private MutableLiveData<Integer> misDatos;
    private final int DELAY = 1000;

    public LiveData<Integer> getNumeroSuma() {
        if (misDatos == null) {
            misDatos = new MutableLiveData<Integer>();
        }
        return misDatos;
    }

    public void cargaSuma(int numero1, int numero2) {
        Random random = new Random();
        new Thread(() -> {
            try {
                Thread.sleep((long) (Math.random() * DELAY) + DELAY);
                int resultado =numero1 + numero2;
                if (resultado == 0) {
                    Thread.sleep((long) (Math.random() * DELAY) + DELAY);
                } else {
                    misDatos.postValue(resultado);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
