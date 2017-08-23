package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginValidation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String readQuery = "SELECT * FROM userDB";	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","admin#12");
			st = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("\nWelcome to LOGIN page\n");
			System.out.print("Username: ");
			String username = sc.next().trim();
			System.out.print("Password: ");
			String password = sc.next().trim();
			
			rs = st.executeQuery(readQuery);
			while(rs.next())  {
				if((rs.getString("username").equals(username)) && (rs.getString("password").equals(password)))
				    System.out.println("\nWelcome "+ username  +" !!Login Successful");
				else
					System.out.println("\nWrong Username or Password");
				break;
			    }								
			} 
		    catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
