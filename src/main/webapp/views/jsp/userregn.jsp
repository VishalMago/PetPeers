<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/PetPeer/styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="script.js"></script>
<title>UserRegistration</title>
</head>
<body>
<% 
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<div id='cssmenu'>
<ul>
   <li><a href='/PetPeer/PetDetails'><span>Home</span></a></li>
   <li><a href='/PetPeer/views/jsp/login.jsp'><span>Login</span></a></li>
   <li class='active'><a href='/PetPeer/views/jsp/userregn.jsp'><span>User Registration</span></a></li>

</ul>
</div>
<br><br><br><br><br>

<form  name="registrationForm" action="/PetPeer/register" method="post" style="text-align: center;">
<input type="hidden" name="jspPage" value="userregn.jsp" />
<br>
<pre>      <b>User Name</b>          <input type="text" name="userName" required></pre>
<br>
<pre>      <b>Password </b>          <input type="password" name="password" required></pre>
<br>
<pre>      <b>Confirm Password</b>   <input type="password" name="confirmPassword" required></pre>
<br>
<br>
<pre>                 <input type="submit" name="register" value="Submit">   <button type="reset" name="reset" value="Reset">Reset</button></pre> 
</form>

</body>
</html>