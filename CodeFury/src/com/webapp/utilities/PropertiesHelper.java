package com.webapp.utilities;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
	private final Properties dbProps; //key value pairs (works like hashmap) and they were provided much earlier than hashmap
	
	public PropertiesHelper() {
		dbProps= new Properties();
		System.out.println("SS:" + this.getClass().getClassLoader());
		try {
			dbProps.load(
					this.getClass().getClassLoader().getResourceAsStream("jdbcprops.properties"));
			//creates a byte stream that reads the file and generates key value pairs
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public String getProperty(String key) {
		//a predefined method that returns a value for the key (key values in txt file)
		return dbProps.getProperty(key);
	}
}
