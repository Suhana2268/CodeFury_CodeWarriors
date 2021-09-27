package com.webapp.factory;

import com.webapp.services.AmenitiesService;
import com.webapp.services.impl.AmenitiesServiceImpl;

public class AmenityServiceFactory {
	
	private AmenityServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static AmenitiesService getAmenityService() {
		// TODO Auto-generated method stub
		return new AmenitiesServiceImpl();
	}

}
