/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adev2;

/**
 *
 * @author Javier
 */
import com.mycompany.adev2.Practica1_3.AlumnoJuan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Practica1_3 {

    public static void main(String[] args) throws SQLException {
        List<AlumnoJuan> alumnosJuan = getAlumnoPorNombre("Juan");

        System.out.println("Datos de alumnos con nombre Juan:");

        for (AlumnoJuan alumno : alumnosJuan) {
            System.out.println("ID=" + alumno.getId() +
                    "\nNombre=" + alumno.getNombre() +
                    "\nCiclo=" + alumno.getCiclo() +
                    "\nDNI=" + alumno.getDni() +
                    "\n------------------------");
        }
    }

    private static List<AlumnoJuan> getAlumnoPorNombre(String nombre) {
        List<AlumnoJuan> alumnos = new ArrayList<>();

        // Conexión a la base de datos (ajusta la URL, usuario y contraseña)
        String url = "jdbc:mysql://localhost:3306/employee";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Consulta SQL para obtener alumnos con nombre "Juan"
            String sql = "SELECT id, nombre, ciclo, dni FROM alumno WHERE nombre = ?";

            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, nombre);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombreAlumno = resultSet.getString("nombre");
                        String ciclo = resultSet.getString("ciclo");
                        String dni = resultSet.getString("dni");

                        AlumnoJuan alumno = new AlumnoJuan(id, nombreAlumno, ciclo, dni);
                        alumnos.add(alumno);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }
    static class AlumnoJuan {
    private int id;
    private String nombre;
    private String ciclo;
    private String dni;

    public AlumnoJuan(int id, String nombre, String ciclo, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public String getDni() {
        return dni;
    }
}
}

