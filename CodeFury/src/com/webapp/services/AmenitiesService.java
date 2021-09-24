package com.webapp.services;

import java.util.List;

import com.webapp.models.Amenities;

public interface AmenitiesService {

	int getCost(String amenityId);
	boolean addAmenity(Amenities amenity);
	boolean changeCost(int newCost,int amenityId);
	List<Amenities> getAmenityList();
}
