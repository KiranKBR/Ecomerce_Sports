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
<form action="AdminProcessor">
<h4>Enter the userID to remove:</h4>
<input type="text" name="emailId" />
<button type="submit" name="action" value="removeUser">Remove</button>
</form>
<br>
<c:choose>
	<c:when test="${flag==1}">
		<h1>Removed Success</h1>
	</c:when>
	<c:when test="${flag==0}">
		<h1>User doesn't Exist</h1>
	</c:when>
</c:choose>
<a href="AdminMenu.jsp" >Go to Admin Menu</a>
</body>
</html>