package com.webapp.test;

import com.webapp.exceptions.NoDataException;
import com.webapp.exceptions.UserAlreadyExistsException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.services.UserService;
import com.webapp.services.impl.UserServiceImpl;

public class TestUser {

	public static void main(String[] args) throws UserAlreadyExistsException, UserNotFoundException, NoDataException {
		UserService service=new UserServiceImpl();
		//User u1= new User("Suhana Begum","sonu@gmail.com","9100312782","Member");
		//service.createUserDAO(u1); //exception raise ki jagah handle ho rha? why?
		//System.out.println(service.verifyUser("smriti123@gmail.com"));
		//System.out.println(service.getUserInfo(1));
		System.out.println(service.getUserByRole("Member"));
	}

}
