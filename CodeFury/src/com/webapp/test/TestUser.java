package com.webapp.test;

import com.webapp.exceptions.NoDataException;
import com.webapp.exceptions.UserAlreadyExistsException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.models.User;
import com.webapp.services.UserService;
import com.webapp.services.impl.UserServiceImpl;

public class TestUser {

	public static void main(String[] args) throws UserAlreadyExistsException, UserNotFoundException, NoDataException {
		UserService service=new UserServiceImpl();
		User u1= new User("Smriti Srivastava","smriti123@gmail.com","9808979890","Manager");
		//service.createUserDAO(u1); //exception raise ki jagah handle ho rha? why?
		System.out.println(service.verifyUser("smriti@gmail.com"));
		//System.out.println(service.getAllUsers());
		//System.out.println(service.getUserInfo(1));
	}

}
