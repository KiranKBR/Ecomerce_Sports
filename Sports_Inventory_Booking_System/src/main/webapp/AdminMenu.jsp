<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Successful</h1>
<table>
<tr>
	<td>Add an Admin</td>
	<td><a href="AdminSignUp.jsp">Click Here</a></td>
</tr>
<tr>
	<td>View all the Items</td>
	<td><a href="AdminProcessor?action=viewItems">Click Here</a></td>
</tr>
<tr>
	<td>Add the new Item</td>
	<td><a href="addBook.jsp">Click Here</a></td>
</tr>
<tr>
	<td>Search by Category of Item</td>
	<td><a href="searchCategory.jsp">Click Here</a></td>
</tr>
<tr>
	<td>Remove Item</td>
	<td><a href="removeBook.jsp">Click Here</a></td>
</tr>
<tr>
	<td>Change Item Price</td>
	<td><a href="modifyBook.jsp">Click Here</a></td>
</tr>
<tr>
	<td>View all Users</td>
	<td><a href="AdminProcessor?action=viewUsers">Click Here</a></td>
</tr>
<tr>
	<td>Remove User</td>
	<td><a href="removeUser.jsp">Click Here</a></td>
</tr>
<tr>
	<td colspan="2"><button type="button" onclick="location.href='AdminProcessor?action=signout'">Signout</button></td>
</tr>
</table>
</body>
</html>