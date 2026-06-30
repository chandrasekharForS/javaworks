package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC002 {

	public static void main(String[] args) {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_ecommerce",
				"root", "mysql"); 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select "
					+ "	products.product_name,"
					+ "    categories.category_name,"
					+ "    products.stock"
					+ " from products join  products_categories"
					+ " on products.product_id = products_categories.product_id"
					+ " join categories"
					+ " on products_categories.category_id = categories.category_id");){
			
			System.out.println("Products and Categories");
			while(rs.next()) {
				System.out.println("\n********************************\n");
				System.out.println("\n Product Name: " + rs.getString("product_name"));
				System.out.println("\n Category Name: " + rs.getString("category_name"));
				System.out.println("\n Stock: " + rs.getString("stock"));
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
