package com.webapp.models;

public class MeetingRoom {

	private String meetingRoomName;
	private int capacity;
	private int active;
	
	public MeetingRoom() {
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
	@Override
	public String toString() {
		return "MeetingRoom [meetingRoomName=" + meetingRoomName + ", capacity=" + capacity + ", active=" + active
				+ "]";
	}
	
	
	}
