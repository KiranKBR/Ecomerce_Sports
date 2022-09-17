<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <html>
<script type="text/javascript">
	function validateForm() {
		// body...
		var k=document.getElementById('ki').value;
		if(k==0)
			return true;
		return false;
	}
</script>
<body>
	<form action="item.jsp" onsubmit="return validateForm()">
		<input type="number" id="ki" >
		<input type="submit" name="Hi">
	</form>
</body>
</html>