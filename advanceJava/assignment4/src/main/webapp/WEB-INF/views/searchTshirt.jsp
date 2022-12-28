<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style>
#head{
	margin-top: 15px;
}


</style>
<title>Search Tshirt Here</title>
</head>
<body>
<!-- Header of the page  -->
	<div class="row" id="head">
		<div align="center" class = "col-10">
			<h3>Search the T-shirt with these parameters</h3>
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


<div class="container">
	

	
	<div class="row">
	<div class="col-md-9 offset-md-1">
	<form action="searchTshirt" method="post">
		<div>
		<label class="col-md-2">Color</label>
		<input type="text" name="color">
		</div><br>
		
		<div>
		<label for="size" class="col-md-2">Size</label>
		<select name="size" required>
			<option value="S">S</option>
			<option value="M">M</option>
			<option value="L">L</option>
			<option value="XL">XL</option>
			<option value="XXl">XXL</option>
		</select>
		</div><br>
		
		<div>
		<label for="genderRecommendation" class="col-md-2">Gender</label>
		<select name="genderRecommendation" required>			
			<option value="M">Male</option>
			<option value="F">Female</option>
		</select>
		</div><br>
		
		<div>
		<label for="outputPreference" class="col-md-2">Output Preference</label>
		<select name="outputPreference" required>			
			<option value="rating">Rating</option>
			<option value="price">Price</option>
			<option value="both">By Both(Price and Rating)</option>
		</select>
		</div><br>
		
		<div class="container text-center"><input class="btn btn-outline-success" type="submit" name="search" value= "Search"></div>
	
	</form>
	
	</div>
	</div>
	
</div>

</body>
</html>