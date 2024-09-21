/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaswing;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class MenuDesde0 {
    public static void main(String[] args) {
        JLabel txt1=new JLabel("Prueba");
        JTextField tf1=new JTextField(25);
        JButton botonCambiarFondo=new JButton("Cambiar Color");
        JButton botonResultado=new JButton("Resultado");
        JCheckBox check1=new JCheckBox("Fresa");
        JCheckBox check2=new JCheckBox("Chocolate");
        JCheckBox check3=new JCheckBox("Vainilla");
        
        
        JRadioButton bt1= new JRadioButton("Diesel");
        JRadioButton bt2= new JRadioButton("Gasolina");
        JRadioButton bt3= new JRadioButton("Electrico");
        
        ButtonGroup radioGrupo=new ButtonGroup();
        radioGrupo.add(bt1);
        radioGrupo.add(bt2);
        radioGrupo.add(bt3);
        
        JComboBox lista=new JComboBox();
        
        lista.addItem("Rojo");
        lista.addItem("Azul");
        lista.addItem("Verde");
        
        DefaultTableModel modeloTabla = new DefaultTableModel();
       modeloTabla.addColumn("Nombre");
       JTable tabla1=new JTable(modeloTabla);
       
        JPanel panel=new JPanel();
        panel.add(txt1);
        panel.add(tf1);
        panel.add(botonCambiarFondo);
        panel.add(botonResultado);
        panel.add(check1);
        panel.add(check2);
        panel.add(check3);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(lista);
        panel.add(new JScrollPane(tabla1));

        
        JFrame frame=new JFrame();
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hola que tal");
         
        lista.addActionListener((e) -> {
         String listaSeleccionada=lista.getSelectedItem().toString();
            switch (listaSeleccionada) {
                case "Rojo":
                    panel.setBackground(Color.red);
                    bt1.setBackground(Color.red);
                    bt2.setBackground(Color.red);
                    bt3.setBackground(Color.red);
                    break;
                case "Azul":
                    panel.setBackground(Color.blue);
                    bt1.setBackground(Color.blue);
                    bt2.setBackground(Color.blue);
                    bt3.setBackground(Color.blue);
                    break;
                case "Verde":
                    panel.setBackground(Color.green);
                    bt1.setBackground(Color.green);
                    bt2.setBackground(Color.green);
                    bt3.setBackground(Color.green);
                    break;  
                default:
                    panel.setBackground(Color.white);
            }
        });
        
        botonResultado.addActionListener((e) -> {
            String btElegido="";
            String vainilla="";
            String fresa="";
            String chocolate="";
        if(check1.isSelected()){
            fresa=check1.getText();
        }
        if(check2.isSelected()){
            chocolate=check2.getText();
        }
        if(check3.isSelected()){
            vainilla=check3.getText();
        }
        if(bt1.isSelected()){
            btElegido=bt1.getText();
        }else if(bt2.isSelected()){
            btElegido=bt2.getText();
        }else if(bt3.isSelected()){
            btElegido=bt3.getText();
        }else{
            btElegido="";
        }
        if(!check1.isSelected() && !check2.isSelected() && !check3.isSelected()){
            if(bt1.isSelected() || bt2.isSelected() || bt3.isSelected() ){
                JOptionPane.showMessageDialog(null,"no se han elegido sabores: y el coche es: "+btElegido);
            }else{
                JOptionPane.showMessageDialog(null,"no se han elegido sabores ni coche");
            }
        }else{
            if(bt1.isSelected() || bt2.isSelected() || bt3.isSelected() ){
                JOptionPane.showMessageDialog(null,"Has elegido los sabores: "+fresa+" "+chocolate+" "+vainilla+" y el coche es: "+btElegido);
            }else{
                JOptionPane.showMessageDialog(null,"Has elegido los sabores: "+fresa+" "+chocolate+" "+vainilla+" y no se ha elegido coche");
            }
        }
        });
        
    }
}
