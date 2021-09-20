package com.webapp.exceptions;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		System.out.println("User not found");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
