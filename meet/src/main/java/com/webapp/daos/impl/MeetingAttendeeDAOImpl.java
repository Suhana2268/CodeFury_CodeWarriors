package com.webapp.daos.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.daos.MeetingAttendeeDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.models.MeetingAttendee;
import com.webapp.models.User;
import com.webapp.services.UserService;
import com.webapp.services.impl.UserServiceImpl;
import com.webapp.utilities.ConnectionUtility;

public class MeetingAttendeeDAOImpl implements MeetingAttendeeDAO {
	
	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	public MeetingAttendeeDAOImpl()  {
		connectionDB=new ConnectionUtility();
	}

	public boolean addAttendee(MeetingAttendee meetingAttendee) {
		final String SQL="insert into meeting_attenders(userId, bookingId) values (?,?)";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, meetingAttendee.getUserId());
				ps.setInt(2, meetingAttendee.getBookingId());
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Record Added to the table ###");
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

	public boolean deleteAttendee(int userId) {
		
		final String SQL="DELETE * from meeting_attenders where  userId= ?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, userId);
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### User Removed from the meeting ###");
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

	public List<User> getAllAttendees(int bookingId) {
		
		List<User> attenders=new ArrayList<>();
		UserService service=new UserServiceImpl();
		final String SQL="";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, bookingId);
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					User attendee =new User();
					attendee=service.getUserInfo(rs.getInt("userId"));
					attenders.add(attendee);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(UserNotFoundException err) {
				err.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
		}
		return attenders;
	}

	
	/*public List<MeetingAttendee> getAllAttende(int bookingId) {
		List<MeetingAttendee> attenders=new ArrayList<>();
		final String SQL="";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, bookingId);
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					MeetingAttendee attendee =new MeetingAttendee();
					attendee.setFeedbackId(rs.getInt("feedbackId"));
					attendee.getRoomInfo().setMeetingRoomName(rs.getString("meetingRoomName"));
					attendee.setRating(rs.getInt("rating"));
					attendee.getSubmitter().setUserId(rs.getInt("users.userId"));
					attendee.getSubmitter().setName(rs.getString("name"));
					attenders.add(feedback);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			} catch (InvalidRatingException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
		}
		return attenders;
	}*/
	
	public void addEnteries(List<String> sortedMembersID, int meetingIds) throws NumberFormatException, SQLException {
		PreparedStatement attendiesQ = conn.prepareStatement("insert into meeting_attenders values (?,?);");
		  for (String id :sortedMembersID) 
		  { 
		  attendiesQ.setInt(0,Integer.parseInt(id));
		  attendiesQ.setInt(1,meetingIds);
		  attendiesQ.executeUpdate();
		  }
	}
}
