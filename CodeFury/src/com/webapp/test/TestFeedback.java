package com.webapp.test;

import com.webapp.models.Feedback;
import com.webapp.services.impl.FeedbackServiceImpl;

public class TestFeedback {
	
	public static void main(String[] args) {
		FeedbackServiceImpl service= new FeedbackServiceImpl();
		System.out.println(service.addRoomFeedback(new Feedback("HallRoom",3,1)));
		System.out.println(service.getAvgFeedback("HallRoom"));
		System.out.println(service.getFeedbackByRoom("HallRoom"));
		System.out.println(service.getFeedbackByUser(1));	
	}
}
