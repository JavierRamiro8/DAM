/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adev2;

/**
 *
 * @author Javier
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Practica1_5 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // SQL para borrar todos los alumnos llamados "Juan"
            String sqlDelete = "DELETE FROM alumno WHERE nombre = ?";
            try (PreparedStatement statementDelete = conexion.prepareStatement(sqlDelete)) {
                statementDelete.setString(1, "Juan");
                int filasAfectadas = statementDelete.executeUpdate();
                System.out.println("Se han borrado " + filasAfectadas + " alumnos llamados Juan.");
            }

            // SQL para listar a todos los alumnos restantes
            String sqlSelect = "SELECT * FROM alumno";
            try (PreparedStatement statementSelect = conexion.prepareStatement(sqlSelect);
                 ResultSet resultSet = statementSelect.executeQuery()) {
                while (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    // Suponiendo que la tabla tiene estas columnas
                    String ciclo = resultSet.getString("ciclo");
                    String dni = resultSet.getString("dni");
                    System.out.println("Nombre: " + nombre + ", Ciclo: " + ciclo + ", DNI: " + dni);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

