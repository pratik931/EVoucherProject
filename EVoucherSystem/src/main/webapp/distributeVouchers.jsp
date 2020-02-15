<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="jumbotron text-center">
		  <h1>Distribute Vouchers</h1>
	</div>
	<form action = "distributeVouchersToConsumers">
		<div class="container">
		<div class="row">
			<div class="col-lg-4" align="right">
				<h4>Enter the consumer's mobile number: </h4>
			</div>
			<div class="col-lg-4" align="center">
					<input class="form-control" name="userMobileNumber" placeholder="10 digit Mobile Number" pattern="[789][0-9]{9}" style="width:100%" required />
			</div>
			<div class="col-lg-4" align="left">
				<input class="btn btn-primary"  type="submit" name="distribute" value="Distribute" style="width:50%"><br><br>
			</div>
		</div>
		</div>
		<div class="container">
			<table class="table">
			<h4>Select vouchers from this list: </h4>
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">id</th>
						<th scope="col">Voucher Code</th>
						<th scope="col">Start Date</th>
						<th scope="col">End Date</th>
						<th scope="col">Amount</th>
						<th scope="col">Is Valid</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items ="${allVouchers}" var="voucher">
					<tr>
						<td><input type="checkbox" name="selectedVouchers" value="${voucher.getVoucherID()}"></td>
						<th><c:out value="${voucher.getVoucherID()}" /></th>
						<td><c:out value="${voucher.getVoucherCode()}" /></td>
						<td><c:out value="${voucher.getVoucherStartDate()}" /></td>
						<td><c:out value="${voucher.getVoucherEndDate()}" /></td>
						<td><c:out value="${voucher.getVoucherAmount()}" /></td>
						<td><c:out value="${voucher.getRedeemFlag()}" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>