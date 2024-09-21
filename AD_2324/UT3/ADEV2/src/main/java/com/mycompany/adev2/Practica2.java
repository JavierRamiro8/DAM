/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adev2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practica2 {
    // CicloInterface.java

    public interface CicloInterface {
        CicloInterface getNuevoCiclo(String codCiclo, String descripcion, String grado);

        String getCodCiclo();

        String getDescripcion();

        String getGrado();

        void setDescripcion(String descripcion);

        void setGrado(String grado);
    }

    public static class CicloBean implements CicloInterface {

        private String codCiclo;
        private String descripcion;
        private String grado;

        @Override
        public CicloInterface getNuevoCiclo(String codCiclo, String descripcion, String grado) {
            this.codCiclo = codCiclo;
            this.descripcion = descripcion;
            this.grado = grado;
            insertarCicloEnDB(codCiclo, descripcion, grado);
            return this;
        }

        @Override
        public String getCodCiclo() {
            return codCiclo;
        }

        @Override
        public String getDescripcion() {
            return descripcion;
        }

        @Override
        public String getGrado() {
            return grado;
        }

        @Override
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public void setGrado(String grado) {
            this.grado = grado;
        }

        private void insertarCicloEnDB(String codCiclo, String descripcion, String grado) {
            String url = "jdbc:mysql://localhost:3306/employee";
            String usuario = "root";
            String contraseña = "";
            String sql = "INSERT INTO CICLO (CODCICLO, DENCICLO, GRADO) VALUES (?, ?, ?)";

            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                 PreparedStatement statement = conexion.prepareStatement(sql)) {

                statement.setString(1, codCiclo);
                statement.setString(2, descripcion);
                statement.setString(3, grado);

                int filasInsertadas = statement.executeUpdate();
                if (filasInsertadas > 0) {
                    System.out.println("Un nuevo ciclo ha sido insertado.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // FactoriaCiclos.java

    public class FactoriaCiclos {

        public CicloInterface crearCiclo() {
            return new CicloBean();
        }
    }

    // Aplicación.java

    public static void main(String[] args) throws SQLException {
        FactoriaCiclos factoria = new Practica2().new FactoriaCiclos();
        CicloInterface ciclo = factoria.crearCiclo();
        String url = "jdbc:mysql://localhost:3306/employee";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            ciclo.getNuevoCiclo("DPI", "Desarrollo de productos informáticos", "MEDIO");
        }
    }
}
