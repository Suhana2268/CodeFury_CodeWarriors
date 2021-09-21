package com.webapp.models;

import com.webapp.exceptions.InvalidRatingException;

public class Feedback {
	
	private int feedbackId; 		//primary key
	private MeetingRoom roomInfo;		//foreign key
	private User submitter;//foreign key
	private int rating;
	
	public Feedback() {
		submitter=new User();
		roomInfo=new MeetingRoom();	
	}
	
	public Feedback(int feedbackId, MeetingRoom roomInfo, User submitter, int rating) {
		this();
		this.feedbackId = feedbackId;
		this.roomInfo = roomInfo;
		this.submitter = submitter;
		this.rating = rating;
	}

	public Feedback(String meetingRoomName, int submitterUserId, int rating) {
		this();
		this.roomInfo.setMeetingRoomName(meetingRoomName);
		this.submitter.setUserId(submitterUserId);
		this.rating = rating;
	}
	
	public Feedback(int feedbackId,String meetingRoomName, int submitterUserId, int rating) {
		this();
		this.feedbackId=feedbackId;
		this.roomInfo.setMeetingRoomName(meetingRoomName);
		this.submitter.setUserId(submitterUserId);
		this.rating = rating;
	}
	

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public MeetingRoom getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(MeetingRoom roomInfo) {
		this.roomInfo = roomInfo;
	}

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) throws InvalidRatingException {
		if (rating<0 || rating>6) {
			throw new InvalidRatingException();
		}
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", roomInfo=" + roomInfo.toString() + ", submitter=" + submitter.toString()
				+ ", rating=" + rating + "]";
	}
	
	
	
	
	
	
}
