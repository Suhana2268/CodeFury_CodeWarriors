package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.BookingTableService;
import com.demo.service.BookingTableServiceImpl;
import com.webapp.models.Booking;
import com.webapp.models.MeetingRoom;
import com.webapp.models.User;
import com.webapp.services.MeetingRoomService;
import com.webapp.services.impl.MeetingRoomServiceImpl;
import com.webapp.services.impl.UserServiceImpl;
@WebServlet("/OrganizeMeetServlet")

/**
 * Servlet implementation class OrganizeMeetServlet
 */
public class OrganizeMeetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizeMeetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter formattime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
        
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
        HttpSession session = request.getSession();
		Random rand = new Random();
		
		
		String title = request.getParameter("title"); //title
        LocalDateTime meetingStartTime = LocalDateTime.parse(request.getParameter("meetingDate"), formattime); //Meeting date time 
        String x = request.getParameter("duration");
        LocalDateTime meetingEndTime = meetingStartTime.plusHours(Long.parseLong(x)); //Meeting end time
        UserServiceImpl user_Sref = new UserServiceImpl();
        
		String bookedBy= user_Sref.getManagerName(session.getAttribute("id").toString());
		String meetingType = request.getParameter("meetingType"); //meeting Type
		int bookingStatus = 1; //booking status
		List<String> meetingMembers = request.getParameter("addmembers");//Members & ID for the meeting
		List<String> sortedMembersName = meetingMembers.stream().map(members -> members.split(" ")[0]).collect(Collectors.toList()); //List of Member Name
		List<String> sortedMembersID = meetingMembers.stream().map(members -> members.split(" ")[1]).collect(Collectors.toList()); //List of Member-ID
		int meetingIds = rand.nextInt(999999999);
		int meetingPass = rand.nextInt(999999999);
		
	
		
	
		
		//Get user Emails & ManagerEmail
		List<String> UserEmails = user_Sref.getAllUsers(sortedMembersID); //SQL-Query :- SELECT email From users WHERE userId = UserID;
		String ManagerEmail = user_Sref.getUserInfo(bookedBy); //SQL-Query :- SELECT email From users WHERE name = managerName;
		
		//Cost of the meeting name & cost
		String meetingRoomName = request.getParameter("meetingroom").toString().split(" ")[0];
		MeetingRoomService Meetingtbl_Ref = new MeetingRoomServiceImpl();
		int costOfTheMeeting = Meetingtbl_Ref.getPerHourCost(meetingRoomName);
		
		//Create booking service
				BookingTableService Bookingtbl_Ref = new BookingTableServiceImpl();
				Bookingtbl_Ref.createTheBooking(title,meetingStartTime,meetingEndTime,bookedBy,meetingType,costOfTheMeeting,meetingIds,meetingPass,meetingRoomName);
				
				// insert into meeting_attenders values (userID, meetingIds);
				MeetingAttendersService attendersTbl_Sref = new MeetingAttendersServiceImpl();
				attendersTbl_Sref.addEnteries(sortedMembersID,meetingIds);
		
				out.println("Room Booked");
		RequestDispatcher dis=request.getRequestDispatcher("OrganizeMeet.jsp");          
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
