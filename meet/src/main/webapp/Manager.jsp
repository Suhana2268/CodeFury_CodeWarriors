<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content=="IE=edge"/>
<meta name="google" value="notranslate"/>
<title>Side Menu</title>

<link rel="stylesheet" type="text/css" href="css/menu.css">
<link rel="stylesheet" type="text/css" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

<link href="manager.css" rel="stylesheet"></link>
</head>
<body>

<div class = "welcome" align="center">

<img alt="user" src="assets/user.png" height = "30px" width="30px;" style="padding-top: 4px;"><span> <%= session.getAttribute("id") %></span>
</div>
</div><nav class="main-menu">


  
 <div>
    <a class="logo" href="http://startific.com">
    </a> 
  </div> 
<div class="settings"></div>
<div class="scrollbar" id="style-1">
      
<ul>
  
<li>                                   
<a href="Home.jsp">
<i class="fa fa-home fa-lg"></i>
<span class="nav-text">Home</span>
</a>
</li>   
   
<li>                                 
<a href="UserServlet?re=viewProfile">
<i class="fa fa-user fa-lg"></i>
<span class="nav-text">Profile</span>
</a>
</li>   

  
<li>                                 
<a href="OrganizeMeet.jsp">
<i class="fa fa-arrow-circle-right"></i>
<span class="nav-text">Organize Meet</span>
</a>
</li>  

  
<li>                                 
<a href="ContactUs.jsp">
<i class="fa fa-envelope-o fa-lg"></i>
<span class="nav-text">Contact</span>
</a>
</li> 


  
</ul>

  
<li>
                                   
<a href="Help.jsp">
<i class="fa fa-question-circle fa-lg"></i>
<span class="nav-text">Help</span>
</a>
</li>  

<li>
                                   
<a href="http://startific.com">
<i class="fa fa-sign-out" aria-hidden="true"></i>
<span class="nav-text">Logout</span>
</a>
</li>   
   
        </nav>
        
<%@ include file = "header.jsp" %>
  </body>
  </html>