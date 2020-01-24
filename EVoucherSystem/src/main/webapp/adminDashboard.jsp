<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="jumbotron text-center">
		  <h1>Admin's Dashboard</h1>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12" align="center">
				<h2>What action would you like to do?</h2>
			</div><br><br><br>
		</div>
		<div class="row">
			<div class="col-lg-6" align="Right">
				<form action = "generateVouchers">
					<input class="btn btn-primary"  type="submit" name="submit" value="Generate New Vouchers" style="width:50%" onClick="showVoucherGenerationMessage()">
				</form>
			</div>
			<div class="col-lg-6" align="Left">
				<form action = "showVouchers">
					<input class="btn btn-primary"  type="submit" name="submit" value="Show Valid Vouchers" style="width:50%" >
				</form>
			</div>
		</div>
		
		<div class = "Row" id = "voucherGenerationMessage" style="display:none">
			<div class="col-lg-12" align="center">
				<h3>${vouchers} generated successfully.</h3>
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
		function showVoucherGenerationMessage(){
			document.getElementById('voucherGenerationMessage').style.display = "block";
		}
	</script>
</body>
</html>