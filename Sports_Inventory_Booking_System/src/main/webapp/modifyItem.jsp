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
<ceter>
<table>
<form action="AdminProcessor">
<table>
<tr>
	<td>Book Id</td>
	<td><input type="number" name="bId"></td>
	<td><button type="submit" name="action" value="isBookExist">Click</button></td>
</tr>
</table>
</form>
<c:choose>
	<c:when test="${currentPrice!=null}">
	<form action="AdminProcessor">
	<table>
	<tr>
		<th>Current Price</th>
		<th>New Price</th>
	</tr>
	<tr>
		<td>${currentPrice}</td>
		<td><input type="number" name="nwPrice" /></td>
	</tr>
	<tr>
		<td colspan="2"><button type="submit" name="action" value="changeBookPrice" >Update</button>
	</table>
	</form>
	</c:when>
</c:choose>
</table>
</body>
</html>