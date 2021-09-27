package com.webapp.factory;

import com.webapp.daos.RoomAmenityDAO;
import com.webapp.daos.impl.RoomAmenityDAOImpl;

public class RoomAmenityDAOFactory {
	public static RoomAmenityDAO getRoomAmenityDAO() {
		return new RoomAmenityDAOImpl();
	}
}
