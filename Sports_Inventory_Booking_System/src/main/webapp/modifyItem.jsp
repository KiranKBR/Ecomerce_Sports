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

	
	<form action="AdminProcessor">
	<table>
	<tr>
		<td><input type="number" name="eId"></td>
	</tr>
	<tr>
		
		<td><input type="number" name="nwPrice" /></td>
	</tr>
	<tr>
		<td colspan="2"><button type="submit" name="action" value="changeItemPrice" >Update</button>
	</table>
	</form>
</body>
</html>