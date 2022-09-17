<%@page import="java.util.*"%>
<%@page import="dto.*"%>
<%@page import="dao.*"%>
<%@page import="service.*"%>
<%
ArrayList<Orders> kart_list = (ArrayList<Orders>)session.getAttribute("order_list");
ArrayList<Kart> kart_list1 = (ArrayList<Kart>)session.getAttribute("viewDetails");


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
<%@include file="includes/adminnav.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container">
		<div class="card-header my-3">
		
		  <ul class="navbar-nav ml-auto">
      <li class="nav-item active"> <a class="nav-link" href="adminorders.jsp">Active Orders </a> </li>
      <li class="nav-item"> <a class="nav-link" href="approvedOrd.jsp">Approved Orders</a> </li>
      

      
      
      
    
    </ul>
		</div>
		</div>
</nav>
<div class="container my-3">
<div class="row">
<div class="col-sm-6">
<form action="AdminProcessor">
<input type="submit" name="action" value="approve">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Order ID</th>
					<th scope="col">Price</th>
					<th scope="col">UserId</th>
					<th scope="col">View</th>
					<th scope="col">   </th>
					
					
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
					<td><%=c.getEmail() %></td>
							<td><a href="AdminProcessor?action=viewOrder&Id=<%=c.getInvoiceId()%>" class="btn btn-sm ">View</a></td>
			
					<td><input type="checkbox" name="approval" value="<%=c.getInvoiceId() %>"></td>
					
				</tr>

				<%
				}}%>
				
			</tbody>
		</table>
		</form>
		</div>
		
		<div class="col-sm">
		
		<table class="table table-light">
			<thead>
				<tr>
				<th scope="col">Item Id</th>
					<th scope="col">Item Name</th>
					
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					
				</tr>
			</thead>
			<tbody>
				
						<%
				if (kart_list1 != null) {
					for (Kart k : kart_list1) {
				%>
				<tr>
				<td><%=k.getItemId()%></td>
					<td><%=k.getItemName()%></td>
					<td><%=k.getQuaKart() %></td>
				
				<td><%=k.getPriceKart()*k.getQuaKart() %></td>
				</tr>

				<%
				}}%>
				
			</tbody>
		</div>
		</div>
	</div>



<%@include file="includes/footer.jsp"%>
</body>
</html>