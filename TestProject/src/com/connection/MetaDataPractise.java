package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class MetaDataPractise {
	
	public static void main(String[]args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin#12");
			DatabaseMetaData md = conn.getMetaData();
			
			System.out.println(md.getDatabaseProductName() + md.getJDBCMajorVersion() + md.getDriverName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
