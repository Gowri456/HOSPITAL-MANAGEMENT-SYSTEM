package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedInsert {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
        String Username = "root";
        String Password = "HappyLearning";
        String Query = "INSERT INTO students(name, dept) VALUES (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded !");
        } catch (ClassNotFoundException e) {
            System.out.println("Drivers not loaded");
            System.out.println("In catch1 " + e.getMessage());
            return;
        }

        try (
            Connection con = DriverManager.getConnection(URL, Username, Password);
            PreparedStatement preparedStatement = con.prepareStatement(Query)
        ) {
            preparedStatement.setString(1, "Abhinav Bindra");
            preparedStatement.setString(2, "Biotechnology");

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Inserted Successfully");
            }
        } catch (SQLException e) {
            System.out.println("In catch " + e.getMessage());
        }

        System.out.println("Terminated Successfully");
    }
}
