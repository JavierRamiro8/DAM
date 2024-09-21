/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaswing;

/**
 *
 * @author Javier
 */
import java.awt.Color;
import java.awt.Frame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Javi
 */
public class RepasoExamenFinal {

    public static void main(String[] args) {

        JLabel textoSaludo = new JLabel("Adios");

        JTextField introducirTexto = new JTextField(25); //25 es el tamaño de la caja del JTextField

        JButton botonSaludar = new JButton("Hola");
        JButton botonPulsame = new JButton("Pulsame!");
        JButton botonx = new JButton("Si/no/cancelar");
        JButton botonIntroduceTexto = new JButton("Introduce texto");
        JButton botonRadioSelected=new JButton("Seleccionado");

        JRadioButton botonSeleccion1 = new JRadioButton("eleccion1");
        JRadioButton botonSeleccion2 = new JRadioButton("eleccion2");
        JRadioButton botonSeleccion3 = new JRadioButton("eleccion3");

        JCheckBox checkbox1 = new JCheckBox("tick");
        JCheckBox checkbox2 = new JCheckBox("tack");
        JCheckBox checkbox3 = new JCheckBox("tock");

        JComboBox listado = new JComboBox();
        listado.addItem("");
        listado.addItem("Rojo");
        listado.addItem("Azul");
        listado.addItem("Amarillo");
        listado.addItem("Verde");

        //El buttonGroup es para agrupar los radios button y hacer que solo se pueda seleccionar uno de ellos y no todos como pasaria con las cajitas de los checks (JCheckBox);
        ButtonGroup agruparRadioButtons = new ButtonGroup();
        agruparRadioButtons.add(botonSeleccion1);
        agruparRadioButtons.add(botonSeleccion2);
        agruparRadioButtons.add(botonSeleccion3);
        //creamos panel y añadimos todos los elementos
        JPanel panel = new JPanel();
        panel.add(textoSaludo);
        panel.add(introducirTexto);
        panel.add(botonSaludar);
        panel.add(botonPulsame);
        panel.add(botonIntroduceTexto);
        panel.add(botonx);
        panel.add(botonRadioSelected);
        panel.add(botonSeleccion1);
        panel.add(botonSeleccion2);
        panel.add(botonSeleccion3);
        panel.add(checkbox1);
        panel.add(checkbox2);
        panel.add(checkbox3);
        panel.add(listado);
        //creamos el framer y añadimos el panel al frame
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(500, 500);//tamaño predefinido
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Esto sirve para que cuando cierres la pestaña del IDE, tambien se cierre el proceso
        frame.setVisible(true);//para que se haga visible
        frame.setResizable(true);//Para que cuando hagas mas pequeño o mas grande la pantalla del proyecto, que este no se deforme
        frame.setTitle("Repaso Examen");//para poner un titulo en tu frame (el nombre de la ventana)

        listado.addActionListener((e) -> {
            String listaSeleccionada = listado.getSelectedItem().toString().toLowerCase();
/*
            switch (listaSeleccionada) {
                case "rojo":
                    panel.setBackground(Color.red);
                    break;
                case "azul":
                    panel.setBackground(Color.blue);
                    break;
                case "amarillo":
                    panel.setBackground(Color.yellow);
                    break;
                case "verde":
                    panel.setBackground(Color.green);
                    break;
                default:
                    panel.setBackground(Color.white);
                    break;
            }
            */
            /*
            if(listaSeleccionada.equals("rojo")){
                panel.setBackground(Color.red);
            }else if(listaSeleccionada.equals("azul")){
                panel.setBackground(Color.blue);
            }else if(listaSeleccionada.equals("amarillo")){
                panel.setBackground(Color.yellow);                
            }else if(listaSeleccionada.equals("verde")){
                panel.setBackground(Color.green);
            }else{
                panel.setBackground(Color.white);
            }
             */
            if(listado.getSelectedItem().toString().equals("Rojo")){
                panel.setBackground(Color.red);
            }
        });

        botonSaludar.addActionListener((e) -> {
            textoSaludo.setText(introducirTexto.getText());
        });
        botonx.addActionListener((e) -> {
            int opcion = JOptionPane.showConfirmDialog(frame, "Lo has entendido?");
            if (opcion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "Lo entendi");
            } else if (opcion == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(frame, "No lo entendi");
            }
        });
        botonIntroduceTexto.addActionListener((e) -> {
            String frase = JOptionPane.showInputDialog(frame, "Introduce un mensaje");
            introducirTexto.setText(frase);
            String titulo = JOptionPane.showInputDialog(frame, "Introduce un titulo para mi querido Frame");
            while (titulo.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No vale poner vacio, anda ponme algo");
                titulo = JOptionPane.showInputDialog(frame, "Introduce un titulo para mi querido Frame");
            }
            frame.setTitle(titulo);
        });
        botonPulsame.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Me has pulsado!!!!!!");
        });
        botonRadioSelected.addActionListener((e) -> {
            if(botonSeleccion1.isSelected()){
                frame.setTitle(botonSeleccion1.getText());
            }else if(botonSeleccion2.isSelected()){
                frame.setTitle(botonSeleccion2.getText());
            }else if(botonSeleccion3.isSelected()){
                frame.setTitle(botonSeleccion3.getText());
            }
        });
    }
}
