<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      	<h2 style="color: red">
		<b><i>SIGNUP PAGE</i></b>
	</h2>
	<div class="container">
	<%@include file="alert.jsp"%>
		<form method="post" action="AddUser">
			
			<div class="form-group col-sm-10">
				<label for="usernme">Username:</label> <input type="text"
					placeholder="Enter username" class="form-control" id="username"
					name="username" required>
			</div>
			<div class="form-group col-sm-10">
				<label for="password">Password:</label> <input type="password"
					placeholder="Enter password" class="form-control" id="password"
					name="password" required>
				
			</div>
			    
				<div class="form-group col-sm-10">
				<button type="submit" class="btn btn-primary center-block">Register</button>
			</div>
		</form>
		<br>
			<br><input type="button" name="back" value="Back" onclick="history.back()">
	</div>
     
</body>
</html>