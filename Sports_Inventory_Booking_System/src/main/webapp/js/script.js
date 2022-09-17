function validateForm()
{
	var email=document.getElementById("email").value;
	var name=document.getElementById("name").value;
	var pass=document.getElementById("password").value;
	var age=document.getElementById("age").value;
	var add=document.getElementById("address").value;
	var number=document.getElementById("number").value;
	var regEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g; //Javascript reGex for Email Validation.
	var regPhone=/^\d{10}$/;									 // Javascript reGex for Phone Number validation.
	var regName = /\d+$/g;
	
		if (email == "" || !regEmail.test(email)) {
					window.alert("Please enter a valid e-mail address.");
					email.focus();
					return false;
				}
	if (name == "" || regName.test(name)) {
					window.alert("Please enter your name properly.");
					name.focus();
					return false;
				}
				
				if (pass == "") {
					alert("Please enter your password");
					password.focus();
					return false;
				}
				if(pass.length <6){
					alert("Password should be atleast 6 character long");
					password.focus();
					return false;

				}
				
				if (age == "") {
					window.alert("Please enter your address.");
					address.focus();
					return false;
				}
				if (add == "") {
					window.alert("Please enter your address.");
					address.focus();
					return false;
				}
				if (number == "" || !regPhone.test(number)) {
					alert("Please enter valid phone number.");
					phone.focus();
					return false;
				}
	return true;
}