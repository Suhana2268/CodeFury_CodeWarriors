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
	public boolean editMeetingRoom(MeetingRoom room) {
		return dao.editMeetingRoom(room);
	}

	@Override
	public boolean addRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		return dao.addRoomAmenities(meetingRoomName, amenities);
	}

	@Override
	public boolean getRoomAmenities(String meetingRoomName, List<Integer> amenities) {
		return dao.getRoomAmenities(meetingRoomName, amenities);
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

}
