/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaswing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Javi
 */
public class RepasoPaExamen {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        
        JFrame frame = new JFrame();

        JLabel txt1 = new JLabel("Hola esto es una prueba");

        JTextField txtEscribir1 = new JTextField(25);

        JButton boton1 = new JButton("Saludar");

        JCheckBox checkbox1 = new JCheckBox("eleccion1");
        JCheckBox checkbox2 = new JCheckBox("eleccion2");
        JCheckBox checkbox3 = new JCheckBox("eleccion3");

        JRadioButton rdBtn1 = new JRadioButton("Radio 1");
        JRadioButton rdBtn2 = new JRadioButton("Radio 2");
        JRadioButton rdBtn3 = new JRadioButton("Radio 3");
        ButtonGroup radioGrupo = new ButtonGroup();
        radioGrupo.add(rdBtn1);
        radioGrupo.add(rdBtn2);
        radioGrupo.add(rdBtn3);
        
        JComboBox listado=new JComboBox();
        listado.addItem("Hola");
        listado.addItem("Que");
        listado.addItem("Tal");
        
       panel.add(txt1);
       panel.add(txtEscribir1);
       panel.add(boton1);
       panel.add(checkbox1);
       panel.add(checkbox2);
       panel.add(checkbox3);
       panel.add(rdBtn1);
       panel.add(rdBtn2);
       panel.add(rdBtn3);
       panel.add(listado);
       
       frame.add(panel);
       frame.setVisible(true);
       frame.setResizable(true);
       frame.setSize(500,500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       boton1.addActionListener((e) -> {
       txt1.setText("Adios");
       });
       

    }

}
