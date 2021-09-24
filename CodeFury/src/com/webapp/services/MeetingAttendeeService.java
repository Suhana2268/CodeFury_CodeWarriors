package com.webapp.services;

import java.util.List;

import com.webapp.models.User;
import com.webapp.models.MeetingAttendee;

public interface MeetingAttendeeService {

	boolean addAttendee(MeetingAttendee meetingAttende);
	boolean deleteAttendee(int userId);
	public List<User> getAllAttendees(int bookingId);
}
