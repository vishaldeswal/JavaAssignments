<%@page import="com.nagarro.model.AdminDetailsModel"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page
	import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.query.Query"%>

<%@page import="com.nagarro.model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.header {
	display: flex;
	margin: 15px;
	justify-content: space-between;
}

.items-btn, .user-details {
	display: flex;
	justify-content: space-evenly;
}

.button {
	padding-left: 5px;
	padding-right: 5px;
}

* {
	margin: 0px;
	padding: 0px;
}

.details {
	margin-left: 10px;
}

.item-table {
	width: 90%;
	text-align: center;
	margin-top: 8%;
	margin-left: 4%;
	margin-right: 4%;
}

.item-table, td.items {
	border: 1px solid black;
	border-collapse: collapse;
}

.items {
	padding: 5px;
}

.form-input {
	margin: 5px;
}

.deleteButton {width =20px;height =20px;
	
}
</style>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<title>Product Details Edit</title>
</head>
<body>
	<!-- Header of the page  -->
	<div class="header">
		<div align="center">
			<h4 text-align="center">Product Management Tool</h4>
		</div>
		<form class="user-details" action="index.jsp">
			<p style="margin-right: 10px; margin-top: 5px;">
				<%
					session.setAttribute("productID", request.getParameter("edit"));
					AdminDetailsModel user = (AdminDetailsModel) session.getAttribute("user");
				%>
				Hi
				<%=user.getAdminUserName()%></p>
			<button class="button" type="submit">Logout</button>
		</form>
	</div>





	<!-- Form to edit details -->
	<div class="container">
		<form action="EditData" method="post" enctype="multipart/form-data">
			<h6>Please Enter Product details to be edited to stocks</h6>
			<br>

			<table class="tablee">
				<tr>
					<td class="form-feilds">Title</td>
					<td><input class="form-input" type="text" id="Title"
						name="editedtitle" ></td>
				</tr>
				<tr>
					<td class="form-feilds">Quantity</td>
					<td><input class="form-input" type="number" min="1"
						id="Quantity" name="editedquantity"
						></td>
				</tr>
				<tr>
					<td class="form-feilds">Size</td>
					<td><input class="form-input" type="text" id="Size"
						name="editedsize"></td>
				</tr>
				<tr>
					<td class="form-feilds">Image</td>
					<td><input type="file" class="form-input" id="Image"
						name="editedimage"></td>
				</tr>

			</table>
			<br> <input type="submit" name="add" value="Edit Details">
			<input type="button" name="clear" value="Clear" onclick="clearForm()">
			<br>
			<br><input type="button" name="back" value="Back" onclick="history.back()">


		</form>
	</div>
	<script>
		function clearForm() {
			console.log("ClearForm");
			var title = document.getElementById("Title");
			if (title.value != "") {
				title.value = "";
			}
			var quantity = document.getElementById("Quantity");
			if (quantity.value != "") {
				quantity.value = "";
			}
			var size = document.getElementById("Size");
			if (size.value != "") {
				size.value = "";
			}
			var image = document.getElementById("Image");
			if (image.value != "") {
				image.value = "";
			}

		}
	</script>
</body>
</html>