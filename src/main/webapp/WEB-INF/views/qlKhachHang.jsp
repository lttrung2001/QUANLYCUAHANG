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
<h1>THONG TIN KHACH HANG</h1>
<c:forEach var="client" items="${clients }">
	<p>Ho tên khách hàng: ${client.lastName } ${client.firstName }  </p>
	<h3>id: ${client.id }</h3>
	<p>address : ${client.address }</p>
	<p>SDT: ${client.phoneNumber }</p>
	<p>email: ${client.email }</p>
</c:forEach>
</body>
</html>