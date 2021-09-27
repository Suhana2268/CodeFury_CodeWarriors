package com.webapp.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.daos.MeetingRoomDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.exceptions.InvalidMappingException;
import com.webapp.models.Amenities;
import com.webapp.models.MeetingRoom;
import com.webapp.models.RoomAmenity;
import com.webapp.services.impl.AmenitiesServiceImpl;
import com.webapp.services.impl.FeedbackServiceImpl;
import com.webapp.services.impl.RoomAmenityServiceImpl;
import com.webapp.utilities.ConnectionUtility;

public class MeetingRoomDAOImpl implements MeetingRoomDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	
	public MeetingRoomDAOImpl() {
		connectionDB=new ConnectionUtility();
	}

	@Override
	public boolean addMeetingRoom(String meetingRoomName, int capacity, List<Integer> amenities) {
		final String SQL="insert into meetingroom(meetingRoomName,capacity) values (?,?)";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				ps.setInt(2, capacity);
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Record Added to the table ###");
				}
				boolean res=addRoomAmenities(meetingRoomName,amenities);
				if (!res) {
					throw new InvalidMappingException();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			} catch (InvalidMappingException e) {
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
	public boolean editMeetingRoomCapacity(int newCapacity,String meetingRoomName) {
		final String SQL="update meetingroom set capacity=? where meetingRoomName=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, newCapacity);
				ps.setString(2, meetingRoomName);
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### New Capacity for Room has been set ###");
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
	public boolean addRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		RoomAmenityServiceImpl service=new RoomAmenityServiceImpl();
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				conn.setAutoCommit(false);
				for (Integer i: amenities) {
					RoomAmenity room=new RoomAmenity();
					room.setAmenityId(i);
					room.setMeetingRoomName(meetingRoomName);
					boolean res=service.addRoomAmenity(room);
					if (!res) {
						throw new InvalidMappingException();
					}
				}
				conn.commit();
			}
			catch(InvalidMappingException e) {
				System.out.println("Amenities couldn't be added....Please verify the input");
				e.printStackTrace();
				return false;
			} catch (SQLException e) {
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
	public boolean removeRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		RoomAmenityServiceImpl service=new RoomAmenityServiceImpl();
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				conn.setAutoCommit(false);
				for (Integer i: amenities) {
					RoomAmenity room=new RoomAmenity();
					room.setAmenityId(i);
					room.setMeetingRoomName(meetingRoomName);
					boolean res=service.deleteRoomAmenity(room);
					if (!res) {
						throw new InvalidMappingException();
					}
				}
				conn.commit();
			}
			catch(InvalidMappingException e) {
				System.out.println("Amenities couldn't be deleted....Please verify the input");
				e.printStackTrace();
				return false;
			} catch (SQLException e) {
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
	public MeetingRoom getMeetingRoomInfo(String meetingRoomName) {
		MeetingRoom room =new MeetingRoom();
		FeedbackServiceImpl feedService=new FeedbackServiceImpl();
		//BookingServiceImpl bookService = new BookingServiceImpl();
		AmenitiesServiceImpl amenityService=new AmenitiesServiceImpl();
		final String SQL="select * from meetingroom where meetingRoomName=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				ResultSet rs =ps.executeQuery();
				if (rs.next()) {
					room.setMeetingRoomName(rs.getString("meetingRoomName"));
					room.setCapacity(rs.getInt("capacity"));
					room.setAmenitiesInRoom(amenityService.getAmenityList());
					room.setPerHourCost(getPerHourCost(room.getMeetingRoomName()));
					room.setRatingOfRoom(feedService.getAvgFeedback(room.getMeetingRoomName()));
					//room.setTotalMeetingConducted(bookService.getTotalMeetingCount(room.getMeetingRoomName()));
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
		return room;
	}

	@Override
	public List<MeetingRoom> getAllMeetingRoom() {
		List<MeetingRoom> rooms=new ArrayList<>();
		FeedbackServiceImpl feedService=new FeedbackServiceImpl();
		//BookingServiceImpl bookService = new BookingServiceImpl();
		AmenitiesServiceImpl amenityService=new AmenitiesServiceImpl();
		final String SQL="select * from meetingroom where roomStatus=0";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					MeetingRoom room =new MeetingRoom();
					room.setMeetingRoomName(rs.getString("meetingRoomName"));
					room.setCapacity(rs.getInt("capacity"));
					room.setAmenitiesInRoom(amenityService.getAmenityList());
					room.setPerHourCost(getPerHourCost(room.getMeetingRoomName()));
					room.setRatingOfRoom(feedService.getAvgFeedback(room.getMeetingRoomName()));
					//room.setTotalMeetingConducted(bookService.getTotalMeetingCount(room.getMeetingRoomName()));
					rooms.add(room);
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
		return rooms;
	}

	@Override
	public boolean deleteMeetingRoom(String meetingRoomName) {
		final String SQL="update meetingroom set roomStatus=1 where meetingRoomName=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Meeting Room Deleted ###");
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
	public int getPerHourCost(String meetingRoomName) {
		int cost=-1;
		final String SQL="select capacity from meetingroom where meetingRoomName=?";
		AmenitiesServiceImpl amenityService=new AmenitiesServiceImpl();
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					int capacity=rs.getInt("capacity");
					if (capacity<=5) {
						cost=0;
					}
					else if (capacity>5 && capacity<=10) {
						cost=10;
					}
					else if(capacity>10) {
						cost=20;
					}
					List<Amenities> amenities=amenityService.getAmenityList();
					for (Amenities amenity : amenities) {
						cost+=amenity.getCost();
					}
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
		return cost;
	}

}
