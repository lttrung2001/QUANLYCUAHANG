<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My cart</title>
    <base href="${pageContext.servletContext.contextPath }/">
    <script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/my_css/CSS-Cart.css'/>">
</head>
<body>
	<c:set var="totalPrice" value="${0}"/>
    <div class="shoppingCart">
        <div class="productCart">
            <h2>LIST YOUR PRODUCT:</h2>
            <div class="items">
            	<c:forEach var="c" items="${cart }">
                <div class="item">
                    <img src="<c:url value='${c.productInCart.image }'/>" >
                    <div class="nameItem">
                        <div class="typeItem">${c.productInCart.id }</div>
                        <div class="detailItem">${c.productInCart.desc }</div>
                        <div class="sizeItem">Size[L]</div>
                    </div>
                    <div class="numberItem">
                        <button><i class="fa-solid fa-minus"></i></button>
                        <small>${c.amount }</small>
                        <button><i class="fa-solid fa-plus"></i> </button>               
                    </div>
                    <div class="price">${c.productInCart.price }</div>
                    <button onclick= "deleteProductInCart(this);" ><i class="fa-solid fa-xmark"></i></button>
                </div>
                <c:set var="totalPrice" value="${totalPrice + c.productInCart.price*c.amount}" />
                </c:forEach>
            </div>
            <div class="backShop">
                <a  href="#"><ion-icon name="return-up-back-outline"></ion-icon>Back to shop</a>
            </div>
        </div>
        <div class="checkout">
            <div class="detailCheckout">
                <div class="cartIcon">
                    <img src="/resources/my_png/Logo-byOanh.png" alt="">
                </div>
                <div class="totalItem">
                    <h4>ITEMS</h4>
                    <span>${fn:length(cart) }</span>
                    <span class="total-price"><c:out value="${totalPrice }"></c:out></span>
                </div>
            </div>
            <div class="shipping">
                <h4>SHIPPING</h4>
                <select name="Normal" id="">
                    <option value="">Normal-20$</option>
                    <option value="">Fast-35$</option>
                </select>
            </div>
            <div class="sale">
                <h4>SALE: </h4>
                <span>0</span>
            </div>
            <div class="totalPrice">
                <h4>TOTAL PRICE</h4>
                <span><c:out value="${totalPrice }"></c:out></span>
            </div>
            <button>CHECKOUT</button>
            
        </div>
    </div>
   	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		function deleteProductInCart(e) {
			console.log(e);
			var parent = $(e).parent();
			console.log(parent);
			var id = $($($(parent).children()[1]).children()[0]).text();
			var productPrice = $($($(parent).children()[2]).children()[1]).text();
			var productAmount = $($(parent).children()[3]).text();
			var previousTotalItem = $($('.totalItem').children()[1]).text();
			$($('.totalItem').children()[1]).text(previousTotalItem-1);
			console.log(productPrice*productAmount);
			$('.total-price').text($('.total-price').text()-productPrice*productAmount);
			$($('.totalPrice').children()[1]).text($($('.totalPrice').children()[1]).text()-productPrice*productAmount)
			$(parent).remove();
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
	</script>
</body>
</html>