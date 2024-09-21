/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adev2;

/**
 *
 * @author Javier
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// Archivo Leer.java
import java.util.Scanner;

public class Practica6 {

    public static void main(String[] args) {
        Aplicacion.menu();
    }

    class Leer {

        private static final Scanner scanner = new Scanner(System.in);

        public static String leerTexto(String mensaje) {
            System.out.print(mensaje);
            return scanner.nextLine();
        }
    }

    class Bd_alumnos_menu {

        private static final String URL = "jdbc:mysql://localhost:3306/BD_Alumnos";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        public static Connection getConexion() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        // Este método ahora retorna una lista de nombres de tablas
        public static List<String> listarTablas(Connection conn) throws SQLException {
            List<String> tablas = new ArrayList<>();
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, "%", new String[]{"TABLE"});
            int index = 1;
            System.out.println("Tablas de la base de datos:");
            while (resultSet.next()) {
                String tableName = resultSet.getString(3);
                System.out.println(index++ + ". " + tableName);
                tablas.add(tableName);
            }
            resultSet.close();
            return tablas;
        }

        public static ResultSet obtenerTabla(Connection conn, String tabla) throws SQLException {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM " + tabla);
        }

        public static void mostrarTabla(ResultSet rs) throws SQLException {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) {
                    System.out.print("\t");
                }
                System.out.print(metaData.getColumnName(i));
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) {
                        System.out.print("\t");
                    }
                    System.out.print(rs.getString(i));
                }
                System.out.println();
            }
            rs.close();
        }
    }

    public class Aplicacion {

        public static void menu() {
            try (Connection connection = Bd_alumnos_menu.getConexion()) {
                List<String> tablas = Bd_alumnos_menu.listarTablas(connection);
                System.out.println("\nSeleccione una tabla para mostrar sus datos (1 - " + tablas.size() + "):");
                int opcion = Integer.parseInt(Leer.leerTexto("Opción: "));
                if (opcion < 1 || opcion > tablas.size()) {
                    System.out.println("Opción inválida.");
                    return;
                }
                String tablaSeleccionada = tablas.get(opcion - 1);
                ResultSet rs = Bd_alumnos_menu.obtenerTabla(connection, tablaSeleccionada);
                Bd_alumnos_menu.mostrarTabla(rs);
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos o al realizar la consulta");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
            }
        }
    }
}
