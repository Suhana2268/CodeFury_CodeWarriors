package com.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.demo.dao.BookingTableDao;
import com.demo.dao.BookingTableDaoImpl;

public class BookingTableServiceImpl implements BookingTableService {
	
	BookingTableDao BookDaoRef = new BookingTableDaoImpl();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
	@Override
	public List<String> meetingInfo(String meetingID) {
		return BookDaoRef.meetingInfo(meetingID);

	}

	@Override
	public List<String> getAllMeets(String managerName) {
		return BookDaoRef.getAllMeets(managerName);
	}

	@Override
	public List<String> getPreviousBookingDetails(String bookedBy) {
		return BookDaoRef.getPreviousBookingDetails(bookedBy);
	}


	@Override
	public void cancelMeet(String selectedMeetID) {
		BookDaoRef.cancelMeet(selectedMeetID);
		
	}

	@Override
	public void editMeeting(String title, LocalDateTime meetingStartTime, LocalDateTime meetingEndTime,
			String meetingType,int meetingIds) {
		BookDaoRef.editMeeting(title, meetingStartTime, meetingEndTime, meetingType,meetingIds);
		
	}

	@Override
	public void createTheBooking(String title, LocalDateTime meetingStartTime, LocalDateTime meetingEndTime,
			int bookedBy, String meetingType, int costOfTheMeeting,int meetingID, int meetingPass,String meetingRoomName) {
		String startDateTime = meetingStartTime.format(formatter);
		String endDateTime = meetingStartTime.format(formatter);
		BookDaoRef.createTheBooking(title,startDateTime,endDateTime,bookedBy,meetingType,costOfTheMeeting,meetingID,meetingPass,meetingRoomName);
		
	}

}
