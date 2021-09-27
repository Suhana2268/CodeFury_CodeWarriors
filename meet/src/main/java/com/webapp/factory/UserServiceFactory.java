package com.webapp.factory;

import com.webapp.services.UserService;
import com.webapp.services.impl.UserServiceImpl;

public class UserServiceFactory {
	
	private UserServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static UserService createServiceObject() {
		// TODO Auto-generated method stub
		return new UserServiceImpl();
	}
	
	

}
