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
	<th>User Id</th>
	<th>Email</th>
	<th>password</th>
	<th>location</th>
	<th>Age</th>
	<th>Mobile Number</th>
	<th>Date Of Birth</th>
</tr>
<c:forEach var="i" items="${ulist}">
<tr>
	<td>${i.getUserId()}</td>
	<td>${i.getUserEmail()}</td>
	<td>${i.getPassWord()}</td>
	<td>${i.getLocation()}</td>
	<td>${i.getAge()}</td>
	<td>${i.getUserMobileNo()}</td>
	<td>${i.getDob()}</td>
</tr>
</c:forEach>
</table>
<a href="AdminMenu.jsp" >Go to Admin Menu</a>
</body>
</html>