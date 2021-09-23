<%@page import="java.util.List"%>
<%@page import="com.webapp.models.User"%>
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
<h2 align = "center">LIST OF ALL USERS</h2>
<div><h3>Get Users list by role</h3>
<form action="UserServlet?re=viewUserByRole" method = "post">
<span>Please Enter Role</span><input type = "text" name = "role" id = "role" class = "inp"><input type = submit class = "btn">
<div id = "selectResult"></div>

</form>
</div>
<div style="padding-top: 50px;"> 
<% 
	

	List<User> userList = (List<User>)request.getAttribute("data");
	if(userList != null) {
		String a = "<table border = 2px; align = center><tr><td>Name</td><td>Id</td><td>lastLogin</td><td>Credits</td><td>Role</td></tr>";
		for(User user : userList) {
			a = a+"<tr><td>"+user.getName()+"</td><td>"+user.getUserId()+"</td><td>"+user.getLastLogin()+"</td><td>"+user.getCredit()+"</td><td>"+user.getRole()+"</td></tr>";
	
		}
		a = a+"</table>";
		out.println(a);
	}
		
%></div>

<div style="padding-top: 50px;"> 
<% 
	List<User> uList = (List<User>)request.getAttribute("selectdata");
	

	if(uList != null) {
	if(uList.size() > 0) {
				
		String a = "<table border = 2px; align = center><tr><td>Name</td><td>Id</td><td>lastLogin</td><td>Credits</td><td>Role</td></tr>";
		for(User user : uList) {
			a = a+"<tr><td>"+user.getName()+"</td><td>"+user.getUserId()+"</td><td>"+user.getLastLogin()+"</td><td>"+user.getCredit()+"</td><td>"+user.getRole()+"</td></tr>";
	
		}
		a = a+"</table>";
		out.println(a);
	}
	}
		
%></div>

</body>
</html>