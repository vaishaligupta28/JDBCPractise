package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BatchUsingPreparedStatement {
	
	public static void main(String[] args)
	{
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String readQuery = "SELECT * FROM userDB";
		String query = "INSERT INTO userDB VALUES(?, ?, ?, ?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","admin#12");
			conn.setAutoCommit(false);  
			  
			pst=conn.prepareStatement(query); 
			
			pst.setInt(1, 44);
			pst.setString(2, "sunil");
			pst.setString(3, "gupta##12");
			pst.setString(4, "sunil@gmail.com");
			pst.addBatch();
			

			pst.setInt(1, 46);
			pst.setString(2, "shri");
			pst.setString(3, "shee##12");
			pst.setString(4, "shree@gmail.com");
			pst.addBatch();
			
			pst.executeBatch();//executing the batch 
			System.out.println("batch executed using Prepared Statement\n\n");
			pst=conn.prepareStatement(readQuery); 
			System.out.println("user_id  username   password      email");
			rs = pst.executeQuery();
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
