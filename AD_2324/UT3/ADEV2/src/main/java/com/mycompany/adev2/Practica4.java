/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adev2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class Practica4 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bd_alumnos";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            listarTablas(connection);
        } catch (SQLException e) {
            // Manejar excepción si es necesario o dejar vacío si no se desea imprimir errores
        }
    }

    private static void listarTablas(Connection connection) throws SQLException {
        DatabaseMetaData dbMetaData = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = dbMetaData.getTables(null, null, "%", types);

        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if (tableName.equals("alumnos") || tableName.equals("alumnos_asignaturas") || tableName.equals("asignaturas")) {
                System.out.println(tableName);
            }
        }
    }
}
