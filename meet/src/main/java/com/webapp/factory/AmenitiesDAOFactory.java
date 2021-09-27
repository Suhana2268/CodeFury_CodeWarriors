package com.webapp.factory;

import com.webapp.daos.AmenitiesDAO;
import com.webapp.daos.impl.AmenitiesDAOImpl;

public class AmenitiesDAOFactory {

	public static AmenitiesDAO getAmenitiesDAO() {
		return new AmenitiesDAOImpl();
	}
	
}
