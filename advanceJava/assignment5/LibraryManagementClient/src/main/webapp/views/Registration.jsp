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
		<form method="post" action="addLibrarian">

			<div>
				<table>
					<tr>
						<td><label>Username*</label></td>
						<td><input type="text" name="username" minlength="3"
							maxlength="20" required></td>
					</tr>
					<tr>
						<td><label>Password*</label></td>
						<td><input type="password" name="password" minlength="3"
							maxlength="20" required></td>
					</tr>
					
				</table>
			</div>

			<div class="form-group col-sm-10">
				<button type="submit" class="btn btn-primary center-block">Register</button>
			</div>
		</form>
		<br> <br>
		<input type="button" name="back" value="Back" onclick="history.back()">
	</div>

</body>
</html>