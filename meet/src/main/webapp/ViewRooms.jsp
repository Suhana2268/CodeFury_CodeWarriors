<%@page import="com.webapp.models.Amenities"%>
<%@page import="java.util.List"%>
<%@page import="com.webapp.models.MeetingRoom"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="viewAll.css" rel="stylesheet"></link>
</head>
<body>
<%@ include file = "header.jsp" %>
<div class = "cnt1">
<div style="padding-top: 100px;">
<div><h3>Get Room by room name</h3>
<form action = "AdminServlet?req=viewRoomByRoomName" method = "post">
	<span>Please enter room name</span><input type = "text" name = "roomName" id = "roomName" class = "inp"><input type = submit class = btn>
	<div id = "searchresult"></div>
</form>
</div>
</div>
<div style="padding-top: 50px;">

<%
	MeetingRoom mroom = (MeetingRoom)request.getAttribute("searchresult");

	if(mroom != null) {
		
		out.println("<table border = 2px; align = center><tr><td>Name</td><td>Capacity</td><td>Amenities</td><td>Cost Per Hour</td><td>Status</td><tr><td>"+mroom.getMeetingRoomName()+"</td><td>"+mroom.getCapacity()+"</td><td>"+mroom.getAmenitiesInRoom()+"</td><td>"+mroom.getPerHourCost()+"</td><td>"+mroom.getActive()+"</td></tr></tr></table>");
		
	}
%>
<div style = "padding-top: 50px;">

	<%
		
		List<MeetingRoom> mroomList = (List<MeetingRoom>)request.getAttribute("searchResult");
		if(mroomList != null) {
			String a = "<table border = 2px; align = center><tr><td>Name</td><td>Capacity</td><td>Amenities</td><td>Cost Per Hour</td><td>Status</td></tr>";
			
			for(MeetingRoom mr: mroomList) {
				a = a+"<tr><td>"+mr.getMeetingRoomName()+"</td><td>"+mr.getCapacity()+"</td><td>"+mr.getAmenitiesInRoom()+"</td><td>"+mr.getPerHourCost()+"</td><td>"+mr.getActive()+"</td></tr>";
				
			}
			a = a+"</table>";
			out.println(a);
		}
	%>
</div>
</div>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>