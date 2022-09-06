<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>View all the Items</td>
	<td><a href="UserProcessor?action=viewItemss">Click Here</a></td>
</tr>
<tr>
	<td>Search by Category of Item</td>
	<td><a href="searchCategory.jsp">Click Here</a></td>
</tr>
<tr>
	<td>View Cart Items</td>
	<td><a href="UserProcessor?action=viewCart&buyer=${buyerMail}">Click Here</a></td>
</tr>
<tr>
	<td>SignOut</td>
	<td><a href="UserProcessor?action=signOut">Click Here</a></td>
</tr>
</table>
</body>
</html>