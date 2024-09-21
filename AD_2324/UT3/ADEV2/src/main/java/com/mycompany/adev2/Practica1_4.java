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

public class Practica1_4 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employee";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Consulta SQL para obtener alumnos con nombre "Juan"
            String sql = "SELECT id, nombre, ciclo, dni FROM alumno WHERE id = 1";

            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombreAlumno = resultSet.getString("nombre");
                        String ciclo = resultSet.getString("ciclo");
                        String dni = resultSet.getString("dni");
                        System.out.println("ciclo: "+ciclo+"\n"+"DNI: "+dni+"\n" +"id: "+id+"\n"+"nombre: "+nombreAlumno);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
