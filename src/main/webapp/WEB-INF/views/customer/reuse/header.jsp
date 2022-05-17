<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header">
    <nav class="container">
        <a  id="logo" href="#home">
            <img src="<c:url value='/resources/my_png/Logo-byOanh.png'/>" alt="CAB Shop">				
        </a>
        
        <ul id="main-menu">
            <li><a class="style-menu " href="home.htm" >HOME</a></li>
            <li class="Option"><a class="style-menu" href="top.htm">TOP</a>
                <ul class="top-menu sub-menu ">
                	<c:forEach var="pt" items="${productTypeTop }">
                		<li><a href="top/${pt.proTypeId }.htm" onclick="notification_option()">${pt.proTypeName }</a></li>
                	</c:forEach>
                </ul>
            </li>
            
            <li class="Option"><a class="style-menu" href="bot.htm" >BOT</a>
                <ul class="bot-menu sub-menu">
	                <c:forEach var="pt" items="${productTypeBot }">
                		<li><a href="bot/${pt.proTypeId }.htm" onclick="notification_option()">${pt.proTypeName }</a></li>
                	</c:forEach>
                </ul>
            </li>
            <li class="Option"><a class="style-menu" href="#">SALE</a>
                <ul class="sale-menu sub-menu">
                    <li><a href="#" onclick="notification_option()">90%</a></li>
                    <li><a href="#" onclick="notification_option()">70%</a></li>
                    <li><a href="#" onclick="notification_option()">50%</a></li>
                </ul>

            </li>
            <!-- <li><a href="#contact" class="style-menu">CONTACT</a></li> -->
        </ul>
        <div id="header-icon">
            <!-- <span id="icon-account"> <ion-icon name="person-circle"></ion-icon></span> -->
            <div class="icon-button-header">
                <button id="icon-person-btn" ><ion-icon name="person-outline"></ion-icon></button>
                <ul id="login_signup" class="hideAccount">
                    <li><button type="button" id="Login">Log in</button></li>
                    <li><button type="button" id="Signup">Sign up</button></li>
                </ul>
            </div>
            <div class="iconLogged">
                <button><ion-icon name="person"></ion-icon></button>
                <ul class="menuLogged hide">
                    <li class="changeInfor"><a href="#">Thay đổi thông tin</a></li>
                    <li class="history"><a href="#">Lịch sử</a></li>
                    <li class="logOut"><a href="#">Đăng xuất</a></li>
                </ul>
            </div>
            <div class="icon-button-header">
                <button id="icon-search-btn" ><ion-icon name="search-outline" ></ion-icon></button>
                <div class="search-input hide" >
                    <form class="search-form" action="${part }.htm">
                        <input  type="text" placeholder="Search.." name="search">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
            <div class="icon-button-header iconCart">
                <button id="icon-bag-btn"><a href="Cart.html"><ion-icon name="cart-outline"></ion-icon></a></button>
                <small id="icon-cart">
                    0
                </small>
            </div>
        </div>
    </nav>
</div>
<!-- Dynamic background -->
    <div class="dynamic_background">
        <div class="b-left"></div>
        <div class="b-right"></div>
    </div>
    
<!-- End of Dynamic background -->