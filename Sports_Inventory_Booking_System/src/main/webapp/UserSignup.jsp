<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserProcessor">
<table>

<tr>
	<td>Email</td>
	<td><input type="text" name="uEmail" /></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="uPwd" /></td>
</tr>
<tr>
	<td>Name</td>
	<td><input type="text" name="name" /></td>
</tr>
<tr>
	<td>location</td>
	<td><input type="text" name="ulocation" /></td>
</tr>
<tr>
	<td>age</td>
	<td><input type="number" name="uAge" /></td>
</tr>
<tr>
	<td>Mobile Number</td>
	<td><input type="number" name="uMobileNumber" /></td>
</tr>
<tr>
	<td>Date Of Birth</td>
	<td><input type="date" name="dob" /></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" name="action" value="signup" /></td>
</tr>
</table>
</form>
</body>
</html>