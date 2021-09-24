package com.webapp.models;

public class MeetingAttendee {
	private int id;
	private int bookingId;
	private int userId;
	
	public MeetingAttendee() {
		super();
	}

	public MeetingAttendee(int bookingId, int userId) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
	}

	public MeetingAttendee(int id, int bookingId, int userId) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.userId = userId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MeetingAttenders [id=" + id + ", bookingId=" + bookingId + ", userId=" + userId + "]";
	}

}