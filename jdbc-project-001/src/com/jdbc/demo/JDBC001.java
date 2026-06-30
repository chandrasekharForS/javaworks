package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC001 {

	public static void main(String[] args) {
		// JDBC URL, username, password
        String jdbcURL = "jdbc:mysql://localhost:3306/jdbc_ecommerce";
        String username = "root";
        String password = "mysql";

        try {
            // Step 1: Load MySQL JDBC Driver
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a query
            String query = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the results
            while (resultSet.next()) {
                System.out.println("Product ID: " + resultSet.getInt("product_id"));
                System.out.println("Product Name: " + resultSet.getString("product_name"));
                System.out.println("Price: " + resultSet.getDouble("price"));
                System.out.println("---------");
            }

            // Step 6: Close resources
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
