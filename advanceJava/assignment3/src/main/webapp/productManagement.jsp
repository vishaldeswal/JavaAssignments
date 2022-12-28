<%@page import="java.io.OutputStream"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nagarro.model.Products"%>
<%@page import="com.nagarro.model.AdminDetailsModel"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.Base64"%>

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
	margin-top: 4%;
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

.deleteButton{

width=20px;
height=20px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Page 1</title>
</head>
<body>
 
 	<!-- Header -->
 	<div class="header" style="display: flex; margin 15px; justify-content: space-between;">
 	<div>
 	<h4 align="center">Product Management Tool</h4>
 	</div>
 	<form class="user-details" action="index.jsp">
			<p style="margin-right: 10px; margin-top: 5px;">
				<%
				
				AdminDetailsModel user = (AdminDetailsModel) session.getAttribute("user"); 
				%>
				Hi 
				<%=user.getAdminUserName()%></p>
			<button class="button" type="submit">Logout</button>
		</form>
	</div>
 
 	
 	<!-- Add Details Form -->
 	<div class="container">
 	<form action="AddProduct" method="post" enctype="multipart/form-data">
	 	<h6>Please Enter Product details to add to stocks</h6><br>
	 	
	 	<table class="tablee">
				<tr>
					<td class="form-feilds">Title</td>
					<td class="form-input"><input class="form-input" type="text" id="Title" name="title" 
						required></td>
				</tr>
				<tr>
					<td class="form-feilds">Quantity</td>
					<td><input class="form-input" type="number" min="1" id="Quantity"
						name="quantity"  required></td>
				</tr>
				<tr>
					<td class="form-feilds">Size</td>
					<td><input class="form-input" type="text" id="Size" name="size"   required></td>
				</tr>
				<tr>
					<td class="form-feilds">Image</td>
					<td><input type="file" class="form-input" id="Image" name="image" 
						required></td>
					
				</tr>
				
			</table><br>
			<input type="submit" name="add" value="Add Details">
			<input type="button" name="clear" value="Clear" onclick="clearForm()">
			
	
 	</form>
 	</div>
 	
 	<%!List<Products> products = null;%>



	<!-- dynamic Showing Data -->
		<table class="item-table">
			<tr>
				<td class='items'>S.No</td>
				<td class='items'>Title</td>
				<td class='items'>Quantity</td>
				<td class='items'>Size</td>
				<td class='items'>Image</td>
				<td class='items'>Actions</td>
			</tr>
			<%
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Products.class).addAnnotatedClass(AdminDetailsModel.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			Session hiberanteSession = sessionFactory.openSession();
			
			
			Query<Products> query = hiberanteSession.createQuery("from Products where user_adminUserName = :username",Products.class);
			query.setParameter("username", user.getAdminUserName());
			products = query.list();
			
			
			
			for (int i = 0; i < products.size(); i++) {
				out.println("<tr>");
				Products product = products.get(i);
				
				
				
				String imageEncodedBytes = Base64.getEncoder().encodeToString(product.getProductImage());
				
				out.println("<td class='items'>" + (i + 1) + "</td>");
				out.println("<td class='items'>" + product.getProductTitle() + "</td>");
				out.println("<td class='items'>" + product.getProductQuantity() + "</td>");
				out.println("<td class='items'>" + product.getProductSize() + "</td>");
				out.println("<td class='items'><img src='data:image/jpg;base64,"+ imageEncodedBytes +"'"+"width='90px' height='120px'/>");
				out.println("</td>");
				out.println("<td class='items items-btn'>");
				out.println("<form action='editPage.jsp' method='post'>");
				out.println("<input type='hidden' name='edit' value='" + product.getProductID() + "'/>");
				out.println("<input type='image' src='./images/pencil.jpeg' width='20' height='20' alt='edit'/>");
				out.println("</form>");
				out.println("<form action='DeleteData' method='post'>");
				out.println("<input type='hidden' name='delete' value='" + product.getProductID() + "'/>");
				out.println("<input type='image' src='./images/cross.jpeg' width='20' height='20'  alt='delete' />");
				out.println("</form>");
			
				out.println("</td>");
				out.println("</tr>");
				
			}
			%>
		</table>
	
	<!-- Footer -->
	<div style="margin-top: 40px" class="footer"></div>
 	
 <script>

function clearForm(){
    console.log("ClearForm");
    var title=document.getElementById("Title");
    if (title.value !="") {
        title.value = "";
    }
	var quantity=document.getElementById("Quantity");
	if (quantity.value !="") {
		quantity.value = "";
    }
	var size= document.getElementById("Size");
	if (size.value !="") {
		size.value = "";
    }
	var image=document.getElementById("Image");
	if (image.value !="") {
		image.value = "";
    }
    
}
</script>	

</body>
</html>

