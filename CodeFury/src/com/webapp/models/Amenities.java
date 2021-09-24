package com.webapp.models;

public class Amenities {
	
	private int amenityId;
	private String amenityName;
	private int cost;
	
	public Amenities() {
		
	}
	
	public Amenities(int amenityId, String amenityName, int cost) {
		super();
		this.amenityId = amenityId;
		this.amenityName = amenityName;
		this.cost = cost;
	}
	
	public Amenities(String amenityName, int cost) {
		super();
		this.amenityName = amenityName;
		this.cost = cost;
	}
	
	public int getAmenityId() {
		return amenityId;
	}
	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}
	
	public String getAmenityName() {
		return amenityName;
	}
	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Amenities [amenityId=" + amenityId + ", amenityName=" + amenityName + ", cost=" + cost + "]";
	}
	
}
