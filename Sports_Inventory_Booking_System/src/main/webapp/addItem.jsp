<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">a
<title>Insert title here</title>
</head>
<body>
<form action="AdminProcessor">
<table>
<tr>
	<td>Book id:</td>
	<td><input type="number" name="bId" /></td>
</tr>
<tr>
	<td>Item Name:</td>
	<td><input type="text" name="IName" /></td>
</tr>
<tr>
	<td>Brand:</td>
	<td><input type="text" name="bAuthor" /></td>
</tr>
<tr>
	<td>Category:</td>
	<td><input type="text" name="bCategory" /></td>
</tr>
<tr>
	<td>Sub Category:</td>
	<td><input type="text" name="bCategory" /></td>
</tr>
<tr>
	<td>Quantity:</td>
	<td><input type="number" name="quantity" /></td>
</tr>
<tr>
	<td>Price</td>
	<td><input type="number" name="bPrice" /></td>
</tr>
<tr>
	<td>Add the book</td>
	<td><input type="file" name="image" /></td>
</tr>
<tr>
	<td colspan="2"><button type="submit" name="action" value="addBook">Add</button>
</table>
</form>
<button type="button"  onclick="location.href='AdminProcessor?action=viewBooks' ">View Books</button>
</body>
</html>