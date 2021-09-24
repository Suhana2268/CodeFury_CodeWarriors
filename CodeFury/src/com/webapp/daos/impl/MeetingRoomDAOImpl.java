package com.webapp.daos.impl;

import java.util.List;

import com.webapp.daos.MeetingRoomDAO;
import com.webapp.models.MeetingRoom;

public class MeetingRoomDAOImpl implements MeetingRoomDAO {

	@Override
	public boolean addMeetingRoom(String meetingRoomName, int capacity, List<Integer> amenities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editMeetingRoom(MeetingRoom room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MeetingRoom getMeetingRoomInfo(String meetingRoomName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MeetingRoom> getAllMeetingRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMeetingRoom(String meetingRoomName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPerHourCost(String meetingRoomName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
