

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@include file="includes/head.jsp"%>
<script>
//Example starter JavaScript for disabling form submissions if there are invalid fields

</script>
</head>

<body >
	
	<div class="container" >
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Signup</div>
			<div class="card-body">
				<form action="UserProcessor" class=" requires-validation" method="post" novalidate>
					<div class="form-group">
						<label for="validationCustom01" class="form-label">Email address</label> 
						<input type="email" name="email" id="validationCustom01" class="form-control" placeholder="Enter email" required >
					</div>
					<div class="form-group">
						<label for="validationCustom02" class="form-label">Name</label> 
						<input type="text" name="name" id="validationCustom06\2" class="form-control" placeholder="Enter Name" required>
					</div>
					<div class="form-group">
						<label for="validationCustom03" class="form-label">Password</label> 
						<input type="password" name="password" id="validationCustom03" class="form-control" placeholder="Password" required>
					</div>
					<div class="form-group">
						<label for="validationCustom04" class="form-label">Age</label> 
						<input type="number" name="age" id=validationCustom04" class="form-control" placeholder="Age"  required>
					</div>
					<div class="form-group">
						<label for="validationCustom05" class="form-label">Address</label> 
						<input type="text" name="address" id="validationCustom05" class="form-control" placeholder="Address" required>
					</div>
					<div class="form-group">
						<label for="validationCustom06" class="form-label">Phone number</label> 
						<input type="text" name="number" id="validationCustom06" class="form-control" placeholder="Number" required>
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