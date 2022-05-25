<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="${pageContext.servletContext.contextPath }/">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="title icon" href="<c:url value='/resources/my_png/Logo-byOanh.png'/>"> 
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/my_css/StyleDashboard.css'/>">
    <!-- <script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>     -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<!--     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<!--     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
<!-- 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> -->
<!-- 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> -->
    <title>Cab Shop Managerment</title>
</head>
<body>
    <div id="facePage">
        <div class="mainMenu">
            <div class="logoManagement">
                <img class="imgLogoManagement" src="<c:url value='/resources/my_png/Logo-byOanh.png'/>" alt="CAB Shop"> 
                <h2>Management</h2>
            </div>
            <div class="container">
                <div class="navigation">
                    <ul>
                        <li class="objectManagement">
                            <a href="#">
                                <span class="icon"><i class="fa-solid fa-bullhorn"></i></span>
                                <span class="title">Thông báo</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="#">
                                <span class="icon"><i class="fa-solid fa-pen-to-square"></i></span>
                                <span class="title">Quản lý đơn hàng</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="#">
                                <span class="icon"><i class="fa-solid fa-clipboard-list"></i></span>
                                <span class="title">Quản lý loại sản phẩm</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="<c:url value='admin/product/index.htm'/>">
                                <span class="icon"><i class="fa-solid fa-shirt"></i></span>
                                <span class="title">Quản lý sản phẩm</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="<c:url value='admin/customer/index.htm'/>">
                                <span class="icon"><i class="fa-solid fa-users"></i></span>
                                <span class="title">Quản lý khách hàng</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="<c:url value='admin/thongke/index.htm'/>">
                                <span class="icon"><i class="fa-solid fa-chart-line"></i></span>
                                <span class="title">Thống kê</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="index.html">
                                <span class="icon"><i class="fa-solid fa-shop"></i></span>
                                <span class="title" >My Shop</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div id="accountLogin" >
                <img src="<c:url value='/resources/my_image/Customer Images/IMGcab.jpg'/>" alt="" >
                <a href="#">${sessionScope.admin.fullname }</a>
            </div>
        </div>
        

<!-- data -->
        <div id="data">
            <div class="admin">
                <button href="#">Login</button>
            </div>
            <div class="formLogin">
                <form action="">
                    <div class="loginBox">
                        <div class="user">
                            <span class="iconUser"><box-icon type='solid' name='user'></span>
                            <input type="text" placeholder="Enter Username" id="user" value="">
                        </div>
                        <div class="pass">
                            <span class="iconPass"><box-icon name='lock-alt' type='solid' ></box-icon></span>
                            <input type="password" placeholder="Enter Password" id="pass" value="">
                        </div>
                    </div>
                    <button>Login</button>
                    <div class="remember">
                        <input type="checkbox" >Remember
                    </div>
                </form>
            </div>
            <!-- Main and search -->
            <div class="main"> <!-- thống kê -->    
                <!-- topbar -->
                <div class="topbar">
                    <div class="toggle">
                        <i class="fa-solid fa-bars"></i>
                    </div>
                </div>
                <!-- end of topbar -->
                <%@include file="/WEB-INF/views/shop/reuse/SanPham.jsp" %>
                

                
            </div>
            <!-- end of Main and search -->
        </div>
        
    </div>

    
    <script type="text/javascript" src="<c:url value='/resources/my_js/Db.js'/>"></script>
</body>
</html>