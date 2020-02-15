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
		<h1>Action Message:</h1>
		<h2>Total ${allVouchers.size()} valid vouchers are available.</h2>
		<br> <a href="adminDashboard.jsp">click to go back</a>
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Voucher Code</th>
					<th scope="col">Voucher Start Date</th>
					<th scope="col">Voucher End Date</th>
					<th scope="col">Valid</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items ="${allVouchers}" var="voucher">
				<tr>
					<th><c:out value="${voucher.getVoucherID()}" /></th>
					<td><c:out value="${voucher.getVoucherCode()}" /></td>
					<td><c:out value="${voucher.getVoucherStartDate()}" /></td>
					<td><c:out value="${voucher.getVoucherEndDate()}" /></td>
					<td><c:out value="${voucher.getRedeemFlag()}" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>