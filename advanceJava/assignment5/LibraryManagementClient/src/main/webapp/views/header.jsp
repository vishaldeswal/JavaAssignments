<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>header</title>
</head>
<body>


	<div class="row" id="head">
		<div align="center" class="col-9">
			<h2>Libraray Management Application</h2>
		</div>
		<div align="right" class="col-3">

			<form class="user-details" action="logout-btn">

				<span style="margin-right: 10px; margin-top: 5px;"> Hi
					${username} </span>
				<button class="button" type="submit">Logout</button>
			</form>
		</div>
	</div>
</body>
</html>