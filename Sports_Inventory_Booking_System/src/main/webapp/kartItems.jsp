<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table{
text-align:center;
}
</style>
</head>
<body>
<center>
<table width=500>
<tr>
	<th>Book Id</th>
	<th>Book Name</th>
	<th>Book Price</th>
	<th>Quantity</th>
	<th>Total</th>
</tr>
<c:forEach var="i" items="${clist}">
<tr>
	<td>${i.getBookId()}</td>
	<td>${i.getBookName()}</td>
	<td>${i.getBookPrice()}</td>
	<td>${i.getQuantity()}</td>
	<td>${i.getBookPrice()*i.getQuantity()}</td>
	<c:set var="total" value="${total + i.getBookPrice()*i.getQuantity()}" />
</tr>
</c:forEach>
<tr>
	<td colspan="5"><hr></td>
</tr>
<tr>
	<td colspan="4">Total Amount</td>
	<td>${total}</td>
</tr>
</table>
<br><br>
<a href="UserMenu.jsp" >Go to User Menu</a>
</body>
</html>