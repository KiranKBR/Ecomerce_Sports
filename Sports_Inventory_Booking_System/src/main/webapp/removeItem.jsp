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
<% 
HttpSession sn=request.getSession();
String role=(String)sn.getAttribute("role");
%>
<form action="AdminProcessor">
<h4>Enter the Book Id </h4>
<input type="number" name="bId" />
<button type="submit" name="action" value="removeBook">Remove</button>
</form>
<% if(role.equals("admin")){ %>
	<a href="AdminMenu.jsp" >Go to Admin Menu</a>
<% } %>
<br><br>
<c:choose>
	<c:when test="${flag==1}">
		<h1>Removed Success</h1>
	</c:when>
	<c:when test="${flag==0}">
		<h1>Book Doesn't Exist</h1>
	</c:when>
</c:choose>
</body>
</html>