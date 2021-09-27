package com.webapp.utilities;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import com.webapp.exceptions.ConnectionNotCreatedException;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;

public class ConnectionUtility {
	
	private Connection conn;
	private static String dbUsername;
	private static String dbPassword;
	private static String dbDriver;
	private static String conURL;
	//private final static Logger LOG = LoggerFactory.getLogger(ConnectionUtility.class);
	static {
		PropertiesHelper helper= new PropertiesHelper();
		dbUsername=helper.getProperty("DBUSERNAME");
		dbPassword=helper.getProperty("DBPASSWORD");
		conURL=helper.getProperty("CONURL");
		dbDriver=helper.getProperty("DRIVERCLASSNAME");
		try {
			Class.forName(dbDriver);
			System.out.println("### Driver Class Loaded ###");}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection createConnection() throws ConnectionNotCreatedException{
		try {
			conn=DriverManager.getConnection(conURL,dbUsername,dbPassword);
			System.out.println("##### Connected to DB #####");
			return conn;
			}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("### Connection to DB Closed ###");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
