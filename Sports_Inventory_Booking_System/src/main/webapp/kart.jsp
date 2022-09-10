<%@page import="java.util.*"%>
<%@page import="dto.*"%>
<%@page import="dao.*"%>
<%@page import="service.*"%>
<%
ArrayList<Kart> kart_list = (ArrayList<Kart>)session.getAttribute("kart_list");



%>


<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp"%>
<title>Home</title>

<style type="text/css">

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body >
<%@include file="includes/navbar.jsp"%>
<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> 
		<a class="mx-3 btn btn-primary" href="UserProcessor?action=checkout">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				
						<%
				if (kart_list != null) {
					for (Kart c : kart_list) {
				%>
				<tr>
					<td><%=c.getItemName()%></td>
					<td><%=c.getPriceKart() %></td>
					<td>
					<form action="UserProcessor" method="get" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getItemId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn btn-sm btn-decre" href="UserProcessor?action=dec&id=<%=c.getItemId()%>"><i class="fas fa-minus-square"></i></a>
							
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuaKart()%>" readonly>
								<a class="btn bnt-sm btn-incre" href="UserProcessor?action=inc&id=<%=c.getItemId()%>"><i class="fas fa-plus-square"></i></a> 
								 
							</div>
							<button type="submit" class="btn btn-primary btn-sm"  name="action" value="buyfromkart">Buy</button>
						</form>
					</td>
					<td><a href="UserProcessor?action=removeItem&id=<%=c.getItemId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
				
			</tbody>
		</table>
	</div>



<%@include file="includes/footer.jsp"%>
</body>
</html>