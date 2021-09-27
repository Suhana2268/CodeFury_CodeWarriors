<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="createRoom.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
   	
   	<link src="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
   	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
   </head>
   
  <script type="text/javascript">
  function validate() {
	  var roomName = document.f1.rname.value;
	  var seatCap = document.f1.rcap.value;
	  console.log(roomName);
	  console.log(roomName.length)
	  var status = false;
	  if(roomName.length < 5) {
		  document.getElementById("roomloc").innerHTML = "<font color=red>Invalid room name</font>";
			status = false;
	  }
	  else if(roomName.length > 5){
		  document.getElementById("roomloc").innerHTML = "<font color=green>Invalid room name</font>";
			status =  true;
	  }
	  
	  if(isNaN(seatCap) || seatCap == 0) {
		  document.getElementById("seatloc").innerHTML = "<font color=red>Invalid input</font>";
			status = false;
	  }
	  
	  else{
		  document.getElementById('seatloc').innerHTML = "<font color=green>Valid</font>";
			status =  true;
	  }
	  return status;
  }
  
  </script> 
   
   
   
<body>
<%@ include file = "header.jsp" %>
</br>
</br>
</br>
  <div class="container cnt">
    <div class="title">Create Room</div>
    <div class="content">
      <form name = "f1" onsubmit="return validate()" method = "post" action = "AdminServlet?req=createRoom">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Room Name</span>
            <input type="text" placeholder="Enter room name" required name = "rname" id = "rname"><span id="roomloc"></span>
          </div>
          <div class="input-box">
            <span class="details">Seating capacity</span>
            <input type="number" placeholder="Enter seating capacity" required name = "rcap" id = "rcap"><span id="seatloc"></span>
          </div>
          <div class="details1">
         <span class="details11">Amenities</span>
          </div>
          </div>
          <div class="container cnt">
  <ul class="ks-cboxtags">
    <li><input type="checkbox"  value="Projector!" id = "pro" name ="amenity"><label for="pro">Projector</label></li>
    <li><input type="checkbox"  value="WiFi Connection!" checked id = "wifi" name = "amenity"><label for="wifi">Wifi Connection</label></li>
    <li><input type="checkbox" value="Conference Call Facility!" id = "con" name = "amenity"><label for="con">Conference call facility</label></li>
    <li><input type="checkbox"  value="Whiteboard!" id = "board" name = "amenity"><label for="board">Whiteboard</label></li>
    <li><input type="checkbox"  value="Water Dispenser!" id = "disp" name = "amenity"><label for="disp">Water Dispenser</label></li>
    <li><input type="checkbox"  value="TV!" id = "tv" name = "amenity"><label for="tv">TV
                    </label></li>
    <li><input type="checkbox" id="checkboxSeven" value="Coffe Machine!" id = "cof" name = "amenity"><label for="cof">Coffee machine</label></li>
  </ul>

</div>
  <div class="button sub">
          <input type="submit" value="Create Room">
          </div>
          <div class = "button can">
          <input type = "reset" value = "Cancel">
        </div>
        </form>
        
    </div>
    </div>
  </br>
  </br>
<%@ include file = "footer.jsp" %>

</body>
</html>
