package com.webapp.factory;

import com.webapp.daos.UserDAO;
import com.webapp.daos.impl.UserDAOImpl;

public class UserDAOFactory {
	
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
}
