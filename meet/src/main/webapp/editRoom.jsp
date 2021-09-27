<%@page import="com.webapp.models.MeetingRoom"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="editMeet.css" rel="stylesheet"></link>
</head>
<body>
<%@ include file = "header.jsp" %>
<div class = "cnt1">
<form action= AdminServlet?req=editMeetRoom method="post" id = f1>
<h4>Please enter meeting room name to update</h4><input type = "text" name = roomname id = rid>
<input type = submit>
<div id = "myresult"></div>
</form>

</div>
<div class = "cnt2">
<%

	
	MeetingRoom mroom = (MeetingRoom)request.getAttribute("myresult");
	if(mroom != null) {
		out.println("<form id = f2 action=AdminServlet?req=editRoomByname method=post>");
		String b = "<table border = 5px align = center><tr><td class = xy>Name</td><td class = xy>Capacity</td><td class = xy>Amenities</td><td class = xy>Cost</td><td class = xy>Status</td></tr>";
		b = b + "<tr><td><input type=text name=meetingName class = inp1 id = meetingName value="+mroom.getMeetingRoomName()+" disabled></td><td><input type=text name=meetingCap class = inp1 value="+mroom.getCapacity()+"></td><td><input type=text name=ament class = inp1 value="+mroom.getAmenitiesInRoom()+"></td><td><input type=text class = inp1 name=cph value="+mroom.getPerHourCost()+" disabled></td><td><input type=text name=st class = inp1 value="+mroom.getActive()+"></td><td><input type=submit  class = btn value=edit></td></tr>";
		b = b + "</table>";
		out.println(b+"</form></div>");
	}
	
	%>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>