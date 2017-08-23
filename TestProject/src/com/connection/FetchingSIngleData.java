package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchingSIngleData {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String readQuery = "SELECT * FROM userDB WHERE user_id = 30";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","admin#12");
			st = conn.createStatement();
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
