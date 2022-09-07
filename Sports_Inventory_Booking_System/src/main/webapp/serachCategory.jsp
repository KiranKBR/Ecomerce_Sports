<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,dto.*"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<% 
HttpSession sn=request.getSession();
String role=(String)sn.getAttribute("role");
%>
<form action="AdminProcessor">
<input type="text" name="category" />
<button type="submit" name="action" value="searchCategory">Search</button>
</form><br><br>
<c:choose>
<c:when test="${categoryList!='null'}">
<table border="1">
<tr>
		<th>Id.No</th>
		<th>Name</th>
		<th>Price</th>
		<th>Category</th>
		<th>SubCategory</th>
		<th>Brand</th>
</tr>
	<c:forEach var="i" items="${categoryList}">
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
	<td ><a href="UserProcessor?action=addCart&bookId=${i.getItemId()}&bookName=${i.getItemName()}&bookPrice=${i.getRate()}" >add To Cart</a></td>
	<td><button type="button" onclick="">BuyNow</button></td>
	<%
	}
	%>
</tr>
	</c:forEach>
</table>
</c:when>
</c:choose>

<% if(role.equals("admin")){ %> 
<a href="AdminMenu.jsp" >Go to Admin Menu</a>
<% }  %>
<% if(role.equals("user")){ %> 
<a href="UserMenu.jsp" >Go to User Menu</a>
<% }  %>
</body>
</html>