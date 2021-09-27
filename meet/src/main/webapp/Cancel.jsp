<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/CancelBooking" method = "post" onsubmit="return validate()" >

	<!-- For canceling the Booked Meeting -->
	
	<select id = "selectMeet" name="selectMeet">
		<option >---Select Meeting to Cancel---</option>
	  <c:forEach items=<% request.getAttribute("listOfBookedMeets"); %> var="meetname" varStatus="loop">
		   <option value="${loop.index}">
		       ${meetname}
		    </option>
	  </c:forEach>
	</select>
	<input type = "submit" value = Cancel>
	</form>

</body>
</html>