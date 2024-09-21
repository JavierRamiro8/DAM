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

public class Practica0 {

    public static void main(String[] args) throws SQLException {
        // Datos del nuevo alumno
         // Conexión a la base de datos (ajusta la URL, usuario y contraseña)
        String url="jdbc:mysql://localhost:3306/employee";
        String usuario = "root";
        String contraseña = "";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Consulta SQL para obtener empleados del departamento 30
            String sql = "SELECT * FROM employee WHERE department_id = 30";

            try (PreparedStatement statement = conexion.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                // Imprimir resultados
                while (resultSet.next()) {
                    int empleadoId = resultSet.getInt("employee_id");
                    String nombre = resultSet.getString("first_name");
                    System.out.println("ID: " + empleadoId + ", Nombre: " + nombre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
