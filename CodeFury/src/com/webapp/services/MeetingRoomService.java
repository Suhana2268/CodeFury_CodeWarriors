package com.webapp.services;

import java.util.List;

import com.webapp.models.MeetingRoom;

public interface MeetingRoomService {

	boolean addMeetingRoom(String meetingRoomName, int capacity, List<Integer> amenities);
	boolean editMeetingRoom(MeetingRoom room);
	boolean addRoomAmenities(String meetingRoomName, List<Integer> amenities);
	boolean getRoomAmenities(String meetingRoomName, List<Integer> amenities);
	MeetingRoom getMeetingRoomInfo(String meetingRoomName);
	List<MeetingRoom> getAllMeetingRoom();
	boolean deleteMeetingRoom(String meetingRoomName);
	int getPerHourCost(String meetingRoomName);
}
