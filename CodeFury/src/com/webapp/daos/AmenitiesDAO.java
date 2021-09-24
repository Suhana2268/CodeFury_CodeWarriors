package com.webapp.daos;

import java.util.List;

import com.webapp.models.Amenities;

public interface AmenitiesDAO {

	int getCost(String amenityId);
	boolean addAmenity(Amenities amenity);
	boolean changeCost(int newCost,int amenityId);
	List<Amenities> getAmenityList();
	Amenities getAmenityInfo(int amenityId);
	
}
