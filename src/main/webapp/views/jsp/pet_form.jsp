<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/PetPeer/styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="script.js"></script>
<title>Add a Pet</title>
</head>
<body>
<% 
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%
	//allow access only if session exists
	if(session.getAttribute("user")==null){
		response.sendRedirect("/PetPeer/views/jsp/login.jsp");
	}
%>
<div id='cssmenu'>
<ul>
   <li><a href='/PetPeer/PetDetails'><span>Home</span></a></li>
   <li class='active'><a href='/PetPeer/views/jsp/pet_form.jsp'><span>Add Pet</span></a></li>
   <li><a href='/PetPeer/views/jsp/logout.jsp'><span>Logout</span></a></li>
</ul>
</div>

<div class='head'>
Pet Information
</div>
<br><br><br><br><br>

<form  name="petForm" action="/PetPeer/register" method="post" style="text-align: center;">
<input type="hidden" name="jspPage" value="pet_form.jsp" />
<br>
<pre>      <b>Name</b>          <input type="text" name="name" required></pre>
<br>
<pre>      <b>Age</b>           <input type="number" name="age" required></pre>
<br>
<pre>      <b>Place</b>         <input type="text" name="place" required></pre>
<br>
<br>
<pre>                 <input type="submit" name="save" value="Save">   <button type="reset" name="reset" value="Reset">Cancel</button></pre> 
</form>

</body>
</html>