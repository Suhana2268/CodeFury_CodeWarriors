package com.webapp.services;

import java.util.List;

import com.webapp.models.Amenities;

import com.webapp.models.RoomAmenity;

public interface RoomAmenityService {
	
	boolean addRoomAmenity(RoomAmenity roomAmenity);
	boolean deleteRoomAmenity(RoomAmenity roomAmenity);
	List<Amenities> getAmenitiesOfRoom(String meetingRoomName);
}