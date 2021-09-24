package com.webapp.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.daos.RoomAmenityDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.models.Amenities;
import com.webapp.models.RoomAmenity;
import com.webapp.services.AmenitiesService;
import com.webapp.services.impl.AmenitiesServiceImpl;
import com.webapp.utilities.ConnectionUtility;

public class RoomAmenityDAOImpl implements RoomAmenityDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	
	public RoomAmenityDAOImpl() {
		connectionDB=new ConnectionUtility();
	}

	public boolean addRoomAmenity(RoomAmenity roomAmenity) {
		final String SQL="insert into room_amenity(amenityId, meetingRoomName) values (?,?)";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, roomAmenity.getAmenityId());
				ps.setString(2, roomAmenity.getMeetingRoomName());
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

	public boolean deleteRoomAmenity(RoomAmenity roomAmenity) {

		final String SQL="delete * from from room_amenity where amenityId= ? and meetingRoomName=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, roomAmenity.getAmenityId());
				ps.setString(2, roomAmenity.getMeetingRoomName());
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Selected Amenity has been removed from the room ###");
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

public List<Amenities> getAmenitiesOfRoom(String meetingRoomName) {
		
		List<Amenities> amenities=new ArrayList<>();
		AmenitiesService service=new AmenitiesServiceImpl();
		final String SQL="select amenityId from room_amenity where meetingRoomName=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					Amenities amenity =new Amenities();
					amenity=service.getAmenityInfo(rs.getInt("amenityId"));
					amenities.add(amenity);
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
		return amenities;
	}
}
