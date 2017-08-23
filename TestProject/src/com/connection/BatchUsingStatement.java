package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUsingStatement {
	
	public static void main(String[] args)
	{
		Connection conn = null;
		String readQuery = "SELECT * FROM userDB";
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","admin#12");
			conn.setAutoCommit(false);  
			  
			Statement st=conn.createStatement(); 
			st.addBatch("INSERT INTO userDB VALUES(35, \"abhi!12\", \"ytr23\", \"abhi23@gmail.com\")");
			st.addBatch("INSERT INTO userDB VALUES(14, \"rishi!12\", \"rtr23\", \"rishi24@gmail.com\")");  
			st.executeBatch();//executing the batch 
			System.out.println("batch executed using Statement\n\n");
			
			System.out.println("user_id  username   password      email");
			rs = st.executeQuery(readQuery);
			while(rs.next())  
				System.out.println(rs.getInt(1)+"       "+rs.getString(2) + "  "+ rs.getString(3) +"  "+ rs.getString(4));  
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		finally {
		try {
			conn.commit();
			conn.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
  }
}
