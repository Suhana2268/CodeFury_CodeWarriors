package com.webapp.models;

import java.util.List;

import com.webapp.services.impl.AmenitiesServiceImpl;

public class MeetingRoom {

	private String meetingRoomName;
	private int capacity;
	private int active;
	private double ratingOfRoom;
	private int totalMeetingConducted;
	private List<RoomAmenity> amenitiesInRoom;
	private int perHourCost;
	
	public MeetingRoom() {
	}
	
	public MeetingRoom(String meetingRoomName, int capacity) {
		super();
		this.meetingRoomName = meetingRoomName;
		this.capacity = capacity;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}
	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}

	public double getRatingOfRoom() {
		return ratingOfRoom;
	}
	public void setRatingOfRoom(double ratingOfRoom) {
		this.ratingOfRoom = ratingOfRoom;
	}

	public int getTotalMeetingConducted() {
		return totalMeetingConducted;
	}
	public void setTotalMeetingConducted(int totalMeetingConducted) {
		this.totalMeetingConducted = totalMeetingConducted;
	}

	public List<RoomAmenity> getAmenitiesInRoom() {
		return amenitiesInRoom;
	}
	public void setAmenitiesInRoom(List<RoomAmenity> amenitiesInRoom) {
		this.amenitiesInRoom = amenitiesInRoom;
	}

	public int getPerHourCost() {
		return perHourCost;
	}

	public void setPerHourCost(int perHourCost) {
		this.perHourCost = perHourCost;
	}
	
	public String printAmenities(List<RoomAmenity> amenitiesInRoom) {
		String str="[";
		AmenitiesServiceImpl service=new AmenitiesServiceImpl();
		for (RoomAmenity amenity: amenitiesInRoom) {
			Amenities obj=new Amenities();
			obj=service.getAmenityInfo(amenity.getAmenityId());
			str+=obj.getAmenityName();
			str+=",\n";
		}
		str+="]";
		return str;
	}

	@Override
	public String toString() {
		return "MeetingRoom [meetingRoomName=" + meetingRoomName + ", capacity=" + capacity + ", active=" + active
				+ ", ratingOfRoom=" + ratingOfRoom + ", totalMeetingConducted=" + totalMeetingConducted
				+  ", perHourCost=" + perHourCost + ", amenitiesInRoom="+printAmenities(amenitiesInRoom) +"]";
	}
	
	
	}
