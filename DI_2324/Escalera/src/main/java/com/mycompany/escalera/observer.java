/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escalera;

/**
 *
 * @author Javier
 */
public class observer {
    public static void main(String[] args) {
        Escalera escalera=new Escalera();
        Persona ana=new Persona("Ana");
        Persona pepe=new Persona("pepe");
        
        
            escalera.addCotilla(ana);
            escalera.addCotilla(pepe);
            escalera.addCotilla(new Escalera.ObservadorDeMirilla(){
            @Override
            public void aviso(String info) {
                
                System.out.println("ARGGGGHHH!!!!"+info);}
                
            });
            
            escalera.addCotilla((String i)->{System.out.println("WTFFFF!!!!!!"+i);});
        
            
          escalera.dispararEvento("Ha pasado Juan");
    }
}
