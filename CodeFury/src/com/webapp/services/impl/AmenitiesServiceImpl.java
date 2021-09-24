package com.webapp.services.impl;

import java.util.List;

import com.webapp.daos.AmenitiesDAO;
import com.webapp.factory.AmenitiesDAOFactory;
import com.webapp.models.Amenities;
import com.webapp.services.AmenitiesService;

public class AmenitiesServiceImpl implements AmenitiesService{

	private AmenitiesDAO dao;
	
	public AmenitiesServiceImpl() {
		
		dao=AmenitiesDAOFactory.getAmenitiesDAO();
	}
	
	@Override
	public int getCost(String amenityId) {
		return dao.getCost(amenityId);
	}

	@Override
	public boolean addAmenity(Amenities amenity) {
		return dao.addAmenity(amenity);
	}

	@Override
	public boolean changeCost(int newCost, int amenityId) {
		return dao.changeCost(newCost, amenityId);
	}

	@Override
	public List<Amenities> getAmenityList() {
		return dao.getAmenityList();
	}

	@Override
	public Amenities getAmenityInfo(int amenityId) {
		return dao.getAmenityInfo(amenityId);
	}

}
