package com.webapp.daos;

import java.util.List;

import com.webapp.models.MeetingAttendee;
import com.webapp.models.User;

public interface MeetingAttendeeDAO {

	boolean addAttendee(MeetingAttendee meetingAttende);
	boolean deleteAttendee(int userId);
	public List<User> getAllAttendees(int bookingId);
	
}
