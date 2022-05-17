<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title >CAB Shop</title>
	<link rel="title icon" href="my_png/Logo-byOanh.png">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>	
	<script type="text/javascript" src="my_js/main_js.js" ></script>
	<link rel="stylesheet" type="text/css" href="my_css/DinhDangTask1.css"/>

	<!-- smoothy scroll  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/customer/reuse/header.jsp" %>
    <div id="login-form">
		<buttton id="close-login">
			<span><i class="fa-solid fa-xmark"></i></span>
		</buttton>
		<img class="avtLogin" src="my_png/avatar.png" >
		<h1>LOGIN</h1>
		<form action="">
			<p>Username</p>
			<input type="text" value="" id="username-login" placeholder="Enter Username" />
			<p>Password</p>
			<input type="password" value="" id="password-login" placeholder="Enter Password" />
			<div class="error-login">Incorrect account or password</div>
			<div class="warning-login">Not be empty</div>
			<button class="loading-login"></button >
			<div class="login-button"><span>Login</span></div>
		</form>
		<a href="#">Lost your password?</a>
		<a href="#">Don't have an account?</a>
		
	</div>
    <div class="filter-login"></div>
    <script type="text/javascript" src="my_js/main_js.js" ></script>
</body>
</html>