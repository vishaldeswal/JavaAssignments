<html>
<head>
<style>
#main{
	width:16em;
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
			<td><input type="text" name="username" required></td>
			</tr>
			<tr>
			<td><label>Password*</label></td>
			<td><input type="password" name="password" required></td>
			</tr>
			<tr>
			
			<td><a href="#">Forgotten your password</a></td>
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
