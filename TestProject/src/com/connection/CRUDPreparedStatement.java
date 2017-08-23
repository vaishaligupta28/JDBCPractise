package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class CRUDPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String createQuery = "CREATE TABLE userDB(user_id int PRIMARY KEY NOT NULL, username varchar(45) UNIQUE NOT NULL, password varchar(45) NOT NULL, email varchar(75) NOT NULL)";
		String readQuery = "SELECT * FROM userDB";
		String updateQuery = "INSERT INTO userDB VALUES(?, ?, ?, ?)";
		//String truncateQuery = "TRUNCATE TABLE users";
		//String delQuery = "DROP TABLE users";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","admin#12");
			
			//Create
			/*
			pst = conn.prepareStatement(createQuery);
			System.out.println("PrepareStatement created");
			pst.executeUpdate();
			System.out.println("Table created");
			*/
            
			//update
			pst = conn.prepareStatement(updateQuery);
			pst.setInt(1, 97);
			pst.setString(2, "vaishali");
			pst.setString(3, "vaishali@12");
			pst.setString(4, "g28vaishali@gmail.com");
		    pst.executeUpdate();
			//System.out.println("Data Inserted making changes in "+  rowEffected + " rows");
			
		    
		    //read
		    System.out.println("user_id  username   password      email");
			pst = conn.prepareStatement(readQuery);
			rs = pst.executeQuery();
			while(rs.next())  
				System.out.println(rs.getInt(1)+"       "+rs.getString(2) + "  "+ rs.getString(3) +"  "+ rs.getString(4));  
			System.out.println("Data Read");	
			
			
			//Delete
			/*
			pst = conn.prepareStatement(truncateQuery);
			pst.executeUpdate(truncateQuery);
			System.out.println("Data truncated");
			
			pst = conn.prepareStatement(delQuery)
			pst.executeUpdate();
			//System.out.println("Data deleted");
			
			*/
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
