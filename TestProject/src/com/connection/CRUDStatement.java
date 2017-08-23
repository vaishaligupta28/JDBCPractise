package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int rowEffected;
		//String createQuery = "CREATE TABLE userDB(user_id int PRIMARY KEY NOT NULL, username varchar(45) UNIQUE NOT NULL, password varchar(45) NOT NULL, email varchar(75) NOT NULL)";
		String readQuery = "SELECT * FROM userDB";
		String updateQuery = "INSERT INTO userDB VALUES(45, \"diresh@40\", \"dddy@@13\", \"diresh%%45@gmail.com\")";
		String truncateQuery = "TRUNCATE TABLE users";
		String delQuery = "DROP TABLE users";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","admin#12");
			st = conn.createStatement();
			//System.out.println("Statement created");
			//rowEffected =  st.executeUpdate(createQuery);
			//System.out.println("Table created making changes in " + rowEffected + " rows");
            
			//rowEffected = st.executeUpdate(updateQuery);
			//System.out.println("Data Inserted making changes in "+  rowEffected + " rows");
			
			System.out.println("user_id  username   password      email");
			rs = st.executeQuery(readQuery);
			while(rs.next())  
				System.out.println(rs.getInt(1)+"       "+rs.getString(2) + "  "+ rs.getString(3) +"  "+ rs.getString(4));  
			System.out.println("Data Read");	
			
			//st.executeUpdate(truncateQuery);
			//System.out.println("Data truncated");
			
			//st.executeUpdate(delQuery);
			//System.out.println("Data deleted");
			
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
