<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>

<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("/");
	}

%>
<jsp:include page="header.jsp"></jsp:include><br>
	
	<div align="center">
		<h3>Edit Book Details</h3>
	</div><br>
	
	<div class="row">
	<div class="col-md-9 offset-md-1">
		<form action="updateBook" method="post">
		<table>
		<tbody>
			<div>
				<label class="col-md-2">Book Id</label>
				
				${book.bookId }
				<input type="hidden" name="bookId" value="${book.bookId }">
			</div>
			<div>
				<label class="col-md-2">Book Name</label>
				<input type="text" name="bookName" value="${book.bookName}" required>
			</div>
			<div>
				<label class="col-md-2">Author</label>
				<select name="author" required>
					<option value="">None</option>
					<c:forEach var="author" items="${author}">
						<option value="${author.authorId}">${author.authorName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label class="col-md-2">Added On</label>
				
				<%
				DateFormat Date = DateFormat.getDateInstance();
				Calendar calender = Calendar.getInstance();
				String currentDate = Date.format(calender.getTime());
				
				out.println(currentDate);
				%>
				
							
			</div><br>
		
		</tbody>
		</table>
		
		<div class="container text-center">
			<button type="submit" class="btn btn-primary btn-md">Submit</button>
			<button type="reset" class="btn btn-danger btn-md">Cancel</button>
		</div>
		
		</form>
	</div>
	</div>
</body>
</html>