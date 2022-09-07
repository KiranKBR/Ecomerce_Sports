<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
    .div1{
    margin-left:30%;
    margin-right:30%
    }
    input[type=text],
    input[type=password] {
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
    button:hover {
        opacity: 1;
    }
    button:active 
    {background-color: #61ede8}
    .cancelbtn {
        width: 100%;
        padding: 10px 18px;
        background-color: #f44336;
    }
</style>
</head>
<body>

<h2><center>Login Form</center></h2>
    <form action="AdminProcessor">
        <div class="div1">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>
 
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
 
            <button type="submit" name="action" value="adLogin">Login</button>
      
        </div>
 
        <div class="div1" >
            <button type="button" class="cancelbtn" onclick="location.href='index.html'">Cancel</button>
        </div>
  </form>
 
</body>
</html>