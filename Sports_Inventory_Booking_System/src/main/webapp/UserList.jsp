<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>welcome</h1>
<table width=700 >
<tr>
	<th>Email Id</th>
	<th>Name</th>
	<th>password</th>
	
</tr>
<c:forEach var="i" items="${ulist}">
<tr>

	<td>${i.getEmailId()}</td>
		<td>${i.getUserName()}</td>
	<td>${i.getPassword()}</td>
	
</tr>
</c:forEach>
</table>
<a href="AdminMenu.jsp" >Go to Admin Menu</a>
</body>
</html>