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
<style>
#head{
	margin-top: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<style>
.action-btn{
display: inline;
}

</style>
</head>
<body>

<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("/");
	}
%>

<jsp:include page="header.jsp"></jsp:include><br>
	
	
	
	<div class="row" id="head">
		<div align="center" class="col-10">
			<h3>Book Listing</h3>
		</div>
		<div  class="col-2">

			<form class="user-details" action="addBookPage">

				<button class="button" type="submit">Add Book</button>
			</form>
		</div>
	</div><br><br>
	<div >
	<table width="90%" class="table">
	  <thead>
	    <tr>
	      <th scope="col">Book code</th>
	      <th scope="col">Book name</th>
	      <th scope="col">Author</th>
	      <th scope="col">Date Added</th>
	      <th scope="col" width="250px" align="center">Actions</th>
	    </tr>
	  </thead>
	  <tbody>
	    
	    <c:forEach items="${book}" var="book">
	    <tr>
	      <th scope="row">${book.bookId }</th>
	      <td>${book.bookName }</td>
	      <td>${book.author.authorName }</td>
	      <td>${book.date }</td>
	      <td>
	      	<form action="editBookPage" class="action-btn">
	      	<button type="submit" name="edit" value="${book.bookId}" class="btn btn-outline-secondary mx-0">Edit</button>
	      	</form>
	      	<form action="deleteBook" class="action-btn" >
	      	<button type="submit" name="delete" value="${book.bookId}" class="btn btn-outline-secondary mx-0">Delete</button>
	      	</form>
	      </td>
	    </tr>
	    </c:forEach>
	    
	  </tbody>
	</table>
	</div>
	
</body>
</html>