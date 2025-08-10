package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatement {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
        String Username = "root";
        String Password = "HappyLearning";
        String Query = "SELECT * FROM students WHERE name = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded !");

            try (
                Connection con = DriverManager.getConnection(URL, Username, Password);
                PreparedStatement preparedStatement = con.prepareStatement(Query)
            ) {
                preparedStatement.setString(1, "maan");
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("______________________________");
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String dept = rs.getString("dept");

                        System.out.println("Student ID :" + id);
                        System.out.println("Student Name :" + name);
                        System.out.println("Student Department :" + dept);
                        System.out.println("______________________________");
                    }
                }
                System.out.println("Terminated Successfully");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Oops! Some serious issue: " + e.getMessage());
        }
    }
}
