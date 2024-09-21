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
import java.sql.SQLException;

public class Practica1 {

    public static void main(String[] args) throws SQLException {
        // Datos del nuevo alumno
        String id = "105";
        String nombre = "ENRIQUETA";
        String ciclo = "ASIR";
        String dni = "3434343";

        // Conexión a la base de datos (debes ajustar la URL, usuario y contraseña)
        String url = "jdbc:mysql://localhost:3306/employee";
        Connection conn = DriverManager.getConnection(url, "root", "");
            // Consulta SQL para dar de alta un nuevo alumno
            String sql = "INSERT INTO alumno (id, nombre, ciclo, dni) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, id);
                statement.setString(2, nombre);
                statement.setString(3, ciclo);
                statement.setString(4, dni);

                // Ejecutar la consulta
                statement.executeUpdate();

                System.out.println("Alumno dado de alta correctamente.");
            }
    }
}

