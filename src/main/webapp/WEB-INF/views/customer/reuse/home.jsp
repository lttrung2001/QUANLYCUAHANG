<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<section id="home">
    <div class="header-object">
        <div id="content-page">${fn:toUpperCase(part) }</div>
    </div>
    
    <div class="container-object" >
	<c:forEach var="p" items="${products }">
	    <div class="items">
	        <figure>
	            <img src="<c:url value='${p.image }'/>" alt="" class="img-items">
	            <p  class="price-item">${p.price }</p>
                    <p style="display: none;" class="describe-item">${p.desc }</p>
	            <a href="#"><p>${p.name }</p></a>
	        </figure>
	        <div class="buy-item">
	            <h2>BUY NOW</h2>
	        </div>
	    </div>
	</c:forEach>
	</div>
    <ul id="listImages"></ul>
    <!-- select Item  -->
    <div class="select-item">
        <div class="object-select">
            <img src="" >
        </div>
        <div class="prev-object">
            <ion-icon name="chevron-back-outline"></ion-icon>
        </div>
        <div class="next-object">
            <ion-icon name="chevron-forward-outline"></ion-icon>
        </div>
        <div class="right-object">
            <i id="cart-icon-object" class="fa-solid fa-cart-arrow-down"></i>
            <div class="idObject_nameObject">
		<p>Name:</p>				
		<span class="nameObject">Hoodie</span>
		<span>( </span>
		<span class="idObject">H123</span>
		<span> )</span>
	    </div>
            <div  class="describe-object">
		<strong>Mô tả:</strong>
		<p></p>
	    </div>
            <div class="total-object">
                <button class="subtract-total"><ion-icon name="remove"></ion-icon></button>
                <p>0</p>
                <button class="add-total"><ion-icon name="add-outline"></ion-icon></button>
            </div>	
            <span>Total:</span>
            <div class="price-object">
                
            </div>
            <div class="confirm-object">
                <button>Add to cart</button>
            </div>
        </div>
        <button class="close-object"><ion-icon name="close"></ion-icon></button>
    </div>
    <!-- End of select Item  -->
</section>
