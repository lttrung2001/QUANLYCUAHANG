<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify email</title>
<base href="${pageContext.servletContext.contextPath }/">
</head>
<body>
<form action="verify.htm?username=${account.username }" method="post">
	<h1>Kích hoạt tài khoản bằng cách nhập code nhận được từ email: ${account.email } vào ô bên dưới!</h1>
	<h4>Code: </h4><input name="code" placeholder="Nhập mã code vào đây">
	<button>Kích hoạt</button>
</form>
</body>
</html>