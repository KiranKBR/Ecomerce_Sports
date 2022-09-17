

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@include file="includes/head.jsp"%>
</head>
<body >
	
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="UserProcessor" >
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" name="action" value="userLogin">Login</button>
					</div>
					<button type="button" id="signup" class="cancelbtn" onclick="location.href='UserSignup.jsp'">New User?Sign UP</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="includes/footer.jsp"%>
<script src="js/script.js"></script>
</body>
</html>