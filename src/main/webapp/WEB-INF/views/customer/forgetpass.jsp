<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title >CAB Shop</title>
	<link rel="title icon" href="<c:url value='my_png/Logo-byOanh.png'/>">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://kit.fontawesome.com/0e7ed669fa.js"></script>	
	<script type="text/javascript" src="<c:url value='/resources/my_js/main_js.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/my_css/DinhDangTask1.css'/>"/>

	<!-- smoothy scroll  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/customer/reuse/header.jsp" %>	
	 <div class="forgotPassword">
        <h1>Forgot password</h1>    
        <div>
			<input type="text" placeholder="Enter username">
		</div>		
        <div>
			<input type="text" placeholder="Enter new email">
		</div>
        <div class="codeCheckPass">
            <input type="text" placeholder="Enter your code">

        </div>
        <small>Enter all information above to continue</small>
        <br/>
        <button>Continue</button>
    </div>
	<div class="filter-login"></div>
    <script type="text/javascript" src="<c:url value='/resources/my_js/main_js.js'/>"></script>
</body>
</html>