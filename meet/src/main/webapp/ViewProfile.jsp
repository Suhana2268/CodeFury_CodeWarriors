<%@page import="com.webapp.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="viewProfile.css" rel="stylesheet"></link>
</head>
<body>
<%@ include file = "header.jsp" %>
<div class = "cnt1">
<div style="padding-top: 100px;"> <%
	User user = (User)request.getAttribute("asd");

	if(user != null) {
		out.println("<table border = 2px; align = center><tr><td>Name</td><td>Id</td><td>lastLogin</td><td>Credits</td><td>Role</td><tr><td>"+user.getName()+"</td><td>"+user.getUserId()+"</td><td>"+user.getLastLogin()+"</td><td>"+user.getCredit()+"</td><td>"+user.getRole()+"</td></tr></tr></table>");
	
	
	}
%></div>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>