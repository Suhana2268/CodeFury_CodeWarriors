package com.webapp.test;

import java.util.ArrayList;
import java.util.List;

import com.webapp.services.impl.AmenitiesServiceImpl;
import com.webapp.services.impl.FeedbackServiceImpl;
import com.webapp.services.impl.MeetingRoomServiceImpl;



public class TestFeedback {
	
	public static void main(String[] args) {
		FeedbackServiceImpl service= new FeedbackServiceImpl();
		//System.out.println(service.addRoomFeedback(new Feedback("HallRoom",3,1)));
		//System.out.println(service.getAvgFeedback("HallRoom"));
		//System.out.println(service.getFeedbackByRoom("HallRoom"));
		//System.out.println(service.getFeedbackByUser(1));	
		MeetingRoomServiceImpl ser = new MeetingRoomServiceImpl();
		//System.out.println(ser.addRoom(new MeetingRoom("HallRoom",30, false)));
		
		/*List<Integer> amenities = new ArrayList<Integer>();
		amenities.add(1);
		amenities.add(2);*/
		//System.out.println(ser.addMeetingRoom("Online Class", 30, amenities));
		//System.out.println(ser.addRoomAmenities("Online Class", amenities));
		
		/*AmenitiesServiceImpl am = new AmenitiesServiceImpl();
		System.out.println(am.getAmenityInfoByName("Projector"));*/
		
		
	}
}
