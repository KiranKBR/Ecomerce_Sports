

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@include file="includes/head.jsp"%>

</head>
<script>
//Example starter JavaScript for disabling form submissions if there are invalid fields

function validateForm()
{
	
	
	var name=document.userForm.name.value;
	//alert(name);
	var email=document.userForm.email.value;
//	alert(email);
	var pass=document.userForm.password.value;
	//alert(pass);
	var age=document.userForm.age.value;
	//alert(age);
	var num=document.userForm.pnumber.value;
	alert(num);
	
	 var phoneregex = /^\d{10}$/;
	var mailregex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!email.match(mailregex))
		{
		
			alert("email not valid");
			return false;
		
		}
	if(!num.match(phoneregex))
		{
		alert("Phone Number not valid");
		return false;
		}
	return true;
}

</script>
<body >
	
	<div class="container" >
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Signup</div>
			<div class="card-body">
				<form action="UserProcessor" name="userForm" method="post" onsubmit="return validateForm()" >
					<div class="form-group">
						<label  class="form-label">Email address</label> 
						<input type="text" name="email" class="form-control" placeholder="Enter email" required />
					</div>
					<div class="form-group">
						<label  class="form-label">Name</label> 
						<input type="text" name="name"  class="form-control" placeholder="Enter Name" required/>
					</div>
					<div class="form-group">
						<label  class="form-label">Password</label> 
						<input type="password" name="password"  class="form-control" placeholder="Password" required/>
					</div>
					<div class="form-group">
						<label  class="form-label">Age</label> 
						<input type="number" name="age"  class="form-control" placeholder="Age"  required/>
					</div>
					<div class="form-group">
						<label  class="form-label">Address</label> 
						<input type="text" name="address"  class="form-control" placeholder="Address" required/>
					</div>
					<div class="form-group">
						<label  class="form-label">Phone number</label> 
						<input type="text" name="pnumber"  class="form-control" placeholder="Number" required/>
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