<%

String mail =(String) request.getSession().getAttribute("user");
if (mail != null) {
    request.setAttribute("auth", mail);
}%>

<!DOCTYPE html>
<html>
<head>
<title>Profile</title>
<%@include file="includes/head.jsp"%>
</head>
<body >
	<%@include file="includes/adminnav.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Profile</div>
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
						<input type="text" name="address" class="form-control" placeholder="Address">
					</div>
					<div class="form-group">
						<label>Phone number</label> 
						<input type="text" name="number" class="form-control" placeholder="Number">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" name="action" value="signup">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>