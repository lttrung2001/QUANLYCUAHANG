<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title >CAB Shop</title>
	<link rel="title icon" href="/resources/my_png/Logo-byOanh.png">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>	
	<script type="text/javascript" src="/resources/my_js/main_js.js" ></script>
	<link rel="stylesheet" type="text/css" href="/resources/my_css/DinhDangTask1.css"/>

	<!-- smoothy scroll  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	
	<!--  -->
</head>


<body>
	<%@include file="/WEB-INF/views/customer/reuse/header.jsp" %>
	
	<!-- Scroll TOP -->
	<a href="#home" class="scrollBackTop">
		<ion-icon name="arrow-up-outline"></ion-icon>
		<span>TOP</span>
	</a>
	<!-- End Scroll TOP -->

	<!-- Login and Sign up -->
	<div id="login-form">
		<buttton id="close-login">
			<span><i class="fa-solid fa-xmark"></i></span>
		</buttton>
		<img class="avtLogin" src="/resources/my_png/avatar.png" >
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
	<!-- Sign up -->
	<div id="signup-form">
		<buttton id="close-signup" >
			<span><i class="fa-solid fa-xmark"></i></span>
		</buttton>
		<form action="">
			<h1>Register</h1>
			<div class="form-control-signup ">
				<input id="username-signup" type="text" placeholder="Username">
				<small ></small>
				<span></span>
			</div>
			<div class="form-control-signup ">
				<input id="email-signup" type="email" placeholder="Email">
				<small ></small>
				<span></span>
			</div>
			<div class="form-control-signup ">
				<input id="password-signup" type="password" placeholder="Password">
				<small ></small>
				<span></span>
			</div>
			<div class="form-control-signup ">
				<input id="confirm-password-signup" type="password" placeholder="Confirm password">
				<small ></small>
				<span></span>
			</div>
			<button class="loading-login"></button >
			<button type="submit" class="btn-submit-signup">Confirm</button>
			<div class="signup-link">
				Don't remember your password? <a href="#">Help!</a>
			</div>
		</form>
	</div>
	<!-- End sign up -->
	
	<!-- End Log -->

	<article id="quangcao">
		<aside><a href="#" target="_blank">Book quảng cáo em đi mọi người</a></aside>
	</article>
	<!--  -->

	<%@include file="/WEB-INF/views/customer/home.jsp" %>
	
	<%@include file="/WEB-INF/views/customer/reuse/footer.jsp" %>

<script type="text/javascript" src="/resources/my_js/main_js.js" ></script>
</body>
</html>	