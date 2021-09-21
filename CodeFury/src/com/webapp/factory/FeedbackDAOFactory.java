package com.webapp.factory;

import com.webapp.daos.impl.FeedbackDAOImpl;

public class FeedbackDAOFactory {

	public static FeedbackDAOImpl getFeedbackDAO() {
		return new FeedbackDAOImpl();
	}
	
}
