package com.webapp.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.exceptions.NoDataException;
import com.webapp.exceptions.UserNotFoundException;
import com.webapp.factory.UserServiceFactory;
import com.webapp.models.User;
import com.webapp.services.UserService;


/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        userService = UserServiceFactory.createServiceObject();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String a = request.getParameter("re");
		System.out.println(a);
		PrintWriter out = response.getWriter();
		
		if(a.equals("login")) {
			String email = request.getParameter("Email");
			
			boolean i = false;
			
			i = userService.verifyUser(email);
			
			if(i) {
				
				
				HttpSession ss=request.getSession(true);
				ss.setAttribute("id", email);
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Admin.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("Wrong credentials");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login.jsp");
				rd.include(request, response);

			}
			
			
		}
		
if(a.equals("viewProfile")) {
			
			HttpSession ss = request.getSession(true);
			String email = ss.getAttribute("id").toString();
			User user = null;

			try {
				user = userService.getUserByEmail(email);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			if(user != null) {
				request.setAttribute("asd", user);
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewProfile.jsp");
				rd.forward(request, response);

			}
			else {
				request.setAttribute("asd", "profile not found");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Admin.jsp");
				rd.include(request, response);
			}
		}

		if(a.equals("viewAllUsers")) {
			List<User> userList = null;
			try {
				userList = userService.getAllUsers();
			} catch (NoDataException e) {
				e.printStackTrace();
			}
			if(userList.size() > 0) {
				request.setAttribute("data", userList);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewAllUsers.jsp");
				rd.forward(request, response);
			}
		}
		
		if(a.equals("viewUserByRole")) {
			
			List<User> uList = null;
						
			String rvalue = request.getParameter("role");
			try {
				uList =userService.getUserByRole(rvalue);
			} catch (NoDataException e) {
				e.printStackTrace();
			}
			System.out.println(uList.size());
			if(uList.size() > 0) {
				request.setAttribute("selectdata", uList);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewAllUsers.jsp");
				rd.forward(request, response);

			}
			}
		}
		
	

}
