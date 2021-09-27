package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingTableDaoImpl implements BookingTableDao {
	
	private static Connection conn;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
	private PreparedStatement BookingQ;
	
	static {
		try {
			conn=DBUtil.getMyConnection(booking);
		}catch(SQLException e) {
			
		}
	}

	@Override
	public List<String> meetingInfo(String meetingID) {
		return null;
	}

	@Override
	public List<String> getAllMeets(String managerName) {
		BookingQ = conn.prepareStatement("SELECT meetingIds, title, meetingDate WHERE bookedBy = ?;");
		BookingQ.setString(0, managerName);
		try {
			List<String> Blist=new ArrayList<>();
			ResultSet rs=BookingQ.executeQuery();
			while(rs.next()) {
				Blist.add(rs.getInt(1) + "#" + rs.getString(2) + "#" + rs.getDate(3) );
			}
			return Blist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void cancelMeet(String selectedMeetID) {
		BookingQ = conn.prepareStatement("DELETE FROM booking WHERE meetingIds = ?;");
		BookingQ.setString(0, selectedMeetID);
		BookingQ.executeUpdate();
		
	}

/////
	@Override
	public void editMeeting(String title, LocalDateTime meetingStartTime,
			LocalDateTime meetingEndTime, String meetingType,int meetingIds) {
		BookingQ = conn.prepareStatement("UPDATE booking set meetingDate = ?,meetingEndDateTIme=?,meetingType=?,title=? where meetingIds = ?");
		BookingQ.setString(0, meetingStartTime.format(formatter));
		BookingQ.setString(1, meetingEndTime.format(formatter));
		BookingQ.setString(2, meetingType);
		BookingQ.setString(3, title);
		BookingQ.setInt(6, meetingIds);
		BookingQ.executeUpdate();
		
	}

	@Override
	public void createTheBooking(String title, LocalDateTime startDateTime, LocalDateTime endDateTime, int bookedBy,
			String meetingType, int costOfTheMeeting,int meetingID,int meetingPass,String meetingRoomName) {
		BookingQ = conn.prepareStatement("INSERT into booking values (?,?,?,?,?,?,?,?,?,?);");
		BookingQ.setString(0, meetingRoomName);
		BookingQ.setString(1, startDateTime.format(formatter));
		BookingQ.setString(2, endDateTime.format(formatter));
		BookingQ.setInt(3, bookedBy);
		BookingQ.setString(4, meetingType);
		BookingQ.setString(5, title);
		BookingQ.setInt(6, 1);
		BookingQ.setInt(7, costOfTheMeeting);
		BookingQ.setInt(8, meetingID);
		BookingQ.setInt(9, meetingPass);
		BookingQ.executeUpdate();
		
	}

}
