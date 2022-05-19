<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My cart</title>
<base href="${pageContext.servletContext.contextPath }/">
<script src="https://kit.fontawesome.com/0e7ed669fa.js"></script>
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/my_css/CSS-Cart.css'/>">
</head>
<body>
	<c:set var="totalPrice" value="${0}" />
	<div class="shoppingCart">
		<div class="productCart">
			<h2>GIỎ HÀNG:</h2>
			<div class="items">
				<c:forEach var="c" items="${account.products }">
					<div class="item">
						<img src="<c:url value='${c.productInCart.image }'/>">
						<div class="nameItem">
							<div class="typeItem">${c.productInCart.name }</div>
							<div class="detailItem">${c.productInCart.desc }</div>
<!-- 							<div class="sizeItem">Size[L]</div> -->
							<div class="productId" style="display: none;">${c.productInCart.id }</div>
						</div>
						<div class="numberItem">
							<button onclick="minusItem(this);">
								<i class="fa-solid fa-minus"></i>
							</button>
							<small class="productAmount">${c.amount }</small>
							<button onclick="plusItem(this);">
								<i class="fa-solid fa-plus"></i>
							</button>
						</div>
						<div class="price"><fmt:formatNumber value="${c.productInCart.price }" currencySymbol="đ" minFractionDigits="0" type="currency"></fmt:formatNumber> </div>
						<button onclick="deleteProductInCart(this);">
							<i class="fa-solid fa-xmark"></i>
						</button>
					</div>
					<c:set var="totalPrice"
						value="${totalPrice + c.productInCart.price*c.amount}" />
				</c:forEach>
			</div>
			<div class="backShop">
				<a href="#"><ion-icon name="return-up-back-outline"></ion-icon>Back
					to shop</a>
			</div>
		</div>
		<div class="checkout">
			<div class="detailCheckout">
				<div class="cartIcon">
					<img src="/resources/my_png/Logo-byOanh.png" alt="">
				</div>
				<div class="totalItem">
					<h4>ITEMS</h4>
					<span>${fn:length(account.products) }</span> <span
						class="total-price">
						<fmt:formatNumber value="${totalPrice }" currencySymbol="đ" minFractionDigits="0" type="currency"></fmt:formatNumber>
<%-- 						<c:out value="${totalPrice }"></c:out> --%>
						</span>
				</div>
			</div>
			<div class="address">
				<h4>Thêm địa chỉ giao hàng</h4>
				<input class="billAddress" type="text"
					value="${account.clientInfo.address }">
			</div>
			<div class="sale">
				<h4>ĐƯỢC GIẢM:</h4>
				<span><fmt:formatNumber value="${0 }" currencySymbol="đ" minFractionDigits="0" type="currency"></fmt:formatNumber></span>
			</div>
			<div class="totalPrice">
				<h4>THÀNH TIỀN:</h4>
				<fmt:formatNumber value="${totalPrice }" currencySymbol="đ" minFractionDigits="0" type="currency"></fmt:formatNumber>
<%-- 				<span><c:out value="${totalPrice }"></c:out></span> --%>
			</div>
			<button onclick="checkOut();">CHECKOUT</button>

		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		function deleteProductInCart(e) {
			var parent = $(e).parent();
			var id = $($($(parent).children()[1]).children()[2]).text(); // Id mỗi sản phẩm
			var productPrice = $($($(parent).children()[2]).children()[1])
					.text(); // Giá mỗi sản phẩm
			var productAmount = $($(parent).children()[3]).text(); // Số lượng mỗi sản phẩm
			var previousTotalItem = $($('.totalItem').children()[1]).text(); // Lấy tổng số lượng sản phẩm ban đầu
			$($('.totalItem').children()[1]).text(previousTotalItem - 1); // Trừ đi tổng số lượng sản phẩm khi xóa
			$('.total-price').text(
					$('.total-price').text() - productPrice * productAmount); // Trừ đi tổng giá sản phẩm khi xóa
			$($('.totalPrice').children()[1]).text(
					$($('.totalPrice').children()[1]).text() - productPrice
							* productAmount) // Trừ đi tổng giá sản phẩm khi xóa
			$(parent).remove(); // Xóa sản phẩm ở DOM
			$.ajax({
				url : "/QUANLYCUAHANG/DeleteProductInCart",
				type : "get",
				data : {
					productId : id
				},
				success : function(data) {
					console.log('success');
				},
				error : function(xhr) {
					console.log("error");
				}
			});
		};

		function plusNumberItem(e) {
			// cộng 1 số lượng và cộng tổng tiền theo giá của mỗi sản phẩm
			var parent = $(e).parent();
		}

		function minusNumberItem(e) {

		}

		function checkOut() {
			var idArray = $('.productId').map(function() {
				return parseInt($.trim($(this).text()));
			}).get();

			if (idArray.length === 0) {
				alert('Hãy thêm sản phẩm vào giỏ hàng để thanh toán nhé! <3');				
				return;
			}

			var amountArray = $('.productAmount').map(function() {
				return parseInt($.trim($(this).text()));
			}).get();

			var address = $('input.billAddress').val();

			$.ajax({
				url : "/QUANLYCUAHANG/Checkout",
				type : "post",
				data : {
					ids : JSON.stringify(idArray),
					amounts : JSON.stringify(amountArray),
					billAddress : address
				},
				success : function(data) {
					alert('Đặt hàng thành công!');
					location.reload(true);
				},
				error : function(xhr) {
					var response = $.parseHTML(xhr.responseText);
					if (xhr.status == 501) {
						alert($(response).filter('h1').text());
					}
				}
			});
		}
		function plusItem(e) {
			var total1 = $($('.totalPrice').find('span'));
			var total2 = $('.total-price');
			var parent = $(e).parent();
			var productPrice = parseInt($($(parent).next()).text());
			var amount = $(e).prev();
			var value = parseInt($(amount).text());
			value += 1;
			$(total1).text(parseInt($(total1).text())+productPrice);
			$(total2).text($(total1).text());
			$(amount).text(value);
		}
		function minusItem(e) {
			var total1 = $($('.totalPrice').find('span'));
			var total2 = $('.total-price');
			var parent = $(e).parent();
			var productPrice = parseInt($($(parent).next()).text());
			var amount = $(e).next();
			var value = parseInt($(amount).text());
			if (value == 1)
				return;
			value -= 1;
			$(total1).text($(total1).text()-productPrice);
			$(total2).text($(total1).text());
			$(amount).text(value);
		}
	</script>
</body>
</html>