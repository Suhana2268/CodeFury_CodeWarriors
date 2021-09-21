package com.webapp.daos.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.webapp.daos.UserDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.exceptions.NoDataException;
import com.webapp.exceptions.UserAlreadyExistsException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.models.User;
import com.webapp.utilities.ConnectionUtility;

public class UserDAOImpl implements UserDAO{
	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	public UserDAOImpl() {
		connectionDB=new ConnectionUtility();
	}

	@Override
	public boolean createUserDAO(User user) throws UserAlreadyExistsException{
		final String checkEntry="select userId from users where active=0 and email=?";
		final String SQL="insert into users(name,email,phone,credit,role) values (?,?,?,?,?)";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(checkEntry);
				ps.setString(1, user.getEmail().toLowerCase());
				ResultSet rsCheck = ps.executeQuery();
				if(rsCheck.next()) {
					System.out.println(ps+rsCheck.getString("userId"));
					throw new UserAlreadyExistsException();}
				else {
					int credit;
					ps=conn.prepareStatement(SQL);
					ps.setString(1,user.getName());
					ps.setString(2,user.getEmail().toLowerCase());
					ps.setString(3,user.getPhone());
					ps.setString(5,user.getRole());
					if (user.getRole().equalsIgnoreCase("Manager")) {
						credit=2000;
					}
					else {
						credit=0;
					}
					ps.setInt(4, credit);
					System.out.println(ps);
					System.out.println("Trying Connection");
					int cnt=ps.executeUpdate();
					if(cnt!=0) {
						System.out.println("### Record Added to the table ###");}
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				connectionDB.closeConnection(conn);
			}
		}
	catch(ConnectionNotCreatedException error) {
		error.printStackTrace();
		return false;
	}
		return true;
}

	@Override
	public List<User> getAllUsers() throws NoDataException{
		List<User> users=new ArrayList<User>();
		final String SQL="select * from users where active=0";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					User user =new User();
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRole(rs.getString("role"));
					user.setCredit(rs.getInt("credit"));
					user.setUserId(rs.getInt("userId"));
					user.setLastLogin(rs.getTimestamp("lastLogin", Calendar.getInstance(TimeZone.getTimeZone("IST"))));
					users.add(user);
				}
				
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
		}
	catch(ConnectionNotCreatedException error) {
		error.printStackTrace();
	}
		
		return users;
	}

	@Override
	public List<User> getUserByRole(String role) throws NoDataException {
		
		List<User> users=new ArrayList<User>();
		final String SQL="select * from users where role=? and active=0";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, role);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					User user =new User();
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRole(rs.getString("role"));
					user.setCredit(rs.getInt("credit"));
					user.setUserId(rs.getInt("userId"));
					user.setLastLogin(rs.getTimestamp("lastLogin",Calendar.getInstance(TimeZone.getTimeZone("IST"))));
					users.add(user);
				}
				
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
		}
	catch(ConnectionNotCreatedException error) {
		error.printStackTrace();
	}
		
	return users;
}

	@Override
	public User getUserInfo(int userId) throws UserNotFoundException {
		
		User user =new User();
		final String SQL="select * from users where userId=? and active=0";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, userId);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRole(rs.getString("role"));
					user.setCredit(rs.getInt("credit"));
					user.setUserId(rs.getInt("userId"));
					user.setLastLogin(rs.getTimestamp("lastLogin"));
				}
				else {
					System.out.println("User Doesnot exists");
					throw new UserNotFoundException();
				}
				
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
		}
	catch(ConnectionNotCreatedException error) {
		error.printStackTrace();
	}
		
	return user;
} 

	@Override
	public boolean verifyUser(String email) {
		final String SQL="select * from users where email=? and active=0";
		//User user=new User();
		email=email.toLowerCase();
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					String update="update users set lastLogin=? where email=?";
					Date date= new Date(); 
					long time = date.getTime();
					Timestamp currTS = new Timestamp(time); 
					if (rs.getString("role").equals("Manager")) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						boolean isMonday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
						boolean loginedAlready = false;
						System.out.println(isMonday+"oioi"+loginedAlready);
						if (isMonday && !(loginedAlready)) {
							update="update users set lastLogin=?, credit=2000 where email=?";
						}	
					}
					PreparedStatement ps2=conn.prepareStatement(update);
					ps2.setTimestamp(1,currTS, Calendar.getInstance(TimeZone.getTimeZone("IST")));
					ps2.setString(2, email);
					System.out.println(ps2.toString());
					int cnt=ps2.executeUpdate();
					System.out.println(cnt);
				}
				else {
					System.out.println("User Doesnot exists");
					return false; 
				}
				
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
		}
	catch(ConnectionNotCreatedException error) {
		error.printStackTrace();
		return false;
	}
	return true;
}

}
