<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>欢迎来到登录页面！</h1>

<h1>
    <fmt:message key="welcomeInfo"/>
</h1>

<form action="">
    <fmt:message key="username"/>：<input/><br/>
    <fmt:message key="password"/>：<input/><br/>
    <input type="submit" value="<fmt:message key="loginBtn"/>">
</form>

</body>
</html>
