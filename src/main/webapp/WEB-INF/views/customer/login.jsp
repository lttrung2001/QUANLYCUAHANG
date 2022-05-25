<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://kit.fontawesome.com/0e7ed669fa.js"></script>	
	<script type="text/javascript" src="<c:url value='/resources/my_js/main_js.js'/>" ></script>
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
    <div id="login-form">
		<button id="close-login" >
			<i class="fa-solid fa-xmark" onclick="closeLoginForm()"></i>
		</button>
		<img class="avtLogin" src="<c:url value='/resources/my_png/avatar.png'/>" >
		<h1>LOGIN</h1>
		<form:form method="post" action="login.htm" modelAttribute="account">
			<p>Username</p>
			<form:input path="username" type="text" value="" id="username-login" placeholder="Enter Username" />
			<form:errors cssClass="error-msg" path="username"></form:errors>
			<p>Password</p>
			<form:input path="password" type="password" value="" id="password-login" placeholder="Enter Password" />
			<form:errors cssClass="error-msg" path="password"></form:errors>
			<div class="login-button"><button style="width: 100%; height: 100%; color: #fff;">Login</button></div>
		</form:form>
		<a href="forgot.htm">Lost your password?</a>
		<a href="register.htm">Don't have an account?</a>
		
	</div>
    <div class="filter-login"></div>
    <%@include file="/WEB-INF/views/customer/reuse/home.jsp" %>
    <script>
	    function closeLoginForm(){
			document.getElementById('login-form').style.display="none"
			document.querySelector('.filter-login').style.width="0"
		}
    </script>
    
</body>
</html>