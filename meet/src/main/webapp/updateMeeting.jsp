<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="organizemeet.css" rel="stylesheet"></link>
<link rel = "stylesheet" href = "chosen.min.css">
<script type = "text/javascript" src = "jquery-3.6.0.min.js"></script>
<script type = "text/javascript" src = "chosen.jquery.min.js"></script>
<script type="text/javascript">
	function editemployee(){
		var e = document.getElementById("selectMeet");
		var str = e.options[e.selectedIndex].text;
		var meetingID = str.split("#")[0];
		
		
		var xhr=new XMLHttpRequest();
		xhr.open("POST","GetMeetingDetails?meetID="+meee,true);
		xhr.send();
		
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				console.log(xhr.responseText);
				//eval("response = "+xhr.responseText+";");
				document.getElementById("editresult").innerHTML=xhr.responseText;
				}
		}
	}
</script>

<body>
<%@ include file = "header.jsp" %>
<div class="container" align="center">
<div align="center">
<h3>Organize meet</h3>
</div>
<form action="editTheMeet">

<table>
<tr>
<td></td>
<td class = "inp">
	<select id = "selectMeet" name="selectMeet" onchange = "editemployee()">
		<option >---Select Meeting to edit---</option>
	  <c:forEach items=<% request.getAttribute("listOfBookedMeets"); %> var="meetname" varStatus="loop">
		   <option value="${loop.index}">
		       ${meetname}
		    </option>
	  </c:forEach>
	</select>
</td>
</tr>
<tr> <td class = "lb">Title</td>
<td><input type = "text" name ="title" class = "inp" placeholder ="{title}"></td>
</tr>
<tr><td class = "lb">Meeting date</td>
<td><input type = "datetime-local" name = "meetingDate" class = "inp" placeholder = "${meetingDate}" ></td>
</tr>
<tr><td class = "lb">Duration</td>
<td><input type = "number" name = "duratiion" class = "inp"></td>
</tr>
<tr><td class = "lb">Meeting type</td>
<td><select class = "inp1" name ="meetingType"><option class = "inp1" selected = "selected">${meetingType}</option>
			<option class = "inp1">Classroom Training</option>
			<option class = "inp1">Conference call</option>
			<option class = "inp1">Online Training</option>
			<option class = "inp1">Busuiness</option>
</select>
</td>
</tr>
<tr><td class = "lb">Add members</td>
<select id = "addmem" name="addmembers">
<c:forEach items=<% request.getAttribute("UserID_Name_Email"); %> var="employeename" varStatus="loop">
<option value="${loop.index}" selected="selected">
    ${employeename}
</option>
</c:forEach>
  <c:forEach items=<% request.getAttribute("AllUserID_Name_Email"); %> var="employeename" varStatus="loop">
    <option value="${loop.index}+3">
        ${employeename}
    </option>
  </c:forEach>
</select>
</tr>
</table>
</form>
</div>
<script type = "text/javascript"> 
	$(document).ready(fucntion(){
		$('#addmem').choose();
	});
</script>
<%@ include file = "footer.jsp" %>
</body>
</html>
