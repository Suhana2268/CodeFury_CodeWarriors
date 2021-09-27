package com.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.exceptions.NoDataException;
import com.webapp.models.Amenities;
import com.webapp.models.MeetingRoom;
import com.webapp.models.User;
import com.webapp.services.impl.MeetingRoomServiceImpl;
import com.webapp.services.impl.UserServiceImpl;

/**
 * Servlet implementation class OrganizeClick
 */
@WebServlet("/OrganizeClick")
public class OrganizeClick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizeClick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doget()");
		UserServiceImpl Usertbl_ref = new UserServiceImpl();
		List<User> User_details = null;
		try {
			User_details = Usertbl_ref.getAllUsers();
		} catch (NoDataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> Users = new ArrayList<String>();
		for(User e : User_details) {
			Users.add(e.getName()+" "+ e.getUserId()); 
		}
		request.setAttribute("whole_user_records" , Users);
		
		MeetingRoomServiceImpl Meetingtbl_ref = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetingRoomObject = Meetingtbl_ref.getAllMeetingRoom();
		List<String> meetingRoom = new ArrayList<String>();
		
		for(MeetingRoom m : meetingRoomObject) {
			
			meetingRoom.add(m.getMeetingRoomName()+" "+ m.getCapacity()+ " "+ m.getPerHourCost() +" "+ m.getRatingOfRoom() +" "+ m.printAmenities(m.getAmenitiesInRoom())); 
		}
		request.setAttribute("whole_meet_records" , meetingRoom);
		
		RequestDispatcher dis=request.getRequestDispatcher("/meet.webapp/src/main/webapp/OrganizeMeet.jsp");          
	    dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
}
