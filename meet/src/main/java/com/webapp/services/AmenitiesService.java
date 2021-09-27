package com.webapp.services;

import java.util.List;

import com.webapp.models.Amenities;

public interface AmenitiesService {

	int getCost(int i);
	boolean addAmenity(Amenities amenity);
	boolean changeCost(int newCost,int amenityId);
	List<Amenities> getAmenityList();
	Amenities getAmenityInfo(int amenityId);
	Amenities getAmenityInfoByName(String amenityName);
}
