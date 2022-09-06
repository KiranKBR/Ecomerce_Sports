<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
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
<center>
<table>

<c:forEach var="i" items="${blist}">
<tr>
	<td >
	${i.getBookName()}<br>
	${i.getBookAuthor()}<br>
	${i.getBookPrice()}RS</td><br><br>
	<% if(role.equals("user")){ %> 
	<td ><a href="UserProcessor?action=addCart&bookId=${i.getBookId()}&bookName=${i.getBookName()}&bookPrice=${i.getBookPrice()}&buyerMail=${buyerMail}" >add To Cart</a></td>
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
	<button type="button" onclick="location.href='addBook.jsp' ">Add a Book</button>
	<a href="AdminMenu.jsp" >Go to Admin Menu</a>
<% } %>
<% if(role.equals("user")){ %> 
<a href="UserMenu.jsp" >Go to User Menu</a>
<% } %>
</body>
</html>