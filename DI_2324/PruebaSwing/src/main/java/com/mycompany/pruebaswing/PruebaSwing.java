/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaswing;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
public class PruebaSwing {

    public static void main(String[] args) {
        JButton boton = new JButton("Saludar1");
        JButton boton2 = new JButton("Saludar2");
        JButton boton3 = new JButton("Saludar3");
        JTextField txtNombre=new JTextField(25);
        JLabel lbInfo=new JLabel("Info");
        //JTextArea txtArea= new JTextArea();
        JCheckBox checkCocaCola=new JCheckBox("CocaCola");
        JCheckBox checkFanta=new JCheckBox("Fanta");
        JCheckBox checkSprite=new JCheckBox("Sprite");
        JRadioButton rdMeGusta=new JRadioButton("Me gusta");
        JRadioButton rdGusta=new JRadioButton("gusta");
        ButtonGroup btGrp= new ButtonGroup();
        
        btGrp.add(rdGusta);
        btGrp.add(rdMeGusta);
        
        JPanel panel= new JPanel();
        panel.add(boton);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(txtNombre);
        panel.add(lbInfo);
        //panel.add(txtArea);
        panel.add(checkCocaCola);
        panel.add(checkFanta);
        panel.add(checkSprite);
        
        
        JFrame frame=new JFrame();
        frame.add(panel);
        frame.setResizable(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        boton.addActionListener((e) -> {
        txtNombre.setText("Holaaa");
        });
    }
}
