package com.webapp.daos;

import java.util.List;

import com.webapp.models.MeetingRoom;

public interface MeetingRoomDAO {
	
	boolean addMeetingRoom(String meetingRoomName, int capacity, List<Integer> amenities);
	boolean editMeetingRoomCapacity(int newCapacity,String meetingRoomName);
	boolean addRoomAmenities(String meetingRoomName, List<Integer> amenities);
	boolean removeRoomAmenities(String meetingRoomName, List<Integer> amenities);
	MeetingRoom getMeetingRoomInfo(String meetingRoomName);
	List<MeetingRoom> getAllMeetingRoom();
	boolean deleteMeetingRoom(String meetingRoomName);
	int getPerHourCost(String meetingRoomName);
	
}
