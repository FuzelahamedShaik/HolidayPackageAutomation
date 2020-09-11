package com;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler {
	
	public Connection establishConnection() throws IOException, SQLException, ClassNotFoundException {
		FileReader fr = new FileReader("db.properties");
		Properties p = new Properties();
		p.load(fr);
		String driver = p.getProperty("Driver");
		String database = p.getProperty("Database");
		String user = p.getProperty("username");
		String password = p.getProperty("password");
	    Class.forName(driver);
		Connection con = DriverManager.getConnection(database, user, password);
		return con;
	}
	
}
