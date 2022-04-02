<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test 2</title>
</head>
<body>
<h1>Danh sach don hang do nhan vien 106 xac nhan</h1>

<c:forEach var="bill" items="${trung.createdBills }">
	<h3>Ma hoa don: ${bill.id }</h3>
	<p>Ngay tao: ${bill.createDate }</p>
	<p>Nhan vien xac nhan: ${bill.staffCreate.lastName } ${bill.staffCreate.firstName }  </p>
	<p>Trang thai: ${bill.status }</p>
	<p>Dia chi giao hang: ${bill.address }</p>
	<ul>
	<c:forEach var="detail" items="${bill.billDetails }">
		<li>Ten san pham: ${detail.productInBill.name }_So luong: ${detail.amount }_Gia: ${detail.productInBill.price }</li>
	</c:forEach>
	</ul>
</c:forEach>
</body>
</html>