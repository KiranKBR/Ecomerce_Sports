<%@page import="java.util.*"%>
<%@page import="dto.*"%>
<%@page import="service.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

String mail =(String) request.getSession().getAttribute("user");
if (mail != null) {
    request.setAttribute("auth", mail);
}

userService us = new userService();
ArrayList<Item> products =us.viewAllItems();
Item usr=(Item)session.getAttribute("idc");
%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<%@include file="includes/head.jsp"%>
</head>
<body >
<%@include file="includes/adminnav.jsp"%>
<div class="container my-3">
<div class="row">
<div class="col-sm-6">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col"> Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Modify</th>
					
				</tr>
			</thead>
			<tbody>
				
						<%
				if (products != null) {
					for (Item c : products) {
				%>
				<tr>
					<td><%=c.getItemName()%></td>
					<td><%=c.getRate() %></td>
					<td><%=c.getQuantity() %></td>
					<td><a href="AdminProcessor?action=selectToChange&id=<%=c.getItemId() %>" class="btn btn-sm btn-danger">Modify</a></td>
				</tr>

				<%
				}}%>
				
			</tbody>
		</table>
		</div>
		
		<div class="col-sm">
		
		
		<div class="container">
		<div class="card mx-auto my-5">
			
			<%if(usr!=null){%>
			<div class="card-header text-center">Change Details</div>
			<div class="card-body">
					<form action="AdminProcessor" >
					<div class="form-group">
						<label>ItemId</label> 
						<input type="text" name="id2" class="form-control" value="<%=usr.getItemId()%> ">
					</div>
					<div class="form-group">
						<label>Name</label> 
						<input type="text" name="name" class="form-control" value="<%=usr.getItemName()%> ">
					</div>
					<div class="form-group">
						<label>Brand</label> 
						<input type="text" name="brand" class="form-control" value="<%=usr.getBrand()%>">
					</div>
					<div class="form-group">
						<label>Quantity</label> 
						<input type="number" name="quantity" class="form-control" value="<%=usr.getQuantity()%>">
					</div>
					<div class="form-group">
						<label>Price</label> 
						<input type="number" name="price" class="form-control" value="<%=usr.getRate()%>">
					</div>
					<div class="form-group">
						<label>Category</label> 
						<input type="text" name="category" class="form-control" value="<%=usr.getCategory()%>">
					</div>
					<div class="form-group">
						<label>Sub Category</label> 
						<input type="text" name="subcat" class="form-control" value="<%=usr.getSubCategory()%>">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" name="action" value="changeDetails">Update</button>
					</div>
					<a href="AdminProcessor?action=removeItem&id3=<%=usr.getItemId()%>" class="btn btn-sm btn-danger">Remove</a>
				</form>
				</div>
				<div>
				<% }%> 
				
				<%if(usr==null){%> 
				<div class="card-header text-center">Add Item</div>
			<div class="card-body">
									<form action="AdminProcessor" >
					
					<div class="form-group">
						<label>Name</label> 
						<input type="text" name="name" class="form-control"  ">
					</div>
					<div class="form-group">
						<label>Brand</label> 
						<input type="text" name="brand" class="form-control" >
					</div>
					<div class="form-group">
						<label>Quantity</label> 
						<input type="number" name="quantity" class="form-control" >
					</div>
					<div class="form-group">
						<label>Price</label> 
						<input type="number" name="price" class="form-control" >
					</div>
					<div class="form-group">
						<label>Category</label> 
						<input type="text" name="category" class="form-control" >
					</div>
					<div class="form-group">
						<label>Sub Category</label> 
						<input type="text" name="subcat" class="form-control">
					</div>
										<div class="form-group">
						<label>File</label> 
						<input type="file" name="image" class="form-control">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" name="action" value="addItem">Update</button>
					</div>
				</form>
				
					
			</div>
		</div>
		<% }%> 
	</div>
	
		</div>
		</div>
	</div>




<%@include file="includes/footer.jsp"%>
</body>
</html>