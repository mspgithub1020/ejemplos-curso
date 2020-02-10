package com.curso.once;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Escuela;user=sa;password=password";

        System.out.print("Connecting to SQL Server ... ");
        try (Connection connection = DriverManager.getConnection(connectionUrl)){
            System.out.println("Connected.");

            String sql = new StringBuilder()
                .append("USE Escuela; ")
                .append("SELECT * FROM Curso;")
                .toString();

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("Id") + " " + resultSet.getString("Nombre"));
                }
                connection.close();
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}