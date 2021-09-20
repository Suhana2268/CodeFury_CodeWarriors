package com.webapp.factory;

import com.webapp.daos.impl.UserDAOImpl;

public class UserDAOFactory {
	
	public static UserDAOImpl getUserDAO() {
		return new UserDAOImpl();
	}
	
}
