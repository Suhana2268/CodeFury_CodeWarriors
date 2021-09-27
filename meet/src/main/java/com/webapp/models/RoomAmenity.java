package com.webapp.models;

public class RoomAmenity {
	private int id;
	private String meetingRoomName;
	private int amenityId;
	
	public RoomAmenity() {
		super();
	}

	public RoomAmenity(int id, String meetingRoomName, int amenityId) {
		super();
		this.id = id;
		this.meetingRoomName = meetingRoomName;
		this.amenityId = amenityId;
	}

	public RoomAmenity(String meetingRoomName, int amenityId) {
		super();
		this.meetingRoomName = meetingRoomName;
		this.amenityId = amenityId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public int getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}


	@Override
	public String toString() {
		return "RoomAmenity [id=" + id + ", meetingRoomName=" + meetingRoomName + ", amenityId=" + amenityId + "]";
	}

}
