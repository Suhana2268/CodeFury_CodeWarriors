package com.webapp.services.impl;

import java.util.List;

import com.webapp.daos.UserDAO;
import com.webapp.exceptions.NoDataException;
import com.webapp.exceptions.UserAlreadyExistsException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.factory.UserDAOFactory;
import com.webapp.models.User;
import com.webapp.services.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO dao;
	

	public UserServiceImpl() {
		dao=UserDAOFactory.getUserDAO();
	}

	@Override
	public boolean createUserDAO(User user) throws UserAlreadyExistsException {
		return dao.createUserDAO(user);
	}

	@Override
	public List<User> getAllUsers() throws NoDataException{
		return dao.getAllUsers();
	}

	@Override
	public List<User> getUserByRole(String role) throws NoDataException {
		return dao.getAllUsers();
	}

	@Override
	public User getUserInfo(int userId) throws UserNotFoundException {
		return dao.getUserInfo(userId);
	}

	@Override
	public boolean verifyUser(String email) {
		return dao.verifyUser(email);
	}

}