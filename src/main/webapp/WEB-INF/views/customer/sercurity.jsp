<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Security</title>
    <base href="${pageContext.servletContext.contextPath }/">
    <link rel="title icon" href="/resources/my_png/Logo-byOanh.png">
    <link rel="stylesheet" type="text/css" href="/resources/my_css/sercurity.css"/>
    <script src="https://kit.fontawesome.com/0e7ed669fa.js"></script>
</head>
<body>
    <div class="header">
        <div class="logo">
            
            <img src="my_png/Logo-byOanh.png" >
            <h2>Acount Center</h2>
        </div>
        <div class="loginName">
            <span>huynh2k7</span>
            <a href="">Đăng xuất</a>
        </div>
    </div>

    <div class="container">
        <div class="list">
            <ul>
                <li>Thông tin cá nhân</li>
                <li>Thay đổi mật khẩu</li>
                <li>Thay đổi email</li>
            </ul>
        </div>
        <div class="boxChange">
            <div class="boxInfo">
                <form action="">
                    <h2>Thông tin của bạn: </h2>
                    <ion-icon class="closeBoxChange" name="close"></ion-icon>
                    <div class="nameChange">
                        <span class="titleChange"><i class="fa-solid fa-signature"></i>Tên</span >
                        <input type="text" value="Nguyễn Đăng Bắc">
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <div class="addressChange">
                        <span class="titleChange"><i class="fa-solid fa-location-dot"></i> Địa chỉ</span >
                        <textarea name="" id="" rows="2"></textarea>
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <div class="phoneChange">
                        <span class="titleChange"><ion-icon name="call"></ion-icon> Số điện thoại</span >
                        <input type="text">
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <button>Lưu thay đổi</button>
                </form>
            </div>
            <div class="emailChange">
                <form action="">
                    <h3>ĐỔI EMAIL MỚI</h3>
                    <div class="note-mail">
                        <small>Ấn nút lấy mã để nhận mã xác nhận qua email!</small>
                    </div>
                    <div class="email-container">
                        <span class="titleChange titleEmailChange"><i class="fa-solid fa-at"></i> Email</span >
                            <span class="originalInfo mailOriginal">dangbac872001@gmail.com</span>
                            <span class="boxChangeEmail">
                                <p>
                                    <input type="text" name="" id="">
                                </p>
                                <p>
                                    <input type="text" placeholder="Nhập mã xác thực" value="">
                                    <span><button>Lấy mã</button></span>
                                </p>
                            </span>
                        <button class="emailFixButton"><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button>

                    </div>
                    <button>Lưu thay đổi</button>
                </form>
            </div>

            <div class="passChange">
                <form action="">
                    <h3>ĐỔI MẬT KHẨU</h3>
                    <div class="changePassContainer">
                        <span class="boxChangePass">
                            <p>
                                <span>Mật khẩu hiện tại</span> 
                                <input type="password" name="" id="">
                            </p>
                            <p>
                                <span>Mật khẩu mới</span> 
                                <input type="password" name="" id="">
                            </p>
                            <p>
                                <span>Nhập lại mật khẩu mới</span> 
                                <input type="password" name="" id="">
                            </p>
                        </span>		
                    </div>	
                    <button class="saveChange">Lưu thay đổi</button>
                </form>
            </div>
            
        </div>
    </div>
    <script type="text/javascript" src="my_js/sercurity.js" ></script>
</body>
</html>
