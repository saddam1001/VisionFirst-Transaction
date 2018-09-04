package com.saddam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection(){
		Connection con=null;
		try {
			/*
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("db.properties");
			p.load(fis);
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("password");
			*/

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/TIGER@localhost:1521/PDBORCL");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
