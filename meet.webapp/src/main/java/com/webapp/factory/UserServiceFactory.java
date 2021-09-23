package com.webapp.factory;

import com.webapp.services.UserService;
import com.webapp.services.impl.UserServiceImpl;

public class UserServiceFactory {
	
	private  UserServiceFactory() {
	}

	public static UserService createServiceObject() {
		return new UserServiceImpl();
				
				
	}


}

