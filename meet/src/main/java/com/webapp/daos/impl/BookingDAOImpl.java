package com.webapp.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.daos.BookingDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.exceptions.InvalidMappingException;
import com.webapp.models.Amenities;
import com.webapp.models.Booking;
import com.webapp.models.MeetingRoom;
import com.webapp.models.User;
import com.webapp.services.impl.AmenitiesServiceImpl;
import com.webapp.services.impl.FeedbackServiceImpl;
import com.webapp.utilities.ConnectionUtility;

public class BookingDAOImpl implements BookingDAO {
	
	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	
	public BookingDAOImpl() {
		connectionDB=new ConnectionUtility();
	}

	@Override
	public boolean addBooking(Booking details) {
		final String SQL="INSERT INTO booking (bookingId, password, meetingRoomName, meetingDate, startTime, endTime, bookedBy, meetingType, title, costOfMeeting) VALUES (?,?,?,?,?,?,?,?,?);";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, details.getBookingId());
				ps.setString(2, details.getPassword());
				ps.setString(2, details.getRoom().getMeetingRoomName());
				ps.setDate(3, details.getMeetingDate());
				ps.setTime(4, details.getStartTime());
				ps.setTime(5, details.getEndTime());
				ps.setInt(6, details.getBookedBy().getUserId());
				ps.setString(7, details.getMeetingType());
				ps.setString(8, details.getTitle());
				ps.setInt(9, evaluateCost(details.getRoom().getMeetingRoomName(), details.getMeetingType()));
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

	@Override
	public List<Amenities> getAmenities() {
		return null;
		
	}

	@Override
	public Booking getBookingInfo(int bookingId) {
		return null;
	}

	@Override
	public List<Booking> getAllBoookings() {
		return null;
	}

	@Override
	public int getCostBooking(int bookingId) {
		return 0;
	}

	@Override
	public boolean addMemberToMeeting(int bookingId, List<User> users) {
		return false;
	}

	@Override
	public List<User> getMembersofMeeting(int bookingId) {
		return null;
	}

	@Override
	public int evaluateCost(String meetingRoomName, String meetingType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
