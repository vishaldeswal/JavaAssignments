<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
.user-details {
	display: flex;
	justify-content: space-evenly;
	align-content: right;
}
.table-view{
	padding-left: 5px;
	margin-left: 15px;
}
#head{
	margin-top: 15px;
}

</style>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Seached Result</title>
</head>
<body>
<!-- Header of the page  -->
	<div class="row" id="head">
		<div align="center" class = "col-10">
			<h3>Searched Tshirts</h3>
		</div>
		<div class ="col-2">
		
		<form class="user-details" action="logout-btn">
		
			<span style="margin-right: 10px; margin-top: 5px;">
				
				Hi
				${username} </span>
			<button class="button" type="submit">Logout</button>
		</form>
				
		</div>
	</div><br><br><br>

	
	<table class="table table-view">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Color</th>
				<th scope="col">Gender</th>
				<th scope="col">Size</th>
				<th scope="col">price</th>
				<th scope="col">Rating</th>
				<th scope="col">Availability</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${product}" var="p">
		
			<tr>
				<th scope="row">${p.iD}</th>
				<td>${p.name}</td>
				<td>${p.color }</td>
				<td>${p.genderRecommendation}</td>
				<td>${p.size}</td>
				<td>${p.price}</td>
				<td>${p.rating}</td>
				<td>${p.tshirtAvailability}</td>
			</tr>
			
		
		</c:forEach>

		</tbody>
	</table>
	
	
	<div class="container text-center">
	<form action="search-btn">
		<input type="submit" class="btn btn-outline-success" value="Search T-Shirt">
	</form>
	</div>
</body>
</html>