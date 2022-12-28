<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
crossorigin="anonymous">
<style type="text/css">
#main{
	width:25em;
	background-color: #ebf1f7;
	margin: auto;
	margin-top: 13%;
	font-size: 23px;
}
#login-header{
	text-align: left;
	background-color: #b4cbe1;
	color: #042861;
	border: 0px #c8e1fa;
	border-top-style: solid;
	border-bottom-style: solid;
	padding-bottom: 2px;
	
}

#login-footer{
	text-align: right;
	margin: 2px;
	background-color: #b4cbe1;
	border: 1px #c8e1fa;
	border-top-style: solid;
	border-bottom-style: solid;
}

</style>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<!-- Login Form -->
<div id="main">
	<form method="post" action="login" >
		<div id="login-header">Login</div>
		<div>
		<table>
			<tr>
			<td><label>Username*</label></td>
			<td><input type="text" name="username" minlength="3" maxlength="20" required></td>
			</tr>
			<tr>
			<td><label>Password*</label></td>
			<td><input type="password" name="password" minlength="3" maxlength="20" required></td>
			</tr>
			<tr>
			
			<td><a href="register">Forgotten your password</a></td>
			</tr>
		</table>
		</div>
		<div id="login-footer">
			<input type="submit" value="Login">
		</div>
	</form>
</div>
</body>
</html>