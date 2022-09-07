<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
th{
font-weight:bold;
width:100px;
}
table{
border:1px solid;
}

</style>
</head>
<body>
<% 
HttpSession sn=request.getSession();
String role=(String)sn.getAttribute("role");
%>
<table>
<tr>
		<th>Id.No</th>
		<th>Name</th>
		<th>Price</th>
		<th>Category</th>
		<th>SubCategory</th>
		<th>Brand</th>
</tr>
<c:forEach var="i" items="${blist}">
<tr>
	<td >
	${i.getItemId()}<br>
	</td>
	<td>
	${i.getItemName()}<br></td>
	<td>
	${i.getRate()}<br></td>
	<td>
	${i.getCategory() }<br></td>
	<td>
	${i.getSubCategory() }<br></td>
	<td>
	${i.getBrand() }<br></td>
	
	<% if(role.equals("user")){ %> 
	<td ><a href="UserProcessor?action=addCart&bookId=${i.getItemId()}&bookName=${i.getItemName()}&bookPrice=${i.getRate()}&buyerMail=${buyerMail}" >add To Cart</a></td>
	<td><button type="button" onclick="">BuyNow</button></td>
	<%
	}
	%>
</tr>
</c:forEach>
</table><br><br>
<% 
	if(role.equals("admin"))
	{ %>
	<button type="button" onclick="location.href='addItem.jsp' ">Add a Item</button>
	<a href="AdminMenu.jsp" >Go to Admin Menu</a>
<% } %>
<% if(role.equals("user")){ %> 
<a href="UserMenu.jsp" >Go to User Menu</a>
<% } %>
</body>
</html>