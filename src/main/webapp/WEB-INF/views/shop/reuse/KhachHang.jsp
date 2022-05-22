
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="mainCM">
	<div class="cardInforCM">
			<button>
				<i class="fa-solid fa-circle-xmark"></i>
			</button>
			<div class="imgCardCM">
				<img src="<c:url value='/resources/my_image/PicCats/Meo1.jpg'/>" alt="">
			</div>
			<h3></h3>
			<div class="addressCard">
				<i class="fa-solid fa-location-pin"></i><span></span> 
			</div>
			<div class="phoneCard">
				<i class="fa-solid fa-mobile-screen-button"></i><span></span>
			</div>
			<div class="mailCard">
				<i class="fa-solid fa-envelope"></i><span></span>
			</div>
			<div class="userCard">
				<i class="fa-solid fa-user"></i><span></span>
			</div>
			<div class="passwordCard">
				<i class="fa-solid fa-lock"></i><span></span>
			</div>
			<div class="pointCard">
				<i class="fa-solid fa-star"></i><span></span>
			</div>
	</div>
	<div class="diagramCustomer">
		<h4>SỐ LƯỢNG KHÁCH HÀNG ĐĂNG KÍ QUA CÁC THÁNG</h4>
		<div style="height: 85%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Jan</div>
		</div>
		<div style="height: 76%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Feb</div>
		</div>
		<div style="height: 70%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Mar</div>
		</div>
		<div style="height: 50%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Apr</div>
		</div>
		<div style="height: 40%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">May</div>
		</div>
		<div style="height: 45%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">June</div>
		</div>
		<div style="height: 65%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">July</div>
		</div>
		<div style="height: 70%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Aug</div>
		</div>
		<div style="height: 75%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Sep</div>
		</div>
		<div style="height: 60%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Oct</div>
		</div>
		<div style="height: 40%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Nov</div>
		</div>
		<div style="height: 32%" class="column">
			<div class="heightColumn">
				<span>20</span>
			</div>
			<div class="timeline">Dec</div>
		</div>
	</div>
	<%-- <c:forEach var="c" items="${clients }">
		<h1>${c.lastName } ${c.firstName }</h1>
		<p>${c.id }</p>
		<p>${client.address }</p>
		<p>${client.phoneNumber }</p>
	</c:forEach> --%>
	<!-- <h1>DANH SÃCH KHÃCH HÃNG</h1> -->
	<div class="topTableCustomer">
		<h2>DANH SÁCH KHÁCH HÀNG</h2>
		<div class="searchCustomer">
			<form action="">
				<label for=""> <input type="search" name="searchInput"
					id="searchBox" placeholder="Search here">
					<button name="btnsearch" type="submit" class=""></button>
				</label>
			</form>
		</div>
	</div>

	<div class="listCardCustomer">
		<c:forEach var="client" items="${ clients }">
			<div class="cardCustomer">
				<div class="mainNameCus">
						<img
							src="<c:url value='/resources/my_image/Customer Images/Meo5.jpg'/> ">
						<span class="nameCus">
							<h2>${client.lastName} ${client.firstName }</h2>
							<div>${client.id }</div>
						</span>
					</div>
					<div class="extendInfo">
						<div class="address">
							<i class="fa-solid fa-location-pin"></i> <span>${client.address }</span>
						</div>
						<div class="mail">
							<i class="fa-solid fa-envelope"></i>${client.clientAccount.email }
							<span> <small class="detailMail"></small></span>
						</div>
						<div class="call">
							<i class="fa-solid fa-mobile-button"></i> <span>${client.phoneNumber }</span>
						</div>
						<div class="user">
						</div>
						<div class="pass">
							<span>${client.clientAccount.password }</span>
						</div>
						<div class="point">
							<span>${client.clientAccount.point }</span>
						</div>
					</div>
			</div>
		</c:forEach>
	</div>
</div>