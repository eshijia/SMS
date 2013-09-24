<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<html>
<head>

</head>
<body>

	<%
	
	if(application.getAttribute("user") != null) {
		application.removeAttribute("user");
		response.sendRedirect("login.jsp");
	}
	
	%>

</body>
</html>