package com.webapp.factory;

import com.webapp.daos.MeetingAttendeeDAO;
import com.webapp.daos.impl.MeetingAttendeeDAOImpl;

public class MeetingAttendeeDAOFactory {

	public static MeetingAttendeeDAO getMeetingAttendeeDAO() {
		return new MeetingAttendeeDAOImpl();
	}
	
}
