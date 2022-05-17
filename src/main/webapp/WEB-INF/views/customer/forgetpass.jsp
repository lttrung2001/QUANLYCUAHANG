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
	 <div class="forgotPassword">
        <h1>QUÊN MẬT KHẨU</h1>    
        <div>
			<input type="text" placeholder="Nhập tên tài khoản">
		</div>		
        <div>
			<input type="text" placeholder="Nhập email đăng ký">
		</div>
        <div class="codeCheckPass">
            <input type="text" placeholder="Nhập code">

        </div>
        <small>Nhập đúng thông tin sau đó nhấn tiếp tục</small>
        <br/>
        <button>TIẾP TỤC</button>
    </div>
	<div class="filter-login"></div>
    <script type="text/javascript" src="my_js/main_js.js" ></script>
</body>
</html>