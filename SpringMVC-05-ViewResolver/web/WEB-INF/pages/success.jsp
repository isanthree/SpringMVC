<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>跳转成功！！！</h1>

pageContext：${pageScope.msg}<br/>
request：${requestScope.msg}<br/>
session：${sessionScope.msg}-${sessionScope.hhh}<br/>
application：${applicationScope.msg}<br/>

</body>
</html>
