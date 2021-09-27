package com.webapp.exceptions;

public class InvalidRatingException extends Exception {

	public InvalidRatingException() {
		System.out.println("Invalid Rating Received.. Rating must be between 1-5");
	}

	public InvalidRatingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
