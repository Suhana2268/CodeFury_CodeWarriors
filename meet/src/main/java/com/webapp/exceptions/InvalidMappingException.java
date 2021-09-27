package com.webapp.exceptions;

public class InvalidMappingException extends Exception{

	public InvalidMappingException() {
		System.out.println("InvalidMappingException:Some of the foreign key Constraint is not followed!!");
	}

	public InvalidMappingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
