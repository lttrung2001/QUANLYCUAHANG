<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHI TIẾT ĐƠN HÀNG</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<base href="${pageContext.servletContext.contextPath }/">
</head>
<body>
<h1 class="card-title">CHI TIẾT ĐƠN HÀNG</h1>
<a href="home.htm" type="button" class="btn btn-secondary btn-lg">Quay về trang chủ</a>
<a href="account/history.htm" type="button" class="btn btn-outline-dark btn-lg">Lùi lại</a>
	<h2 class="card-title">Mã hóa đơn: ${bill.id }</h2>
	<c:set var="total" value="${0 }"></c:set>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Mã sản phẩm</th>
				<th scope="col">Tên sản phẩm</th>
				<th scope="col">Số lượng</th>
				<th scope="col">Đơn giá</th>
				<th scope="col">Tổng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach varStatus="i" var="bd" items="${bill.billDetails }">
				<tr>
					<th scope="row">${i.index+1 }</th>
					<td>${bd.productInBill.id }</td>
					<td>${bd.productInBill.name }</td>
					<td>${bd.amount }</td>
					<td><fmt:formatNumber currencyCode="VND" currencySymbol="đ" value="${bd.productInBill.price }" minFractionDigits="0"></fmt:formatNumber></td>
					<td><fmt:formatNumber currencyCode="VND" currencySymbol="đ" value="${bd.amount*bd.productInBill.price }" minFractionDigits="0"></fmt:formatNumber></td>
				</tr>
				<c:set var="total" value="${total + bd.amount*bd.productInBill.price }"></c:set>
			</c:forEach>
		</tbody>
	</table>
	<h3 class="card-title">Thành tiền: 
	<fmt:formatNumber currencyCode="VND" currencySymbol="đ" value="${total }" minFractionDigits="0"></fmt:formatNumber>
	</h3>
</body>
</html>