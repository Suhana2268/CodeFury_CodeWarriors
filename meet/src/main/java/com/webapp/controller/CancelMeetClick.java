package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.BookingTableService;
import com.demo.service.BookingTableServiceImpl;
import com.mysql.cj.Session;

@WebServlet("/CancelMeetClick")
/**
 * Servlet implementation class CancelMeetClick
 */
public class CancelMeetClick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelMeetClick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
	    String managerName = Session.getParameter("userName");
		BookingTableService booktbl_Sref = new BookingTableServiceImpl();
		
		//In the function (bookingId +"#"+title +"#"+meetingDate)
		List<String> listOfBookedMeets = booktbl_Sref.getAllMeets(managerName); 
		request.setParameter("listOfBookedMeets",listOfBookedMeets);
		RequestDispatcher dis=request.getRequestDispatcher("CancelBooking.jsp");          
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
