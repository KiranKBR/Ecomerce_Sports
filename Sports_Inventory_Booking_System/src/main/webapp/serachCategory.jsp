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
<input type="text" name="bCategory" />
<button type="submit" name="action" value="searchCategory">Search</button>
</form><br><br>
<%
ArrayList <Item> clist=(ArrayList<Item>)request.getAttribute("categoryList");
if(clist!=null){
  %>
<table border="1">
<tr>
		<th>S.No</th>
		<th>Name</th>
		<th>Author</th>
		<th>Category</th>
		<th>Quantity</th>
		<th>Price</th>
</tr>
	<c:forEach var="i" items="${categoryList}">
<tr>
	<td >${i.getBookId()}</td>
	<td >${i.getBookName()}</td>
	<td >${i.getBookAuthor()}</td>
	<td >${i.getBookCategory()}</td>
	<td >${i.getQuantity()}</td>
	<td >${i.getBookPrice()}</td>
	<% if(role.equals("user")){ %> 
	<td ><a href="UserProcessor?action=addCart&bookId=${i.getBookId()}&bookName=${i.getBookName()}&bookPrice=${i.getBookPrice()}" >add To Cart</a></td>
	<td><button type="button" onclick="">BuyNow</button></td>
	<%
	}
	%>
</tr>
	</c:forEach>
</table>
<% 
	}   %>
<% if(role.equals("admin")){ %> 
<a href="AdminMenu.jsp" >Go to Admin Menu</a>
<% }  %>
<% if(role.equals("user")){ %> 
<a href="UserMenu.jsp" >Go to User Menu</a>
<% }  %>
</body>
</html>