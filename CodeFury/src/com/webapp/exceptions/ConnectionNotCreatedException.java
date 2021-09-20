package com.webapp.exceptions;

public class ConnectionNotCreatedException extends Exception{

	public ConnectionNotCreatedException() {
		System.out.println("ConnectionNotCreatedException");
	}

	public ConnectionNotCreatedException(String message) {
		super(message);
	}
	
	

}
