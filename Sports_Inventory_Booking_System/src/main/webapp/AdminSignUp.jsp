<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=text],
input[type=email],
input[type=password]{
   	width: 100%;
    padding:10px 20px;
	margin: 8px 0;
    display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
 }
 button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        width: 100%;
    }
 button:active 
    {background-color: #61ede8};
</style>
</head>
<body>
<center>
<h1>SignUp Form</h1>
<form action="AdminProcessor">
<table width=500 height=250>
<tr>
	<td><b>Name:</b></td>
	<td><input type="text" name="adName" required /></td>
</tr>
<tr>
	<td><b>Email:</b></td>
	<td><input type="email" name="adEmail" required/></td>
</tr>
<tr>
	<td><b>Password</b></td>
	<td><input type="password" name="adPwd" required/></td>
</tr>
<tr>
	<td colspan="2"><button type="submit" name="action" value="adsignup">SignUp</button></td>
</tr>
</table>
</form>
</body>
</html>