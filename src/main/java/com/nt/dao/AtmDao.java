package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AtmDao {
//	private static final String Query="SELECT "
	
	public  Connection makeConnection() throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///deep","root","D416@pirt");
		
		return con;
	}

	
}
