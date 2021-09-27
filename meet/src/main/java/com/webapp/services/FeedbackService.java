package com.webapp.services;

import java.util.List;

import com.webapp.models.Feedback;

public interface FeedbackService {

	boolean addRoomFeedback(Feedback obj);
	double getAvgFeedback(String meetingRoomName);
	List<Feedback> getFeedbackByUser(int userId);
	List<Feedback> getFeedbackByRoom(String meetingRoomName);
	boolean editFeedback(Feedback obj);
	boolean deleteFeedback(int feedbackId);
	
}
