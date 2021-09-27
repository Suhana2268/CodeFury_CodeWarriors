package com.demo.service;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingTableService {

	List<String> meetingInfo(String meetingID);

	List<String> getAllMeets(String managerName);

	List<String> getPreviousBookingDetails(String bookedBy);

	void editMeeting(String title, LocalDateTime meetingStartTime, LocalDateTime meetingEndTime,
			String meetingType,int meetingIds);

	void cancelMeet(String selectedMeetID);

	void createTheBooking(String title, LocalDateTime meetingStartTime, LocalDateTime meetingEndTime, int bookedBy,
			String meetingType, int costOfTheMeeting,int meetingID,int meetingPass,String meetingRoomName);

}
