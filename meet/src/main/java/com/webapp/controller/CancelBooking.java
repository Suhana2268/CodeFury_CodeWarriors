package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.models.MeetingAttendee;
import com.webapp.services.impl.MeetingAttendeeServiceImpl;
@WebServlet("/CancelBooking")
/**
 * Servlet implementation class CancelBooking
 */
public class CancelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String meetinfo = request.getParameter("selectMeet");
		String selectedMeetID = meetinfo.split("#")[0];
		String selectedMeetTitle = meetinfo.split("#")[1];
		String selectedMeetDate = meetinfo.split("#")[1];
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//delete record from booking Table
		BookingTableService booktbl_Sref = new BookingTableServiceImpl();
		booktbl_Sref.cancelMeet(selectedMeetID);  //SQL-Query :-    DELETE FROM booking WHERE meetingRoomName=selectedMeetID;
		
		//delete records from meeting_attenders Table
		MeetingAttendeeServiceImpl attendersTbl_Sref = new MeetingAttendeeServiceImpl();
		attendersTbl_Sref.deleteAttendee(Integer.parseInt(selectedMeetID)); //SQL-Query :-    DELETE FROM meeting_attenders WHERE bookingId=selectedMeetID;
		
		out.println("Booking cancelled");
		
		RequestDispatcher dis=request.getRequestDispatcher("Cancel.jsp");          
        dis.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
