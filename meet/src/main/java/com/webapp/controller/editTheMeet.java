package com.webapp.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.BookingTableService;
import com.demo.service.BookingTableServiceImpl;
import com.webapp.services.impl.MeetingAttendeeServiceImpl;
@WebServlet("/editTheMeet")
/**
 * Servlet implementation class EditBooking
 */
public class editTheMeet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTheMeet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateTimeFormatter formattime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
        
        HttpSession session = request.getSession();
		Random rand = new Random();
		
		String selectedMeeting = request.getParameter("selectedMeet");//Selected meeting to edit
		String meetingIds = selectedMeeting.split(" ")[0];
		
		
		String title = request.getParameter("title"); //title
        LocalDateTime meetingStartTime = LocalDateTime.parse(request.getParameter("meetingDate"), formattime); //Meeting date time 
        LocalDateTime meetingEndTime = meetingStartTime.plusHours((long)request.getParameter("duration")); //Meeting end time
        String bookedBy = session.getAttribute("userName"); //Booked By
        String mailp = request.getParameter("pwd");
		String meetingType = request.getParameter("meetingType"); //meeting Type
		int bookingStatus = 1; //booking status
		List<String> meetingMembers = request.getParameter("addmembers");//Members & ID for the meeting
		List<String> sortedMembersName = meetingMembers.stream().map(members -> members.split(" ")[0]).collect(Collectors.toList()); //List of Member Name
		List<String> sortedMembersID = meetingMembers.stream().map(members -> members.split(" ")[1]).collect(Collectors.toList()); //List of Member-ID
		
		MeetingAttendeeServiceImpl attendersTbl_Sref = new MeetingAttendeeServiceImpl();
		attendersTbl_Sref.deleteAttendee(Integer.parseInt(meetingIds)); // delete from meeting_attenders where bookingId = bookingID;
		attendersTbl_Sref.addEnteries(sortedMembersID,Integer.parseInt(meetingIds)); // insert into meeting_attenders values (userID, bookingID);
		
		BookingTableService booktbl_Sref = new BookingTableServiceImpl();
		booktbl_Sref.editMeeting(title,meetingStartTime,meetingEndTime,meetingType);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
