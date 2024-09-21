package com.example.pmdm_2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ut8a3_ParesONonesViewModel extends ViewModel {
    private MutableLiveData<Integer> misDatos;
    private MutableLiveData<String> resultadoParONones ;
    private final int DELAY = 3000;
    private final int MAXRAND=5;

    public LiveData<Integer> getResultadoNum() {
        if (misDatos == null) {
            misDatos = new MutableLiveData<Integer>();
        }
        return misDatos;
    }
    public LiveData<String> getParONone() {
        if (resultadoParONones == null) {
            resultadoParONones = new MutableLiveData<String>();
        }
        return resultadoParONones;
    }

    public void generarResultado(int numeroManoJugador,String eleccion) {
        new Thread(() -> {
            try {
                Thread.sleep((long) (Math.random() * DELAY) + DELAY);
                int numeroManoMaquina = (int) (Math.random() * MAXRAND);
                int resultado = numeroManoJugador + numeroManoMaquina;

                if (resultado == 0) {
                    Thread.sleep((long) (Math.random() * DELAY) + DELAY);
                } else {
                    misDatos.postValue(resultado);
                    String cadenaResultado = "";
                    if (resultado % 2 == 0) {
                        if (eleccion.equals("Pares")) {
                            cadenaResultado = "Es par, Has ganado!!!";
                        } else {
                            cadenaResultado = "Es par, Has perdido :(";
                        }
                    } else {
                        if (eleccion.equals("Nones")) {
                            cadenaResultado = "Es none, Has ganado!!!";
                        } else {
                            cadenaResultado = "Es none, Has perdido :(";
                        }
                    }
                    resultadoParONones.postValue(cadenaResultado);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
