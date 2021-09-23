package com.webapp.services;

import java.util.List;

import com.webapp.exceptions.NoDataException;
import com.webapp.exceptions.UserAlreadyExistsException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.models.User;

public interface UserService {
	
	boolean createUserDAO(User user) throws UserAlreadyExistsException;
	List<User> getAllUsers()throws NoDataException;
	List<User> getUserByRole(String role) throws NoDataException;
	User getUserInfo(int userId) throws UserNotFoundException;
	boolean verifyUser(String email);
	User getUserByEmail(String email) throws UserNotFoundException;
}
