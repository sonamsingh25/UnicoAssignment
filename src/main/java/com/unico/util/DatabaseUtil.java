package main.java.com.unico.util;

import java.sql.Connection;
import java.sql.DriverManager;


/*
 * Database Utility class for interacting with the database
 * Assumption - the DB Details are assumed
 * 
 */
public class DatabaseUtil {

	public static Connection getConnection() throws Exception{
	
			String connectionURL = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(connectionURL, "userid", "password");
			return connection;
		
	}

}
