package com.webapp.services.impl;

import java.util.List;

import com.webapp.daos.MeetingRoomDAO;
import com.webapp.factory.MeetingRoomDAOFactory;
import com.webapp.models.MeetingRoom;
import com.webapp.services.MeetingRoomService;

public class MeetingRoomServiceImpl implements MeetingRoomService {

	private MeetingRoomDAO dao;
	
	public MeetingRoomServiceImpl() {
		dao=MeetingRoomDAOFactory.getMeetingRoomDAO();
	}
	
	@Override
	public boolean addMeetingRoom(String meetingRoomName, int capacity, List<Integer> amenities) {
		return dao.addMeetingRoom(meetingRoomName, capacity, amenities);
	}


	@Override
	public boolean addRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		return dao.addRoomAmenities(meetingRoomName, amenities);
	}

	@Override
	public MeetingRoom getMeetingRoomInfo(String meetingRoomName) {
		return dao.getMeetingRoomInfo(meetingRoomName);
	}

	@Override
	public List<MeetingRoom> getAllMeetingRoom() {
		return dao.getAllMeetingRoom();
	}

	@Override
	public boolean deleteMeetingRoom(String meetingRoomName) {
		return dao.deleteMeetingRoom(meetingRoomName);
	}

	@Override
	public int getPerHourCost(String meetingRoomName) {
		return dao.getPerHourCost(meetingRoomName);
	}

	@Override
	public boolean editMeetingRoomCapacity(int newCapacity, String meetingRoomName) {
		return dao.editMeetingRoomCapacity(newCapacity, meetingRoomName);
	}

	@Override
	public boolean removeRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		return dao.removeRoomAmenities(meetingRoomName, amenities);
	}

}
