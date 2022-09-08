

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
						<label>Name</label> 
						<input type="text" name="name" class="form-control" placeholder="Enter Name">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					<div class="form-group">
						<label>Age</label> 
						<input type="number" name="age" class="form-control" placeholder="Age">
					</div>
					<div class="form-group">
						<label>Address</label> 
						<input type="text" name="age" class="form-control" placeholder="Address">
					</div>
					<div class="form-group">
						<label>Phone number</label> 
						<input type="text" name="number" class="form-control" placeholder="Number">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" name="action" value="signup">SignUp</button>
					</div>
					<button type="button" id="signup" class="cancelbtn" onclick="location.href='login.jsp'">Have an account?</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>