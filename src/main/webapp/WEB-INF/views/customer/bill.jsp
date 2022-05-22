<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<base href="${pageContext.servletContext.contextPath }/">
</head>
<body>
	<h1 class="card-title">DANH SÁCH ĐƠN HÀNG ĐÃ ĐẶT</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Mã hóa đơn</th>
				<th scope="col">Ngày tạo</th>
				<th scope="col">Trạng thái</th>
				<th scope="col">Địa chỉ giao hàng</th>
				<th scope="col">Người duyệt</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach varStatus="i" var="b" items="${bills }">
				<tr>
					<th scope="row">${i.index+1 }</th>
					<td>${b.id }</td>
					<td>${b.createDate }</td>
					<td>
					<c:if test="${b.status eq 'Y'.charAt(0) }">Đã duyệt</c:if>
					<c:if test="${b.status eq 'N'.charAt(0) }">Đang chờ</c:if>
					<c:if test="${b.status eq 'H'.charAt(0) }">Đã hủy</c:if>
					</td>
					<td>${b.address }</td>
					<td>${b.staffCreate }</td>
					<td><a type="button" class="btn btn-primary" href="account/bill-detail-${b.id }.htm">Chi tiết</a></td>
					<td>
					<c:if test="${b.status eq 'N'.charAt(0) }"><a type="button" class="btn btn-primary" href="account/bill-${b.id }.htm">Hủy đơn</a></c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>