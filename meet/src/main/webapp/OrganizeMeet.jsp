<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="organizemeet.css" rel="stylesheet"></link>
<link rel = "stylesheet" href = "chosen.min.css">

<script type="text/javascript">
function getCapacity(){
	var e = document.getElementById("meetroom");
	var strUser = e.options[e.selectedIndex].text;
	var capacity = Number(strUser.split(" ")[1]);
}
</script>

<script type = "text/javascript" src = "chosen.jquery.min.js"></script>
<script type = "text/javascript"> 
	$(document).ready(fucntion(){
		$('#addmem').choose();
	});
</script>
</head>
<body>
<%@ include file = "header.jsp" %>
<div class="container" align="center">
<div align="center">
<h3>Organize meet</h3>
</div>
<form action="/OrganizeMeetServlet">

<table>
<tr> <td class = "lb">Title</td>
<td><input type = "text" class = "inp" placeholder = "Enter title of the meeting"></td>
</tr>
<tr><td class = "lb">Meeting date</td>
<td><input type = "datetime-local" class = "inp"></td>
</tr>
<tr><td class = "lb">Duration</td>
<td><input type = "number" class = "inp"></td>
</tr>
<tr><td class = "lb">Meeting type</td>
<td><select class = "inp1"><option class = "inp1">Classroom Training</option>
			<option class = "inp1">Conference call</option>
			<option class = "inp1">Online Training</option>
			<option class = "inp1">Busuiness</option>
</select>
</td>
</tr>
<tr><td class = "lb">Add members</td>
<select id = "addmem" name="addmembers">
	<option >---Select Employees---</option>
  <c:forEach items=<% request.getAttribute("whole_emp_records"); %> var="employeename" varStatus="loop">
    <option value="${loop.index}">
        ${employeename}
    </option>
  </c:forEach>
</select>
</tr>
<tr><td class = "lb">Select Meeting room</td>
<select id = "meeetroom" name="meetingroom" onchange="getCapacity()">
	<option >---Select Meeting room---</option>
  <c:forEach items=<% request.getAttribute("whole_mroom"); %> var="roomname" varStatus="loop">
    <option value="${loop.index}">
        ${roomname}
    </option>
  </c:forEach>
</select>
</tr>
</table>
<input type = "button" value = "Organize meeting" class = "sbtn">
<input type = "button" value = "Cancel" class = "sbtn1">
</form>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>
