package com.myproject.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeDAO {

	public String addInEmployee(String firstName, String lastName, String email) throws SQLException, ClassNotFoundException{

		final String dbClassName = "com.mysql.jdbc.Driver";

		// Endpoint URL from the RDS (MySQL DB) 
		final String CONNECTION = "jdbc:mysql://myprojectdbinstance1.c7n28mz1nzf6.us-east-1.rds.amazonaws.com";

		//Class.forName(className) loads the class with the specified className.
		Class.forName(dbClassName);
		Properties p = new Properties();

		p.put("user","admin");
		p.put("password","adminpassword");

		Connection connect = DriverManager.getConnection(CONNECTION,p);
		PreparedStatement ps =connect.prepareStatement("INSERT INTO Employee  VALUES (?,?,?)");

		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, email);
		
		ps.executeUpdate();
		connect.close();
		
		return "success";
	}
}
