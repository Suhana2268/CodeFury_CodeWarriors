package com.webapp.services.impl;

import java.util.List;

import com.webapp.daos.RoomAmenityDAO;
import com.webapp.factory.RoomAmenityDAOFactory;
import com.webapp.models.Amenities;
import com.webapp.models.RoomAmenity;
import com.webapp.services.RoomAmenityService;

public class RoomAmenityServiceImpl implements RoomAmenityService {
	private RoomAmenityDAO dao;

	public RoomAmenityServiceImpl() {
		dao=RoomAmenityDAOFactory.getRoomAmenityDAO();
	}

	@Override
	public boolean addRoomAmenity(RoomAmenity roomAmenity) {
		return dao.addRoomAmenity(roomAmenity);
	}

	@Override
	public boolean deleteRoomAmenity(int amenityId) {
		return dao.deleteRoomAmenity(amenityId);
	}

	@Override
	public List<Amenities> getAmenitiesOfRoom(String meetingRoomName) {
		return dao.getAmenitiesOfRoom(meetingRoomName);
	}
	
	

}
