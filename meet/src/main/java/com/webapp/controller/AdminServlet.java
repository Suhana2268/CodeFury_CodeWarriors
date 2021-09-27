package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.webapp.factory.AmenityServiceFactory;
import com.webapp.factory.MeetingRoomServiceFactory;
import com.webapp.models.Amenities;
import com.webapp.models.MeetingRoom;
import com.webapp.services.AmenitiesService;
import com.webapp.services.MeetingRoomService;
import com.webapp.services.RoomAmenityService;
import com.webapp.services.impl.AmenitiesServiceImpl;
import com.webapp.services.impl.MeetingRoomServiceImpl;
import com.webapp.services.impl.RoomAmenityServiceImpl;




/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MeetingRoomService meetService;
	AmenitiesService amenityService;
	RoomAmenityService roomService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
        meetService = MeetingRoomServiceFactory.getMeetService();
        amenityService = AmenityServiceFactory.getAmenityService();
        roomService = new RoomAmenityServiceImpl();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String a = request.getParameter("req");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(a.equalsIgnoreCase("createRoom")) {
			
			String roomName = request.getParameter("rname");
			String roomCapacity = request.getParameter("rcap");
			String[] amenities = request.getParameterValues("amenity");
			
			String[] amen = null;
			String np = "";
			for(String str: amenities) {
				out.println(str);
				np = np + str;
			}
			
			Gson g=new Gson();
			String ss=g.toJson(np);
			
			String arr[] = ss.split("!");
			
			String arr2[] = new String[arr.length];
			int k = 0;
			for(String a1: arr) {
				a1 = a1.replace("\"", "");
				a1 = a1.replace("!", "");
				a1 = a1.replace("\n", "");
				arr2[k++] = a1;
			}
			
			
			
			
			List<Integer> amenityIds = new ArrayList<Integer>();
			
			for(int l = 0; l < arr2.length-1; l++) {
				amenityIds.add(amenityService.getAmenityInfoByName(arr2[l]).getAmenityId());
			}
			
			System.out.println(amenityIds);
			
			boolean x = false;
			
			int capacity = Integer.parseInt(roomCapacity);
			
			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom.setMeetingRoomName(roomName);
			meetingRoom.setCapacity(capacity);
			
			System.out.println(roomName);
			System.out.println(capacity);
			System.out.println(amenityIds);
			
			
			boolean i = false;
			 i = meetService.addMeetingRoom(roomName, capacity, amenityIds);
			 
			 if(i) {
				 request.setAttribute("Createdmessage", "meeting room created");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Admin.jsp");
				rd.forward(request, response);
			 }
			 else {
				 out.println("Could not create room");
			 }
			
		
		}
		
		if(a.equalsIgnoreCase("viewRoomByRoomName")) {
			HttpSession ss = request.getSession(true);
			String rvalue = request.getParameter("roomName");
			
			MeetingRoom mroom = null;
			
			mroom = meetService.getMeetingRoomInfo(rvalue);
			if(mroom != null) {
				request.setAttribute("searchresult", mroom);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewRooms.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("searchresult", "Room does not exist");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Admin.jsp");
				rd.include(request, response);
			}
		}
		if(a.equalsIgnoreCase("viewAllRooms")) {
			
			List<MeetingRoom> mroomList = meetService.getAllMeetingRoom();
			
			if(mroomList.size() > 0) {
				request.setAttribute("searchResult", mroomList);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewRooms.jsp");
				rd.forward(request, response);
			}
			
			
		}
		
		if(a.equalsIgnoreCase("editMeetRoom")) {
			String rname = request.getParameter("roomname");
			System.out.println(rname);
			System.out.println("inside edit room");
			MeetingRoom mroom = null;
			
			mroom = meetService.getMeetingRoomInfo(rname);
			System.out.println(rname);
			System.out.println(mroom);
			
			
			
			if(mroom != null) {
				request.setAttribute("myresult", mroom);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/editRoom.jsp");
				rd.forward(request, response);

				
			}
			else {
				out.print("Meeting room not found");
			}
		}
		
		if(a.equalsIgnoreCase("editRoomByname")) {
			System.out.println("Inside a equals");
			String roomName = request.getParameter("meetingName");
			String roomCapacity = request.getParameter("meetingCap");
			
			int capacity = Integer.parseInt(roomCapacity);
			
			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom.setMeetingRoomName(roomName);
			meetingRoom.setCapacity(capacity);
			
			
			
			boolean i = false;
			 i = meetService.editMeetingRoomCapacity(capacity, roomName);
			 
			 if(i) {
				 System.out.println("Insid=====");
				 out.println("room edited");
			 }
			 else {
				 out.println("Could not edit room");
			 }
			
		
		}
		
		
	}

}