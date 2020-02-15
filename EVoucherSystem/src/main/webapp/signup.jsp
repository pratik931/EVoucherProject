<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EVoucher Gift System</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
	<div class="jumbotron text-center">
		  <h1>Welcome to EVoucher Gift System!</h1>
	</div>

	<div class="container" align="center">
	
		<div class="row">
			<div class="col-lg-12">
				<h1>Please fill the form to Sign Up</h1><br>
			</div>
		</div>
		<form action="signup" method="post">
		<div class="row">
			<div class="col-lg-12">
				<input class="form-control" name="userName" placeholder="Username" style="width:20%" required></input> 	<h5 style="color:red">${userExists} </h5>
			</div>
		</div><br>
		
		
		<div class="row">
			<div class="col-lg-12">
				<input class="form-control" type="password" name="userPwd" placeholder="Password" style="width:20%" required></input> 
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-lg-12">
				<input class="form-control" name="userMobileNumber" placeholder="10 digit Mobile Number" pattern="[789][0-9]{9}" style="width:20%" required></input> 
			</div>
		</div><br>
		<div class="row">
			<div class="col-lg-12">
				<input class= "btn btn-primary"  type="submit" name="submit" value="Sign Up" style="width:20%"></input> 
			</div>
		</div>
		</form>
		
		
	</div>
</body>
</html>