<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath }/">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="title icon" href="<c:url value='/resources/my_png/Logo-byOanh.png'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/my_css/StyleDashboard.css'/>"/>
    <!-- <script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>     -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://kit.fontawesome.com/0e7ed669fa.js" crossorigin="anonymous"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
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
                            <a>
                                <span class="icon"><i class="fa-solid fa-bullhorn"></i></span>
                                <span class="title">Thông báo</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="admin/donhang/index.htm">
                                <span class="icon"><i class="fa-solid fa-pen-to-square"></i></span>
                                <span class="title">Quản lý đơn hàng</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="admin/product/productType.htm">
                                <span class="icon"><i class="fa-solid fa-clipboard-list"></i></span>
                                <span class="title">Quản lý loại sản phẩm</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="admin/product/index.htm">
                                <span class="icon"><i class="fa-solid fa-shirt"></i></span>
                                <span class="title">Quản lý sản phẩm</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="admin/customer/index.htm">
                                <span class="icon"><i class="fa-solid fa-users"></i></span>
                                <span class="title">Quản lý khách hàng</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="admin/thongke/index.htm">
                                <span class="icon"><i class="fa-solid fa-chart-line"></i></span>
                                <span class="title">Thống kê</span>
                            </a>
                        </li>
                        <li class="objectManagement">
                            <a href="home.htm">
                                <span class="icon"><i class="fa-solid fa-shop"></i></span>
                                <span class="title" >My Shop</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div id="accountLogin">
                <img src="<c:url value='/resources/my_image/Customer Images/IMGcab.jpg'/>" alt="" >
                <a>${sessionScope.admin.fullname }</a>
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
                <%@include file="/WEB-INF/views/shop/reuse/ThongKe.jsp" %>

                
            </div>
            <!-- end of Main and search -->
        </div>
        
    </div>

    
    <script type="text/javascript" src="<c:url value='/resources/my_js/Db.js'/>"></script>
</body>

</html>