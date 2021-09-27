<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="login.css" rel="stylesheet"></link>


<script type="text/javascript">

function validate() {
	var userId = document.f1.UId.value;
	var email = document.f1.Email.value;
	var status = false;
	if(userId.length <2) {
		document.getElementById("idloc").innerHTML = "<font color=red>Invalid Id</font>";
		status = false;
	}
	else {
		document.getElementById("idloc").innerHTML = "<font color= green>Valid Id</font>";
		status = true;
	}
	if(email == "") {
		document.getElementById("emailoc").innerHTML = "<font color=red>Invalid email Id</font>";
		status = false;
	}
	else {
		document.getElementById("emailoc").innerHTMl = "<font color=green>Valid email Id</font>";
		status = true
	}
	return status;
}
 
</script>


</head>
<body>
<%@ include file = "header.jsp" %>
<h2>Login Page</h2>   
    <div class="login">    
    <form id="login" action = "UserServlet?re=login" method="post" name = "f1" onsubmit="return validate()">
     
        <label class = "lb"><b class = "lb">UserId    
        </b>
        </label>
        <input type="text" name="UId" id="UId" placeholder="Userid"><span id="idloc"></span> 
        <br><br>  
        <label class = "lb"><b class = "lb">Email     
        </b>
        </label> 
        <input type="email" name="Email" id="Email" placeholder="Email"> <span id="emailoc"></span>   
        <br><br>    
        <input type="submit" name="log" id="log" value="Log In Here">       
        <br><br> 
        <div class = "rem" align = "center">  
        <input type="checkbox" id="check">    
        <span>Remember me</span>    
    </div> 
    </form>   
</div> 
<%@ include file = "footer.jsp" %>
</body>
</html>
