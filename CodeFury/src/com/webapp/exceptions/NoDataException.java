package com.webapp.exceptions;

public class NoDataException extends Exception{

	public NoDataException() {
		System.out.println("No Data Found");
	}

	public NoDataException(String message) {
		super(message);
	}
	
}
