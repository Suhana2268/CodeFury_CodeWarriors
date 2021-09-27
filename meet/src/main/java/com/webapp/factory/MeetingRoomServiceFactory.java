package com.webapp.factory;

import com.webapp.services.MeetingRoomService;
import com.webapp.services.impl.MeetingRoomServiceImpl;

public class MeetingRoomServiceFactory {
	
	private MeetingRoomServiceFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static MeetingRoomService getMeetService() {
		return new MeetingRoomServiceImpl();
	}

}
