package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionPractise {
	
	private static final String DRIVER  = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://localhost:3306/demo";
	private static final String USER = "root";
	private static final String PASSD = "admin#12";
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Connection conn  = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String readQuery = "SELECT * FROM userDB";
		String query = "INSERT INTO userDB VALUES(?, ?, ?, ?)";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONNECTION, USER, PASSD);
			
			conn.setAutoCommit(false);  
			  
			pst=conn.prepareStatement(query); 		
			pst.setInt(1, 56);
			pst.setString(2, "sneha");
			pst.setString(3, "me##12");
			pst.setString(4, "sneha@gmail.com");
			pst.addBatch();
			
			pst.setInt(1, 94);
			pst.setString(2, "megha");
			pst.setString(3, "mera##12");
			pst.setString(4, "megha@gmail.com");
			pst.addBatch();
			
			pst.executeBatch();//executing the batch 			
			System.out.println("user_id  username   password      email");
			pst = conn.prepareStatement(readQuery);
			rs = pst.executeQuery();
			while(rs.next())  
				System.out.println(rs.getInt(1)+"       "+rs.getString(2) + "  "+ rs.getString(3) +"  "+ rs.getString(4));
			System.out.println("\n");
			conn.commit();
			System.out.println("Transaction Successful\n\n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}  
		finally
		{
			try {
				if(pst != null)
					pst.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
