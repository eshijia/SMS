<%@ page language="java" contentType="text/html; charset=utf8"%>
<%@ page import="com.cloudlab.model.*" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

	<%
	
	if(session.getAttribute("user") != null) {
		session.removeAttribute("user");
		response.sendRedirect("login.jsp");
	}
	
	%>

</body>
</html>