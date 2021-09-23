package com.webapp.exceptions;

public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException() {
		 System.out.println("User Already Exists");
		 //super();
	 }

	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
}
