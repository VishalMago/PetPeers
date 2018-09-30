<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,com.model.Pet" %>
<%@page language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/PetPeer/styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="script.js"></script>
<title>Home</title>
</head>
<body onload="document.forms['homeForm'].submit()">
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
   <li class='active'><a href='#'><span>Home</span></a></li>
   <li><a href='/PetPeer/MyPets'><span>My Pets</span></a></li>
   <li><a href='/PetPeer/views/jsp/pet_form.jsp'><span>Add Pet</span></a></li>
   <li><a href='/PetPeer/views/jsp/logout.jsp'><span>Logout</span></a></li>
</ul>
</div>
<center>
<h2>Pet List</h2>
        
        <table border="1" width="700" height="500">
			<tr>
				<td width="119" align="center"><font size="5sp"><b>#</b></font></td>
				<td width="168" align="center" ><font size="5sp"><b>Pet Name</b></font></td>
				<td width="168" align="center"><font size="5sp"><b>Place</b></font></td>
				<td width="119" align="center"><font size="5sp"><b>Age</b></font></td>
				<td width="168" align="center"><font size="5sp"><b>Action</b></font></td>
			</tr>
		<% 
		@SuppressWarnings({"unchecked"})
		List<Pet> petList= (List<Pet>)request.getAttribute("pet");
		for (int i=0;i<petList.size();i++)
		{
		%>
		<tr>
			<td width="119" align="center"><font size="4sp"><%=petList.get(i).getPetId()%></font></td>
			<td width="168" align="center"><font size="4sp"><%=petList.get(i).getPetName()%></font></td>
			<td width="168" align="center"><font size="4sp"><%=petList.get(i).getPetPlace()%></font></td>
			<td width="119" align="center"><font size="4sp"><%=petList.get(i).getPetAge()%></font></td>
			<td width="168" align="center"><%if(petList.get(i).getOwnerId()!=0){%><input type="button" value="Sold" disabled="disabled"></input><% } else{ %><form action="/PetPeer/BuyPet" method="post"><input type="hidden" name="petId" value="<%=petList.get(i).getPetId()%>"></input> <input type="submit" value=Buy></form><%}%></td>
		</tr>
		<%}%>
		</table>
</center>
</body>
</html>