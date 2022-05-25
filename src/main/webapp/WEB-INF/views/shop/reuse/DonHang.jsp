<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<base href="${pageContext.servletContext.contextPath }/">
<div class="mainOrder">
	<div class="orderBoxs">
		<div class="orderList">
			<div class="searchBoxOrderList">
				<form:form action = "admin/donhang/index.htm">  
					<input name="searchInput" type="text" placeholder="Mã đơn hàng">
					<button name="btnsearch" type="submit">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
			 	 	 </form:form>    
			</div>
			<table>
				<thead>
					<tr>
						<td>Mã đơn hàng</td>
						<td>NV xác nhận</td>
						<td>Thời gian tạo đơn</td>
						<td>Địa chỉ</td>
						<td>Trạng thái</td>
					</tr>
				</thead>
				<tbody>
				  
					<c:forEach var="bill" items="${Bill}">
						<tr>
							<td>${bill.id}</td>
							<td>${bill.staffCreate }</td>
							<td>${bill.createDate}</td>
							<td>${bill.address}</td>
							<c:set var="status" scope="session" value="${bill.status}" />
							<td><c:choose>
									<c:when test="${status == 78}">
										<a href="admin/donhang/index/${bill.id}.htm?btnConfirm">
											<button name ="btnConfirm" type = "submit">Xác nhận</button>
										</a>
											

									</c:when>
									<c:when test="${status == 89 ||status == 72}">

										<a href="admin/donhang/index/${bill.id}.htm?btnView">
											<button name ="btnView" type = "submit">Xem</button>
										</a>
											
									</c:when>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="detailOrder">
			<img src='<c:url value="/resources/my_png/WriteText.png"/>'>
			<h3>CHI TIẾT HÓA ĐƠN</h3>
			<div class="boxDetailOrder">
				<div style=" color: #e0412c;
                            font-size: 14px;
                            font-weight: bold;">
                    ${message }
                </div>
				<div class="name-order">			
					Tên khách hàng:
					<p>${b.customerAcc.clientInfo.lastName } ${b.customerAcc.clientInfo.firstName }</p>
				</div>
				<div class="phone-order">
					Số điện thoại:
					<p>${b.customerAcc.clientInfo.phoneNumber }</p>
				</div>
				<div class="address-order">
					Địa chỉ:
					<p>${b.customerAcc.clientInfo.address }</p>
				</div>
				<div class="products-order">
					Chi tiết:
					<ul>
						<c:set var="total" value="${0 }"></c:set>
						<c:forEach var="bd" items="${b.billDetails }">
						<li><span>${bd.productInBill.name }</span> <span>${bd.productInBill.price }$</span> <span>x${bd.amount }</span></li>
						<c:set var="total" value="${total + bd.productInBill.price*bd.amount }"></c:set>
						</c:forEach>
					</ul>
				</div>
				<div class="totalPrice-order">
					Tổng:
					<p style="display: inline;">${total }</p>
				</div>
				<div class="sale-order">
					Giảm :
					<p style="display: inline;">0</p>
				</div>
				<div class="finalPrice-order">
					Thành tiền:
					<p style="text-align: end; display: inline;">${total }</p>
				</div>
			</div>
			<div class="statusDetailOrder">
				<h3>Tình trạng đơn</h3>
				<div class="boxStatusOrder">
					<i class="fa-solid fa-check"></i> <i class="fa-solid fa-truck-fast"></i>
				</div>
			</div>
		</div>
	</div>
</div>