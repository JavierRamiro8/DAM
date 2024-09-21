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
import java.util.Iterator;
import java.util.List;

public class Practica1_2 {
 public static void main(String[] args) throws SQLException {
        List<Alumnos> alumnos = getAlumnoPorCiclo("DAM");
        System.out.println("Alumnos matriculados en el ciclo DAM:");
        Iterator<Alumnos> iterator = alumnos.iterator();
        while (iterator.hasNext()) {
            Alumnos alumno = iterator.next();
            System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre());
        }
    }

    private static List<Alumnos> getAlumnoPorCiclo(String ciclo) {
        List<Alumnos> alumnos = new ArrayList<>();

        // Conexión a la base de datos (ajusta la URL, usuario y contraseña)
        String url = "jdbc:mysql://localhost:3306/employee";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Consulta SQL para obtener empleados del ciclo DAM
            String sql = "SELECT id, nombre FROM alumno WHERE ciclo = ?";

            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, ciclo);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        Alumnos alumno = new Alumnos(id, nombre);
                        alumnos.add(alumno);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}

class Alumnos {
    private int id;
    private String nombre;

    public Alumnos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
