package com.webapp.services.impl;

import java.util.List;

import com.webapp.daos.FeedbackDAO;
import com.webapp.factory.FeedbackDAOFactory;
import com.webapp.models.Feedback;
import com.webapp.services.FeedbackService;

public class FeedbackServiceImpl implements FeedbackService {
	
	private FeedbackDAO dao;
	
	public FeedbackServiceImpl() {
		dao=FeedbackDAOFactory.getFeedbackDAO();
	}

	@Override
	public boolean addRoomFeedback(Feedback obj){
		return dao.addRoomFeedback(obj);
	}

	@Override
	public double getAvgFeedback(String meetingRoomName){
		return dao.getAvgFeedback(meetingRoomName);
	}

	@Override
	public List<Feedback> getFeedbackByUser(int userId) {
		return dao.getFeedbackByUser(userId);
	}

	@Override
	public List<Feedback> getFeedbackByRoom(String meetingRoomName) {
		return dao.getFeedbackByRoom(meetingRoomName);
	}

	@Override
	public boolean editFeedback(Feedback obj) {
		return dao.editFeedback(obj);

	}

	@Override
	public boolean deleteFeedback(int feedbackId) {
		return dao.deleteFeedback(feedbackId);

	}

}
