<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!!</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("uname")==null && session.getAttribute("pword")==null) 
			response.sendRedirect("login.jsp");
		else
			out.println("Thanks for visiting my demo project!!!");
	%>
	
	<a href="videos.jsp"> click here for videos </a> <br>
	
	<form action="Logout">
		<input type="submit" value="logout">
	</form>
	
</body>
</html>