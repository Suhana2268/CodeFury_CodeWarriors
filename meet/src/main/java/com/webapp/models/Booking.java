package com.webapp.models;

import java.sql.Time;
import java.sql.Timestamp;

public class Booking {
	private int bookingId;
	private String meetingRoomName;
	private Timestamp meetingDate;
	private Time startTime;
	private Time endTime;
	private int bookedBy;
	private String meetingType;
	private String title;
	private int bookingStatus;
	private int costOfMeeting;
	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public Timestamp getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Timestamp meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public int getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(int bookedBy) {
		this.bookedBy = bookedBy;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getCostOfMeeting() {
		return costOfMeeting;
	}

	public void setCostOfMeeting(int costOfMeeting) {
		this.costOfMeeting = costOfMeeting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookedBy;
		result = prime * result + bookingId;
		result = prime * result + bookingStatus;
		result = prime * result + costOfMeeting;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((meetingDate == null) ? 0 : meetingDate.hashCode());
		result = prime * result + ((meetingRoomName == null) ? 0 : meetingRoomName.hashCode());
		result = prime * result + ((meetingType == null) ? 0 : meetingType.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookedBy != other.bookedBy)
			return false;
		if (bookingId != other.bookingId)
			return false;
		if (bookingStatus != other.bookingStatus)
			return false;
		if (costOfMeeting != other.costOfMeeting)
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (meetingDate == null) {
			if (other.meetingDate != null)
				return false;
		} else if (!meetingDate.equals(other.meetingDate))
			return false;
		if (meetingRoomName == null) {
			if (other.meetingRoomName != null)
				return false;
		} else if (!meetingRoomName.equals(other.meetingRoomName))
			return false;
		if (meetingType == null) {
			if (other.meetingType != null)
				return false;
		} else if (!meetingType.equals(other.meetingType))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", meetingRoomName=" + meetingRoomName + ", meetingDate="
				+ meetingDate + ", startTime=" + startTime + ", endTime=" + endTime + ", bookedBy=" + bookedBy
				+ ", meetingType=" + meetingType + ", title=" + title + ", bookingStatus=" + bookingStatus
				+ ", costOfMeeting=" + costOfMeeting + "]";
	}

}
