<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify email</title>
<base href="${pageContext.servletContext.contextPath }/">
</head>
<style>
	form {
		width: 500px;
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	    background-image: linear-gradient(to bottom right, #1E8F00, #9BCD00);
	    border-radius: 16px;    
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    padding: 16px;
	}
	form input {
		padding: 4px 8px;
	    border-radius: 4px;
	    border: none;
	    font-size: 16px;
	}
	form button {
		margin-top: 4px;
	    padding: 4px 16px;
	    border: none;
	    border-radius: 4px;
	    font-size: 16px;
	}
	form h4 {
		font-size: 16px;
	}
	span.error-msg {
			display: inline-block;
			margin-top: 8px;
			color: red;
		}
</style>
<body>
<form:form action="verify.htm?username=${account.username }" method="post" modelAttribute="account">
	<h1>Kích hoạt tài khoản</h1>
	<div><h4>Code: </h4><form:input path="code" name="code" placeholder="Nhập mã code vào đây"/></div>
	<form:errors cssClass="error-msg" path="code"></form:errors>
	<button>Xác nhận</button>
</form:form>
</body>
</html>