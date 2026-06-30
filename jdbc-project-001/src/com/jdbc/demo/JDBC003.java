package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC003 {
	// Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_ecommerce"; // Change mydb to your database name
    private static final String USER = "root"; // Change username if necessary
    private static final String PASSWORD = "mysql"; // Change password if necessary

	public static void main(String[] args) {
		 JDBC003 example = new JDBC003();

	        // Create new customers
	        example.createCustomer("John Doe", "john.doe@example.com", "1234567890");
	        example.createCustomer("Jane Smith", "jane.smith@example.com", "0987654321");

	        // Read all customers
	        System.out.println("Customers:");
	        example.readCustomers();

	        // Update a customer's details
	        example.updateCustomer(1, "John Updated", "john.updated@example.com", "1122334455");

	        // Read all customers again to see the updated info
	        System.out.println("Updated Customers:");
	        example.readCustomers();

	        // Delete a customer
	        example.deleteCustomer(2);

	        // Read all customers again to see the remaining customers
	        System.out.println("Customers after deletion:");
	        example.readCustomers();

	}
	
	  // Method to create a new customer
    public void createCustomer(String name, String email, String phone) {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer created: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Method to read all customers
    public void readCustomers() {
        String sql = "SELECT * FROM customers";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Phone: " + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing customer
    public void updateCustomer(int id, String name, String email, String phone) {
        String sql = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setInt(4, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer updated: " + name);
            } else {
                System.out.println("No customer found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Method to delete a customer by ID
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer deleted with ID: " + id);
            } else {
                System.out.println("No customer found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
