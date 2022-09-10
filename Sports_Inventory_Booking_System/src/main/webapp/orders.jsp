<%@page import="java.util.*"%>
<%@page import="dto.*"%>
<%@page import="dao.*"%>
<%@page import="service.*"%>
<%
ArrayList<Orders> kart_list = (ArrayList<Orders>)session.getAttribute("order_list");



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
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Order ID</th>
					<th scope="col">Price</th>
					<th scope="col">View Items</th>
					
				</tr>
			</thead>
			<tbody>
				
						<%
				if (kart_list != null) {
					for (Orders c : kart_list) {
				%>
				<tr>
					<td><%=c.getInvoiceId()%></td>
					<td><%=c.getPrice() %></td>
				
					<td><a href="UserProcessor?action=viewDetails&id=<%=c.getInvoiceId() %>" class="btn btn-sm btn-danger">View</a></td>
				</tr>

				<%
				}}%>
				
			</tbody>
		</table>
	</div>



<%@include file="includes/footer.jsp"%>
</body>
</html>