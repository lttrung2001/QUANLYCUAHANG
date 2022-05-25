<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title >CAB Shop</title>
	<base href="${pageContext.servletContext.contextPath }/">  
	<link rel="title icon" href="<c:url value='/resources/my_png/Logo-byOanh.png'/>">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://kit.fontawesome.com/0e7ed669fa.js"></script>	
	<script type="text/javascript" src="<c:url value='/resources/my_js/main_js.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/my_css/DinhDangTask1.css'/>"/>

	<!-- smoothy scroll  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<style>
		span.error-msg {
			display: inline-block;
			margin-top: 8px;
			color: red;
		}
	</style>
</head>
<body>
	<%@include file="/WEB-INF/views/customer/reuse/header.jsp" %>
    <div id="signup-form">
		<button id="close-signup" onclick="closeRegisterForm()">
			<i class="fa-solid fa-xmark"></i>
		</button>
		<form:form action="register.htm" method="post" modelAttribute="account">
			<h1>Register</h1>
			<div class="form-control-signup ">
				<form:input path="username" id="username-signup" type="text" placeholder="Username"/>
				<small ></small>
				<span></span>
			</div>
			<form:errors cssClass="error-msg" path="username"></form:errors>
			<div class="form-control-signup ">
				<form:input path="password" id="password-signup" type="password" placeholder="Password"/>
				<small ></small>
				<span></span>
			</div>
			<form:errors cssClass="error-msg" path="password"></form:errors>
<!-- 			<div class="form-control-signup "> -->
<%-- 				<form:input path="password" id="confirm-password-signup" type="password" placeholder="Confirm password"/> --%>
<!-- 				<small ></small> -->
<!-- 				<span></span> -->
<%-- 				<form:errors path="password"></form:errors> --%>
<!-- 			</div> -->
			<div class="form-control-signup ">
				<form:input path="clientInfo.lastName" id="lastname-signup" type="text" placeholder="Last name"/>
				<small ></small>
				<span></span>
			</div>
			<form:errors cssClass="error-msg" path="clientInfo.lastName"></form:errors>
			<div class="form-control-signup ">
				<form:input path="clientInfo.firstName" id="firstname-signup" type="text" placeholder="First name"/>
				<small ></small>
				<span></span>
			</div>
			<form:errors cssClass="error-msg" path="clientInfo.firstName"></form:errors>
			<div class="form-control-signup ">
				<form:input path="email" id="email-signup" type="email" placeholder="Email"/>
				<small ></small>
				<span></span>
			</div>
			<form:errors cssClass="error-msg" path="email"></form:errors>
			<div class="form-control-signup ">
				<form:input path="clientInfo.phoneNumber" id="phone-signup" type="text" placeholder="Phone number"/>
				<small ></small>
				<span></span>
			</div>
			<form:errors cssClass="error-msg" path="clientInfo.phoneNumber"></form:errors>
			<div class="form-control-signup ">
				<form:input path="clientInfo.address" id="address-signup" type="text" placeholder="Address"/>
				<small ></small>
				<span></span>
			</div>			
			<form:errors cssClass="error-msg	" path="clientInfo.address"></form:errors>
			<button class="loading-login"></button>
			<form:button type="submit" class="btn-submit-signup">Confirm</form:button>
			<div class="signup-link">
				Don't remember your password? <a href="forgot.htm">Help!</a>
			</div>
		</form:form>
	</div>
    <div class="filter-login"></div>
    <%@include file="/WEB-INF/views/customer/reuse/home.jsp" %>
    <script>
	    function closeRegisterForm(){
			document.getElementById('signup-form').style.display="none"
			document.querySelector('.filter-login').style.width="0"
		}
    </script>
</body>
</html>