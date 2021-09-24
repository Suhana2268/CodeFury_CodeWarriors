package com.webapp.daos;

import java.util.List;

import com.webapp.models.Amenities;
import com.webapp.models.RoomAmenity;

public interface RoomAmenityDAO {

	boolean addRoomAmenity(RoomAmenity roomAmenity);
	boolean deleteRoomAmenity(int amenityId);
	List<Amenities> getAmenitiesOfRoom(String meetingRoomName);

}
