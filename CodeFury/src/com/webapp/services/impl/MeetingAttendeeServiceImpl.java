package com.webapp.services.impl;

import java.util.List;

import com.webapp.daos.MeetingAttendeeDAO;
import com.webapp.factory.MeetingAttendeeDAOFactory;
import com.webapp.models.MeetingAttendee;
import com.webapp.models.User;
import com.webapp.services.MeetingAttendeeService;

public class MeetingAttendeeServiceImpl implements MeetingAttendeeService {

	private MeetingAttendeeDAO dao;
	
	public MeetingAttendeeServiceImpl() {
		dao=MeetingAttendeeDAOFactory.getMeetingAttendeeDAO();
	}
	
	@Override
	public boolean addAttendee(MeetingAttendee meetingAttende) {
		return dao.addAttendee(meetingAttende);
	}

	@Override
	public boolean deleteAttendee(int userId) {
		return dao.deleteAttendee(userId);
	}

	@Override
	public List<User> getAllAttendees(int bookingId) {
		return dao.getAllAttendees(bookingId);
	}

}
