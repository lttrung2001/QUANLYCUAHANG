<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Security</title>
    <base href="${pageContext.servletContext.contextPath }/">
    <link rel="title icon" href="<c:url value='/resources/my_png/Logo-byOanh.png'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/my_css/sercurity.css'/>"/>
    <script src="https://kit.fontawesome.com/0e7ed669fa.js"></script>
    <style>
		span.error-msg {
			display: inline-block;
			margin-top: 8px;
			color: red;
		}
	</style>
</head>
<body>
    <div class="header">
        <div class="logo">
            
            <img src="<c:url value='/resources/my_png/Logo-byOanh.png'/>" >
            <h2>Acount Center</h2>
        </div>
        <div class="loginName">
            <span>${account.username }</span>
            <a href="logout.htm">Đăng xuất</a>
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
                <form:form action="account/info.htm" method="post" modelAttribute="info">
                    <h2>Thông tin của bạn: </h2>
                    <form:input cssStyle="display: none;" path="id"/>
                    <ion-icon class="closeBoxChange" name="close"></ion-icon>
                    <div class="nameChange">
                        <span class="titleChange"><i class="fa-solid fa-signature"></i>Họ</span >
                        <form:input path="lastName" type="text"/>
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <form:errors path="lastName" cssClass="error-msg"></form:errors>
                     <div class="nameChange">
                        <span class="titleChange"><i class="fa-solid fa-signature"></i>Tên</span >
                        <form:input path="firstName" type="text"/>
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <form:errors path="firstName" cssClass="error-msg"></form:errors>
                    <div class="addressChange">
                        <span class="titleChange"><i class="fa-solid fa-location-dot"></i> Địa chỉ</span >
                        <form:textarea path="address" name="" id="" rows="2"></form:textarea>
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <form:errors path="address" cssClass="error-msg"></form:errors>
                    <div class="phoneChange">
                        <span class="titleChange"><ion-icon name="call"></ion-icon> Số điện thoại</span >
                        <form:input path="phoneNumber" type="text"/>
                        <!-- <button ><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button> -->
                    </div>
                    <form:errors path="phoneNumber" cssClass="error-msg"></form:errors>
                    <form:button>Lưu thay đổi</form:button>
                </form:form>
            </div>
            <div class="emailChange">
                <form:form action="account/email.htm" method="post" modelAttribute="account">
                	<form:input cssStyle="display: none;" path="username"/>
                    <h3>ĐỔI EMAIL MỚI</h3>
                    <div class="note-mail">
                        <small>Ấn nút lấy mã để nhận mã xác nhận qua email!</small>
                    </div>
                    <div class="email-container">
                        <span class="titleChange titleEmailChange"><i class="fa-solid fa-at"></i> Email</span >
                            <span class="originalInfo mailOriginal">${account.email }</span>
                            <span class="boxChangeEmail">
                                <p>
                                    <form:input path="email" type="email" name="" id=""/>
                                </p>
                                <form:errors path="email" cssClass="error-msg"></form:errors>
                                <p>
                                    <form:input path="code" type="text" placeholder="Nhập mã xác thực"/>
                                    <span><button>Lấy mã</button></span>
                                </p>
                                <form:errors path="code" cssClass="error-msg"></form:errors>
                            </span>
                        <button class="emailFixButton"><i class="fa-solid fa-pencil" style="font-size: 14px;"></i> Chỉnh sửa</button>
                    </div>
                    <form:button>Lưu thay đổi</form:button>
                </form:form>
            </div>

            <div class="passChange">
                <form:form action="account/password.htm" modelAttribute="account">
                	<form:input cssStyle="display: none;" path="username"/>
                    <h3>ĐỔI MẬT KHẨU</h3>
                    <div class="changePassContainer">
                        <span class="boxChangePass">
                            <p>
                                <span>Mật khẩu hiện tại</span> 
                                <input id="currentPassword" type="password" name="currentPassword" id="">
                            </p>
                            <p>
                                <span>Mật khẩu mới</span> 
                                <input class="password-1" type="password" name="password-1" id="">
                            </p>
                            <p>
                                <span>Nhập lại mật khẩu mới</span> 
                                <input type="password" name="password-2" class="password-2" />
                            </p>
                            <form:errors path="password" cssClass="error-msg"></form:errors>
                        </span>		
                    </div>	
                    <button class="saveChange">Lưu thay đổi</button>
                </form:form>
            </div>
            
        </div>
    </div>
    <script type="text/javascript" src="<c:url value='/resources/my_js/sercurity.js'/>"></script>
</body>
</html>
