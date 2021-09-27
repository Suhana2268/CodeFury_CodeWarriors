package com.webapp.factory;

import com.webapp.daos.MeetingRoomDAO;
import com.webapp.daos.impl.MeetingRoomDAOImpl;

public class MeetingRoomDAOFactory {

		public static MeetingRoomDAO getMeetingRoomDAO() {
			return new MeetingRoomDAOImpl();
		}
		
}
