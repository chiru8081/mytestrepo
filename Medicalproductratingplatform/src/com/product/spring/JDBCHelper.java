package com.product.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelper {

	public static void close(ResultSet rs)  //we can reuse jdbchelper where we want to implement these methods
	{
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close(Connection con)
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close(Statement stmt)
	{
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static Connection getConnection()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection(Constants.URL,Constants.DRIVER,Constants.PWD);
			System.out.println(con);
			return con;
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
}
