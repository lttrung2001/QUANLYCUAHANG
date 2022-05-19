<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<base href="${pageContext.servletContext.contextPath }/">
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title >CAB Shop</title>
	<link rel="title icon" href="<c:url value='/resources/my_png/Logo-byOanh.png'/>">
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
	
	<!-- Sign up -->
	
	<!-- End sign up -->
	
	<!-- End Log -->

	<article id="quangcao">
		<aside><a href="#" target="_blank">Book quảng cáo em đi mọi người</a></aside>
	</article>
	<!--  -->

	<%@include file="/WEB-INF/views/customer/reuse/home.jsp" %>
	
	<%@include file="/WEB-INF/views/customer/reuse/footer.jsp" %>

<script type="text/javascript" src="/resources/my_js/main_js.js" ></script>
<script type="text/javascript">
	
	function test(e) {
		var parent = $(e).parent();
		var id = $($(parent).find('figure > .id-item')).text();
		$.ajax({
			url : "/QUANLYCUAHANG/AddProductIntoCart",
			type : "get",
			data : {
				productId : id
			},
			success : function(data) {
				alert('Đã thêm vào giỏ hàng!');				
			},
			error : function(xhr) {
				alert("Sản phẩm này đã có trong giỏ hàng của bạn!");
			}
		});
	}
</script>
</body>
</html>	